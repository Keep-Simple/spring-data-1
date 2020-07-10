package com.bsa.springdata.office;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {

    @Query("select o from Office o " +
            "inner join o.users u " +
            "inner join u.team t " +
            "inner join t.technology tech " +
            "where tech.name = :technology " +
            "group by o.id")
    List<Office> getByTechnology(String technology);


    @Transactional
    @Query(value = "update offices " +
            "set address = case" +
            " when not exists(select offices.id from offices" +
            "    left join users u on u.office_id = offices.id" +
            "    left join teams t on u.team_id = t.id" +
            "        where offices.address = :oldAddress and t.project_id is null " +
            "        group by offices.id) " +
            "then :newAddress else :oldAddress end " +
            "where offices.address = :oldAddress " +
            "returning *",
            nativeQuery = true)
    Office updateAddress(String oldAddress, String newAddress);

}

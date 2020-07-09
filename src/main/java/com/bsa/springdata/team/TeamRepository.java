package com.bsa.springdata.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    Optional<Team> findByName(String teamName);

    int countByTechnologyName(String newTechnology);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
    value = "update teams as tt " +
            "set name = concat(tt.name,'_',p.name,'_',t.name) " +
            "from projects as p, technologies as t " +
            "where tt.name = :teamName and p.id = tt.project_id and t.id = tt.technology_id")
    void normalizeName(String teamName);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
    value = "update technologies as tech " +
            "set name = :newTech " +
            "from teams as tt " +
            "where tech.name = :oldTech and " +
            "(select count(*) from teams inner join users u on teams.id = u.team_id where u.team_id = tt.id) < :num")
    void updateTechWhereLessThen(int num, String oldTech, String newTech);

}

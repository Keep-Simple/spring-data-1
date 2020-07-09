package com.bsa.springdata.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {

    @Transactional
    @Modifying
    @Query("delete from Role r where r.code = :roleCode and r.users.size = 0")
    void deleteByCodeIfNoUsers(String roleCode);
}

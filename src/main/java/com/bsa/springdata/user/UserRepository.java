package com.bsa.springdata.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findByLastNameStartsWithIgnoreCase(String lastname, Pageable pg);

    List<User> findByOfficeCity(String city, Sort sort);

    List<User> findByExperienceGreaterThanEqual(int exp, Sort sort);

    List<User> findByOfficeCityAndTeamRoom(String city, String room, Sort sort);

    int deleteByExperienceLessThan(int exp);
}

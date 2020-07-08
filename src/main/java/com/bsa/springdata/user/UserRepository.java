package com.bsa.springdata.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    List<User> findAllByLastNameStartsWithIgnoreCase(String lastname, Pageable pg);
}

package com.avantia.crud.repository;

import com.avantia.crud.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String name);
    Boolean existsByName(String name);
}

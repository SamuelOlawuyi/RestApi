package com.example.classactivity.repositories;

import com.example.classactivity.entities.FacebookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<FacebookUser, Long> {
    boolean existsByEmail(String email);
    Optional<FacebookUser> findByEmail(String email);


    FacebookUser findByName(String name);
//    Optional<FacebookUser> findByUsername(String username);

}


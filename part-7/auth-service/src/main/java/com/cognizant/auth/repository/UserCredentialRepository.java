package com.cognizant.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.auth.entity.UserCredential;

import java.util.Optional;

public interface UserCredentialRepository  extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String name);
}

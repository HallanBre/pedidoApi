package com.ads4.lojaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ads4.lojaonline.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {
    
}

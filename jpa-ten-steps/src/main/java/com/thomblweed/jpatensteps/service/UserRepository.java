package com.thomblweed.jpatensteps.service;

import com.thomblweed.jpatensteps.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
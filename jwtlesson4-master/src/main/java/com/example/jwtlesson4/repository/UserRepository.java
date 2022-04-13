package com.example.jwtlesson4.repository;

import com.example.jwtlesson4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
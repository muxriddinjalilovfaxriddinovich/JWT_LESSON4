package com.example.jwtlesson4.repository;

import com.example.jwtlesson4.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutcomeRepository extends JpaRepository<Outcome, Integer> {
}
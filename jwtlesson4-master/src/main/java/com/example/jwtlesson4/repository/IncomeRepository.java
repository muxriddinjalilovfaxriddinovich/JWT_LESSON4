package com.example.jwtlesson4.repository;

import com.example.jwtlesson4.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Integer> {
}
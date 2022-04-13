package com.example.jwtlesson4.repository;

import com.example.jwtlesson4.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, Integer> {
    List<Card> findAllByUser_Id(UUID id);
}
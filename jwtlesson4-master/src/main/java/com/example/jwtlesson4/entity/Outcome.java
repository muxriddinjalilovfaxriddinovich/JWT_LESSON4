package com.example.jwtlesson4.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "outcome")
public class Outcome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer fromCardId;

    private Integer toCardId;

    private Double amount;

    private Double commissionAmount;

    @CreationTimestamp // yaratgan vaqtida saqlab ketadi
    private Timestamp createdAt;

}

package com.example.jwtlesson4.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @ManyToOne //  1ta odamda ko'p karta
    private User user;

    @Column(unique = true)
    private String number;

    private Double price;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date expireDate;

    private boolean active = true;

    public Card(String username, String number, Double price) {
        this.username = username;
        this.number = number;
        this.price = price;
    }
}

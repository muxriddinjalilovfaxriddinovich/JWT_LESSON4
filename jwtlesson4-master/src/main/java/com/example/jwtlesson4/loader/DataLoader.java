package com.example.jwtlesson4.loader;

import com.example.jwtlesson4.entity.Card;
import com.example.jwtlesson4.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
public class DataLoader// implements CommandLineRunner
{

//    private final CardRepository cardRepository;
//
//    @Value(value = "${spring.jpa.hibernate.ddl-auto}")
//    static String ddl;
//    @Override
//    public void run(String... args) throws Exception {
//
//        if (ddl.equals("create")){
//            Card card1 = new Card("Xalq Banki","123",60000.0);
//            Card card2 = new Card("Infin Banki","124",60000.0);
//            Card card3 = new Card("Tokio Banki","122",60000.0);
//            Card card4 = new Card("London Banki","121",60000.0);
//
//            cardRepository.save(card1);
//            cardRepository.save(card2);
//            cardRepository.save(card3);
//            cardRepository.save(card4);
//
//        }
//    }
}

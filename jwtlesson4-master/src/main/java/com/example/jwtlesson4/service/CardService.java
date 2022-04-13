package com.example.jwtlesson4.service;

import com.example.jwtlesson4.controller.ApiResponse;
import com.example.jwtlesson4.entity.Card;
import com.example.jwtlesson4.entity.Income;
import com.example.jwtlesson4.entity.Outcome;
import com.example.jwtlesson4.entity.User;
import com.example.jwtlesson4.payload.CardDTO;
import com.example.jwtlesson4.repository.CardRepository;
import com.example.jwtlesson4.repository.IncomeRepository;
import com.example.jwtlesson4.repository.OutcomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CardService {

    private final CardRepository cardRepository;
    private final OutcomeRepository outcomeRepository;
    private final IncomeRepository incomeRepository;

    public ApiResponse pay(CardDTO dto) {

        Integer receiverCardId = dto.getReceiverCardId();
        Integer senderCardId = dto.getSenderCardId();

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Card> receiverOptionalCard = cardRepository.findById(receiverCardId);
        Optional<Card> senderOptionalCard = cardRepository.findById(senderCardId);

        if (receiverOptionalCard.isEmpty() || senderOptionalCard.isEmpty()){
            return new ApiResponse("Something went wrong",false);
        } else {
            Card sender_card = senderOptionalCard.get(); // outcome
            Card receiver_card = receiverOptionalCard.get(); // income


            // outcome :
            Outcome outcome = new Outcome();

            outcome.setFromCardId(senderCardId);
            outcome.setToCardId(receiverCardId);
            outcome.setAmount(dto.getAmount());
            outcome.setCommissionAmount(dto.getAmount() * dto.getCommissionFee()/100);
            outcomeRepository.save(outcome);
            // tugadi

            // income :
            Income income = new Income();

            income.setFromCardId(senderCardId);
            income.setToCardId(receiverCardId);
            income.setAmount(dto.getAmount());

            incomeRepository.save(income);


            return new ApiResponse("success",true,outcome);
        }




    }

    public ApiResponse incomeHistory() {

        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Card> cardList = cardRepository.findAllByUser_Id(principal.getId());

        List<Income> incomes = null;
        for (Card card : cardList) {
            Income income = incomeRepository.getById(card.getId());
            incomes.add(income);
        }

        return new ApiResponse("All history of incomes ",true,incomes);
    }

    public ApiResponse outcomeHistory() {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Card> cardList = cardRepository.findAllByUser_Id(principal.getId());

        List<Outcome> outcomes = null;
        for (Card card : cardList) {
            Outcome outcome = outcomeRepository.getById(card.getId());
            outcomes.add(outcome);
        }

        if (outcomes == null) {
            return new ApiResponse("There is no outcomes yet",true);
        }

        return new ApiResponse("All outcomes",true,outcomes);
    }
}

package com.ssafy.iNine.FinancialAPI.card.service;

import com.ssafy.iNine.FinancialAPI.card.dto.CardDto;
import com.ssafy.iNine.FinancialAPI.card.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;


@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public List<CardDto.CardResponseDto> generateUserCards() {
        int cardCnt = ThreadLocalRandom.current().nextInt(1, 11);

        List<CardDto.CardResponseDto> cards = new ArrayList<>();

        for (int i = 0; i < cardCnt; i++) {
            CardDto.CardResponseDto card = generateRandomCard();
            cards.add(card);
        }
        return cards;
    }

  private CardDto.CardResponseDto generateRandomCard() {
        //  랜덤한 카드 정보 생성
      UUID cardId = UUID.randomUUID();
      String cardNum = generateRandomCardNum();
      String cardName = generateRandomCardName();
      int cardMember = generateRandomCardMember();
      String cardType = generateRandomCardType();
      boolean isConsent = generateRandomIsConsent();

        return CardDto.CardResponseDto.builder()
                .cardId(cardId.toString())
                .cardNum(cardNum)
                .cardName(cardName)
                .cardMember(cardMember)
                .cardType(cardType)
                .isConsent(isConsent)
                .build();

    }

    private String generateRandomCardNum() {
        Random random = new Random();
        long cardNumber = ThreadLocalRandom.current().nextLong(10_0000_0000_0000_0000L, 100_0000_0000_0000_0000L);
        String maskedCardNumber = maskCardNumber(cardNumber);
        return maskedCardNumber;
    }

    private String maskCardNumber(long cardNumber) {
        String cardNumberStr = String.valueOf(cardNumber);
        return cardNumberStr.substring(0, 6) + "******" + cardNumberStr.substring(12);
    }

    private String generateRandomCardName() {
        String[] cardNames = {"롯데", "비씨", "신한", "삼성", "우리", "하나", "현대", "KB국민"};
        return cardNames[new Random().nextInt(cardNames.length)];
    }



    private int generateRandomCardMember() {
        return new Random().nextDouble() < 0.1 ? 2 : 1;
    }

    private String generateRandomCardType() {
        String[] cardTypes = {"01", "02", "03"};
        return cardTypes[new Random().nextInt(cardTypes.length)];
    }

    private Boolean generateRandomIsConsent() {
        return new Random().nextBoolean();
    }




}

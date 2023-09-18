package com.ssafy.iNine.FinancialAPI.card.service;

import com.ssafy.iNine.FinancialAPI.card.dto.CardDto;
import com.ssafy.iNine.FinancialAPI.card.repository.CardRepository;
import com.ssafy.iNine.FinancialAPI.entity.Card;
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


    // userId로 카드 정보 저장된게 있는지 찾고 없으면 카드 더미 데이터를 생성하고 있으면 기존 카드 정보를 반환해줌....
    public CardDto.CardResponseDto getUserCardList(CardDto.CardRequestDto cardRequestDto) {
        List<Card> cardList = cardRepository.findByUserId(cardRequestDto.getUserId());
        CardDto.CardResponseDto cardResponse = new  CardDto.CardResponseDto();

        //페이지네이션
        String nextPage = cardRequestDto.getNextPage();
        Integer limit = cardRequestDto.getLimit();


        if (cardList == null) {
            List<CardDto.CardDataDto> newCard = generateUserCards();


            cardResponse.of(nextPage, newCard.size(), newCard);
            // nextPage는 다음 페이지 요청을 위한 기준 개체, 처음 API 호출 시에는 해당 정보를 세팅하지 않으며 다음 페이지 요청 시 직전 조회의 응답에서 얻은 기준개체 세팅
            // limit(최대 조회 개수, 기준개체 이후 반환될 개체의 개수) 개수를 안넘으면 nextPage는 null이고 넘으면 limit + 1 값을 nextPage로...


        } else {
            // cardList가 null이 아닌 경우 cardList의 값들을 cardResponse에 담기
            /* limit를 기준으로 cardList의 카드 개수가 limit를 넘는 경우에는 limit만큼 잘라서 반환, 마지막 개체를 nextPage로 설정
            limit 개수를 안넘는 경우에는 모든 cardList의 값들을 cardResponse에 담기*/
            if (cardList.size() <= limit) {
                cardResponse.of(nextPage, cardList.size(), );

            }
        }

        return cardResponse;
    }
    public List<CardDto.CardDataDto> generateUserCards() {
        int cardCnt = ThreadLocalRandom.current().nextInt(1, 11);

        List<CardDto.CardDataDto> cards = new ArrayList<>();

        for (int i = 0; i < cardCnt; i++) {
            CardDto.CardDataDto card = generateRandomCard();
            cards.add(card);
        }
        return cards;
    }

    private CardDto.CardDataDto generateRandomCard() {
        //  랜덤한 카드 정보 생성
        UUID cardId = UUID.randomUUID();
        String cardNum = generateRandomCardNum();
        String cardName = generateRandomCardName();
        Integer cardMember = generateRandomCardMember();
        String cardType = generateRandomCardType();
        Boolean isConsent = true;

        return CardDto.CardDataDto.builder()
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



    private Integer generateRandomCardMember() {
        return new Random().nextDouble() < 0.1 ? 2 : 1;
    }

    private String generateRandomCardType() {
        String[] cardTypes = {"01", "02", "03"};
        return cardTypes[new Random().nextInt(cardTypes.length)];
    }




}

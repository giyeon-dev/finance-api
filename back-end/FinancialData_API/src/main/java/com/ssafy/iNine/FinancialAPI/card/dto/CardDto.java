package com.ssafy.iNine.FinancialAPI.card.dto;

import com.ssafy.iNine.FinancialAPI.entity.Card;
import lombok.*;


public class CardDto {

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardRequestDto {
        private String orgCode;
        private String nextPage; //cardId 보다 큰 경우 mysql
        private int limit;

        // builder를 사용하면 객체를 빌더 패턴을 통해 생성할 수 있기 때문에 기본 생성자나 매개변수를 받는 생성자를 별도로 정의할 필요 없음?


    }

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CardResponseDto {
        private String nextPage;
        private int cardCnt;
        private long cardList;
        private String cardId;
        private String cardNum;
        private Boolean isConsent;
        private String cardName;
        private int cardMember;
        private String cardType;


        public static CardResponseDto of(Card card, String nextPage, int cardCnt, long cardList) {
            return CardResponseDto.builder()
                    .cardId(card.getCardId())
                    .cardNum(card.getCardNum())
                    .isConsent(card.getIsConsent())
                    .cardName(card.getCardName())
                    .cardMember(card.getCardMember())
                    .cardType(card.getCardType())
                    .nextPage(nextPage)
                    .cardCnt(cardCnt)
                    .cardList(cardList)
                    .build();


        }


    }
}


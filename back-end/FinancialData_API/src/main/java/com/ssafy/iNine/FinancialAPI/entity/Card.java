package com.ssafy.iNine.FinancialAPI.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@ToString(of = {"cardId", "userId", "cardNum", "isConsent", "cardName", "cardMember", "cardType"})
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardId; // 카드 식별자
    private String userId; // 사용자 ID
    private String cardNum;     // 카드 번호
    private Boolean isConsent; // 전송요구 여부
    private String cardName; // 카드상품명
    private int cardMember; // 본인/가족 구분코드 1:본인, 2: 가족
    private String cardType; // 01: 신용,  02: 체크(직불포함), 03: 소액신용체크


}

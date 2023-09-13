package com.ssafy.iNine.FinancialAPI.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Document(collection="card")
public class Card {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cardId; // 카드 식별자
    private String userId; // 사용자 ID
    private String cardNum;     // 카드 번호
    private Boolean isConsent; // 전송요구 여부
    private String cardName; // 카드상품명
    private String cardMember; // 본인/가족 구분코드 1:본인, 2: 가족
    private String cardType; // 01: 신용,  02: 체크(직불포함), 03: 소액신용체크


}

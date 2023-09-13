package com.ssafy.iNine.FinancialAPI.card.controller;

import com.ssafy.iNine.FinancialAPI.card.dto.CardDto;
import com.ssafy.iNine.FinancialAPI.card.service.CardService;
import com.ssafy.iNine.FinancialAPI.entity.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    //Cursor-Based Pagination 구현: 컨트롤러에서 요청 파라미터 받아오기
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardDto.CardResponseDto>> getUserCards(
            @PathVariable String userId,
            @RequestParam String orgCode,
            @RequestParam(required = false) String nextPage,
            @RequestParam int limit) {

        // CardService에 요청 파라미터를 전달하여 데이터 조회
        List<CardDto.CardResponseDto> cards = cardService.generateUserCards();

        //조회한 데이터를 responseEntity로 감싸서 반환
        return ResponseEntity.ok(cards);
    }



}

package com.ssafy.iNine.FinancialAPI.cardtransaction.controller;

import com.ssafy.iNine.FinancialAPI.cardtransaction.dto.CardTransactionDto;
import com.ssafy.iNine.FinancialAPI.cardtransaction.service.CardTransactionService;

import com.ssafy.iNine.FinancialAPI.common.response.DataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CardTransactionController {

    private CardTransactionService CardTransactionService;

    @GetMapping("/cards-transaction")
    public DataResponse<CardTransactionDto.CardTransactionResponseDto> transactionList(@RequestBody CardTransactionDto.CardTransactionRequestDto CardTransactionRequestDto) {
        CardTransactionDto.CardTransactionResponseDto result = CardTransactionService.getTransactionList(CardTransactionRequestDto);
        return new DataResponse<>(200, "카드 거래 내역 조회 성공", result);
    }
}

package com.ssafy.iNine.FinancialAPI.cardtransaction.service;


import com.ssafy.iNine.FinancialAPI.cardtransaction.dto.CardTransactionDto;
import com.ssafy.iNine.FinancialAPI.cardtransaction.repository.CardTransactionRepository;
import com.ssafy.iNine.FinancialAPI.entity.CardTransaction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardTransactionService {

    private final CardTransactionRepository cardTransactionRepository;

    // cardId로 거래내역 정보가 저장된게 있는지 찾고 없으면 거래내역 더미데이터 생성, 있으면 기존 거래내역 정보를 반환해줌
    public CardTransactionDto.CardTransactionResponseDto getTransactionList(CardTransactionDto.CardTransactionRequestDto  cardTransactionRequestDto) {

        // cardId로 카드 거래 내역 조회
        List<CardTransaction> transactionList = cardTransactionRepository.findByCardCardId(cardTransactionRequestDto.getCardId());

        // 거래 내역 정보가 없으면 더미 데이터 생성
//        if (transactionList == null || transactionList.isEmpty()) {
//            transactionList = generateTransaction(cardTransactionRequestDto.getCardId());
//            cardTransactionRepository.saveAll(transactionList);
//        }

        CardTransactionDto.CardTransactionResponseDto transactionResponse = new CardTransactionDto.CardTransactionResponseDto();

        return transactionResponse;

        // 페이지네이션
//        String nextPage = cardTransactionRequestDto.getNextPage();
//        Integer limit = cardTransactionRequestDto.getLimit();
    }





}

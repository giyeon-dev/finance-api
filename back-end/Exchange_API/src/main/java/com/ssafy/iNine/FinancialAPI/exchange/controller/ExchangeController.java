package com.ssafy.iNine.FinancialAPI.exchange.controller;

import com.ssafy.iNine.FinancialAPI.common.response.CommonResponse;
import com.ssafy.iNine.FinancialAPI.common.response.DataResponse;
import com.ssafy.iNine.FinancialAPI.exchange.dto.ExchangeDto;
import com.ssafy.iNine.FinancialAPI.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/exchange")
    public DataResponse<Map<String, Object>> exchange() throws IOException {
        Map<String, Object> exchangeList = exchangeService.getExchangeList();
        return new DataResponse<Map<String, Object>>(200, "환율 정보 조회 성공", exchangeList);
    }

    @GetMapping("/exchange/crawling")
    public DataResponse<List<List<ExchangeDto>>> crawlingExchange() throws IOException {
        List<List<ExchangeDto>> exchangeDtoList = exchangeService.getMyBank();
        return new DataResponse<>(200, "환율 정보 크롤링 성공", exchangeDtoList);
    }

    @GetMapping("/exchange/save")
    public CommonResponse writeExchange() throws IOException {
        exchangeService.insertExchange();
        return new CommonResponse(200, "환율 정보 저장 성공");
    }

    @GetMapping("/exchange/update")
    public CommonResponse modifyExchange() throws IOException {
        exchangeService.updateExchange();
        return new CommonResponse(200, "환율 정보 업데이트 성공");
    }
}

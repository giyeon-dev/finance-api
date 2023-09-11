package com.ssafy.iNine.FinancialAPI.exchange.controller;

import com.ssafy.iNine.FinancialAPI.common.response.DataResponse;
import com.ssafy.iNine.FinancialAPI.exchange.dto.ExchangeDto;
import com.ssafy.iNine.FinancialAPI.exchange.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExchangeController {

    private final ExchangeService exchangeService;

    @GetMapping("/exchange")
    public DataResponse<List<List<ExchangeDto>>> exchange() throws IOException {
        List<List<ExchangeDto>> exchangeDtoList = exchangeService.getExchangeList();
        return new DataResponse<>(200, "환율 정보 조회 성공", exchangeDtoList);
    }

}

package com.ssafy.iNine.FinancialAPI.exchange.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto {
    private String bank;
    private String country;
    private BigDecimal cashBuyPrice; // 현금 살 때 가격
    private BigDecimal cashBuyRate; // 현금 살 때 수수료율
    private BigDecimal cashSellPrice; // 현금 팔 때 가격
    private BigDecimal cashSellRate; // 현금 팔 때 수수료율
    private BigDecimal transferPrice; // 송금 보낼 때 가격
    private BigDecimal transferRate; // 송금 보낼 때 수수료율
    private BigDecimal price; // 매매기준율
}

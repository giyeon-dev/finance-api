package com.ssafy.iNine.FinancialAPI.exchange.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeDto_korea {
    private String name;
    private BigDecimal rate;
    private String unit;
    private BigDecimal tts;
    private BigDecimal ttb;
}

package com.ssafy.iNine.FinancialAPI.exchange.dto;

import com.ssafy.iNine.FinancialAPI.entity.Country;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankDto {
    private String code;
    private String name;

    public static BankDto of(Bank bank) {
        return BankDto.builder()
                .code(bank.getCode())
                .name(bank.getName())
                .build();
    }
}

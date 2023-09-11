package com.ssafy.iNine.FinancialAPI.exchange.dto;

import com.ssafy.iNine.FinancialAPI.entity.Country;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto {
    private Long countryId;
    private String name;


    public static CountryDto of(Country country) {
        return CountryDto.builder()
                .countryId(country.getCountryId())
                .name(country.getName())
                .build();
    }
}

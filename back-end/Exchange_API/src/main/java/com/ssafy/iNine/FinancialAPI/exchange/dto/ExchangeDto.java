package com.ssafy.iNine.FinancialAPI.exchange.dto;

import com.ssafy.iNine.FinancialAPI.entity.Exchange;
import lombok.*;

import java.math.BigDecimal;

public class ExchangeDto {
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class All {
        private String bank;
        private String country;
        private BigDecimal cashBuyPrice; // 현금 살 때 가격
        private BigDecimal cashBuyRate; // 현금 살 때 수수료율
        private BigDecimal cashSellPrice; // 현금 팔 때 가격
        private BigDecimal cashSellRate; // 현금 팔 때 수수료율
        private BigDecimal transferPrice; // 송금 보낼 때 가격
        private BigDecimal transferRate; // 송금 보낼 때 수수료율
        private BigDecimal price; // 매매기준율

        public static ExchangeDto.All of(Exchange exchange) {
            return ExchangeDto.All.builder()
                    .bank(exchange.getBank())
                    .country(exchange.getCountry())
                    .cashBuyPrice(exchange.getCashBuyPrice())
                    .cashBuyRate(exchange.getCashBuyRate())
                    .cashSellPrice(exchange.getCashSellPrice())
                    .cashSellRate(exchange.getCashSellRate())
                    .transferPrice(exchange.getTransferPrice())
                    .transferRate(exchange.getTransferRate())
                    .price(exchange.getPrice())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Buy {
        private String bank;
        private String country;
        private BigDecimal cashBuyPrice; // 현금 살 때 가격
        private BigDecimal cashBuyRate; // 현금 살 때 수수료율
        private BigDecimal price; // 매매기준율

        public static ExchangeDto.Buy of(Exchange exchange) {
            return ExchangeDto.Buy.builder()
                    .bank(exchange.getBank())
                    .country(exchange.getCountry())
                    .cashBuyPrice(exchange.getCashBuyPrice())
                    .cashBuyRate(exchange.getCashBuyRate())
                    .price(exchange.getPrice())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Sell {
        private String bank;
        private String country;
        private BigDecimal cashSellPrice; // 현금 팔 때 가격
        private BigDecimal cashSellRate; // 현금 팔 때 수수료율
        private BigDecimal price; // 매매기준율
        public static ExchangeDto.Sell of(Exchange exchange) {
            return ExchangeDto.Sell.builder()
                    .bank(exchange.getBank())
                    .country(exchange.getCountry())
                    .cashSellPrice(exchange.getCashSellPrice())
                    .cashSellRate(exchange.getCashSellRate())
                    .price(exchange.getPrice())
                    .build();
        }
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transfer {
        private String bank;
        private String country;
        private BigDecimal transferPrice; // 송금 보낼 때 가격
        private BigDecimal transferRate; // 송금 보낼 때 수수료율
        private BigDecimal price; // 매매기준율

        public static ExchangeDto.Transfer of(Exchange exchange) {
            return ExchangeDto.Transfer.builder()
                    .bank(exchange.getBank())
                    .country(exchange.getCountry())
                    .transferPrice(exchange.getTransferPrice())
                    .transferRate(exchange.getTransferRate())
                    .price(exchange.getPrice())
                    .build();
        }
    }
}

package com.ssafy.iNine.FinancialAPI.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@ToString(of = {"id", "bank", "country", "price"})
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exchangeId;
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

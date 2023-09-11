package com.ssafy.iNine.FinancialAPI.exchange.repository;

import com.ssafy.iNine.FinancialAPI.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
    Optional<Exchange> findByBankAndCountry(String bank, String country);
}

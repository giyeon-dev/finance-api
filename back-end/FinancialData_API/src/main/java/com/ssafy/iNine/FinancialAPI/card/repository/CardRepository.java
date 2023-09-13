package com.ssafy.iNine.FinancialAPI.card.repository;

import com.ssafy.iNine.FinancialAPI.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, String> {
}

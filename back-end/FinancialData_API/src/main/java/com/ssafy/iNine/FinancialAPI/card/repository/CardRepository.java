package com.ssafy.iNine.FinancialAPI.card.repository;

import com.ssafy.iNine.FinancialAPI.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {
}

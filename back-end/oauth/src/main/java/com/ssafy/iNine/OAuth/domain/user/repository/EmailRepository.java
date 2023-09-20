package com.ssafy.iNine.OAuth.domain.user.repository;

import com.ssafy.iNine.OAuth.domain.user.dto.EmailAuthDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmailRepository extends MongoRepository<EmailAuthDto, String> {
   Optional<EmailAuthDto> findByEmail(String email);

}

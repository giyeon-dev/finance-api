package com.ssafy.iNine.FinancialAPI.domain.repository;

import com.ssafy.iNine.FinancialAPI.common.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById (String username);
}

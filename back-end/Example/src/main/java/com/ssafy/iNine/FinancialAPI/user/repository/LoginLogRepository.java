package com.ssafy.iNine.FinancialAPI.user.repository;

import com.ssafy.tingbackend.entity.user.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {
}

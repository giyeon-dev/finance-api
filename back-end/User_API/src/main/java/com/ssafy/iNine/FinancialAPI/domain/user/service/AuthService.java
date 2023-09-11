package com.ssafy.iNine.FinancialAPI.domain.user.service;

import com.ssafy.iNine.FinancialAPI.common.entity.user.User;
import com.ssafy.iNine.FinancialAPI.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;

    public User getUserInfo(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("회원 정보가 없습니다."));
    }
}

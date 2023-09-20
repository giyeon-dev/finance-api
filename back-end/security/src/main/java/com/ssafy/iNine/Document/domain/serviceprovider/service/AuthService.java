package com.ssafy.iNine.Document.domain.serviceprovider.service;

import com.ssafy.iNine.Document.common.entity.user.ServiceProvider;
import com.ssafy.iNine.Document.domain.serviceprovider.repository.ServiceProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final ServiceProviderRepository userRepository;

    public ServiceProvider getUserInfo(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new IllegalArgumentException("회원 정보가 없습니다."));
    }
}

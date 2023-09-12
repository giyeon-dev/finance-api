package com.ssafy.iNine.FinancialAPI.domain.serviceprovider.service;

import com.ssafy.iNine.FinancialAPI.common.entity.user.ServiceProvider;
import com.ssafy.iNine.FinancialAPI.common.exception.CommonException;
import com.ssafy.iNine.FinancialAPI.common.exception.ExceptionType;
import com.ssafy.iNine.FinancialAPI.domain.serviceprovider.dto.ServiceProviderDto;
import com.ssafy.iNine.FinancialAPI.domain.serviceprovider.repository.ServiceProviderRepository;
import com.ssafy.iNine.FinancialAPI.security.JwtAuthenticationProvider;
import com.ssafy.iNine.FinancialAPI.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
@Transactional
public class ServiceProviderService {

    private final PasswordEncoder passwordEncoder;
    private final ServiceProviderRepository userRepository;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final JwtUtil jwtUtil;

    public Map<String, String> login(ServiceProviderDto.LoginForm loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        Authentication authentication = jwtAuthenticationProvider.authenticate(authenticationToken);
        ServiceProvider principal = (ServiceProvider) authentication.getPrincipal();

        String accessToken = JwtUtil.generateAccessToken(String.valueOf(principal.getServiceProviderId()));
        String refreshToken = JwtUtil.generateRefreshToken(String.valueOf(principal.getServiceProviderId()));

        Map<String, String> result = new HashMap<>();
        result.put("access-token", accessToken);
        result.put("refresh-token", refreshToken);

        return result;
    }

    public void signUp(ServiceProviderDto.RegistForm registForm) {
        registForm.encodePassword(passwordEncoder.encode(registForm.getPassword()));  // 비밀번호 암호화

        // 이메일, 닉네임 중복체크 처리
        if (userRepository.findByEmail(registForm.getEmail()).isPresent()) {
            log.info("duplicate error");
            throw new CommonException(ExceptionType.DUPLICATED_EMAIL);
        }

        // 기본 정보 UserDto -> User 변환
        //ModelMapper modelMapper = new ModelMapper();
        //User user = modelMapper.map(registForm, User.class);
        ServiceProvider serviceProvider = ServiceProvider.builder().
                email(registForm.getEmail()).
                password(registForm.getPassword()).
                isDeleted(false).
                createdTime(LocalDateTime.now()).
                apiToken(jwtUtil.generateApiToken(registForm.getEmail())).
                build();

        if(registForm.getUser_class() != null) serviceProvider.setUserClass(registForm.getUser_class());
        if(registForm.getArea() != null) serviceProvider.setArea(registForm.getArea());
        if(registForm.getUrl() != null) serviceProvider.setUrl(registForm.getUrl());
        if(registForm.getContent() != null) serviceProvider.setContent(registForm.getContent());
        log.info("user id:{}", serviceProvider.getServiceProviderId());
        userRepository.save(serviceProvider);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId, LocalDateTime.now());
    }

    public void modifyPassword(Long userId, String password) {
        userRepository.modifyPassword(userId, passwordEncoder.encode(password));
    }
}

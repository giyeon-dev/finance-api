package com.ssafy.iNine.FinancialAPI.domain.user.service;

import com.ssafy.iNine.FinancialAPI.common.entity.user.User;
import com.ssafy.iNine.FinancialAPI.common.exception.CommonException;
import com.ssafy.iNine.FinancialAPI.common.exception.ExceptionType;
import com.ssafy.iNine.FinancialAPI.domain.user.dto.UserDto;
import com.ssafy.iNine.FinancialAPI.domain.user.repository.UserRepository;
import com.ssafy.iNine.FinancialAPI.security.JwtAuthenticationProvider;
import com.ssafy.iNine.FinancialAPI.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;

    public Map<String, String> login(UserDto.LoginForm loginDto) {
        UsernamePasswordAuthenticationToken authenticationToken
                = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        Authentication authentication = jwtAuthenticationProvider.authenticate(authenticationToken);
        User principal = (User) authentication.getPrincipal();

        String accessToken = JwtUtil.generateAccessToken(String.valueOf(principal.getUserId()));
        String refreshToken = JwtUtil.generateRefreshToken(String.valueOf(principal.getUserId()));

        Map<String, String> result = new HashMap<>();
        result.put("access-token", accessToken);
        result.put("refresh-token", refreshToken);

        return result;
    }

    public void regist(UserDto.RegistForm registForm) {
        log.info("user service registForm.email={}", registForm.getEmail());
        registForm.encodePassword(passwordEncoder.encode(registForm.getPassword()));  // 비밀번호 암호화

        // 이메일, 닉네임 중복체크 처리
        if (userRepository.findByEmail(registForm.getEmail()).isPresent()) {
            throw new CommonException(ExceptionType.DUPLICATED_EMAIL);
        }

        // 기본 정보 UserDto -> User 변환
        //ModelMapper modelMapper = new ModelMapper();
        //User user = modelMapper.map(registForm, User.class);
        User user = User.builder().
                email(registForm.getEmail()).
                password(registForm.getPassword()).
                build();
        if(registForm.getUserClass() != null) user.setUserClass(registForm.getUserClass());
        if(registForm.getArea() != null) user.setArea(registForm.getArea());
        if(registForm.getUrl() != null) user.setUrl(registForm.getUrl());
        if(registForm.getContent() != null) user.setContent(registForm.getContent());

        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId, LocalDateTime.now());
    }

    public void modifyPassword(Long userId, String password) {
        userRepository.modifyPassword(userId, password);
    }
}

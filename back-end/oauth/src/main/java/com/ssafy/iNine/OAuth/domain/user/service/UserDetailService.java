package com.ssafy.iNine.OAuth.domain.user.service;

import com.ssafy.iNine.OAuth.common.entity.user.User;
import com.ssafy.iNine.OAuth.common.exception.CommonException;
import com.ssafy.iNine.OAuth.common.exception.ExceptionType;
import com.ssafy.iNine.OAuth.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        System.out.println(username);
        User userInfo = userRepository.findById(username).orElseThrow(() -> {
            log.info("로그인 실패 회원 정보가 없습니다");
            return new CommonException(ExceptionType.USER_NOT_FOUND);
        });
        return userInfo;
    }
}

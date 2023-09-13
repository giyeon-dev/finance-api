package com.ssafy.iNine.FinancialAPI.domain.service;

import com.ssafy.iNine.FinancialAPI.common.entity.user.User;
import com.ssafy.iNine.FinancialAPI.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = userRepository.findById(username);
        return new org.springframework.security.core.userdetails.User(
                "asdf",
                "asdf",
                new ArrayList<>()
        );
    }
}

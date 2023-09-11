package com.ssafy.iNine.FinancialAPI.domain.user.service;

import com.ssafy.iNine.FinancialAPI.domain.user.dto.UserDto;
import com.ssafy.iNine.FinancialAPI.domain.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private UserRepository userRepository;

    private Map<String, String> login(UserDto.Login login) {

    }

    private void regist(UserDto.RegistForm registForm) {

    }

    private void deleteUser(Long userId) {

    }


}

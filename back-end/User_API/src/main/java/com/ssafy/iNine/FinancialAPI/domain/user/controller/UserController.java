package com.ssafy.iNine.FinancialAPI.domain.user.controller;

import com.ssafy.iNine.FinancialAPI.common.response.CommonResponse;
import com.ssafy.iNine.FinancialAPI.domain.user.dto.UserDto;
import com.ssafy.iNine.FinancialAPI.domain.user.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    @PostMapping
    public CommonResponse resist(@RequestBody UserDto.RegistForm registForm) {

    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody UserDto.Login login) {

    }

    @DeleteMapping
    public CommonResponse deleteUser() {

    }

    @PutMapping("/password")
    public CommonResponse modifyPassword() {

    }

    @GetMapping("/password")
    public CommonResponse setTmpPassword() {

    }
}

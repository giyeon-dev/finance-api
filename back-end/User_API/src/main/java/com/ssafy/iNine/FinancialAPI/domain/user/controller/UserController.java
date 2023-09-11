package com.ssafy.iNine.FinancialAPI.domain.user.controller;

import com.ssafy.iNine.FinancialAPI.common.response.CommonResponse;
import com.ssafy.iNine.FinancialAPI.common.response.DataResponse;
import com.ssafy.iNine.FinancialAPI.domain.user.dto.UserDto;
import com.ssafy.iNine.FinancialAPI.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @PostMapping
    public CommonResponse regist(@RequestBody UserDto.RegistForm registForm) {
        log.info("user controller regist");
        userService.regist(registForm);
        return new CommonResponse(200, "success");
    }

    @PostMapping("/login")
    public DataResponse<?> login(@RequestBody UserDto.LoginForm loginDto) {
        Map<String, String> token = userService.login(loginDto);
        return new DataResponse<>(200, "success", token);
    }

    @DeleteMapping
    public CommonResponse deleteUser(Principal principal) {
        Long userId = Long.parseLong(principal.getName());
        userService.deleteUser(userId);
        return new CommonResponse();
    }

    @PutMapping("/password")
    public CommonResponse modifyPassword(Principal principal, @RequestBody Map<String, String> passwordMap) {
        Long userId = Long.parseLong(principal.getName());
        userService.modifyPassword(userId, passwordMap.get("password"));
        return new CommonResponse(200, "success");
    }

}

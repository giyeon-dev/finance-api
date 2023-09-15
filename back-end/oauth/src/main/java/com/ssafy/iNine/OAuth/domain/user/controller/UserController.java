package com.ssafy.iNine.OAuth.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String login() {
        return "emailForm"; // login.html 또는 login.jsp와 같은 로그인 페이지 템플릿의 이름을 반환합니다.
    }

    @ResponseBody
    @GetMapping("/auth")
    public String authenticate() {
        return "success"; // login.html 또는 login.jsp와 같은 로그인 페이지 템플릿의 이름을 반환합니다.
    }
}

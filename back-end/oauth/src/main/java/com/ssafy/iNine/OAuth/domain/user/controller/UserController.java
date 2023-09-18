package com.ssafy.iNine.OAuth.domain.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class UserController {

    @RequestMapping("/oauth/confirm_access")
    public String confirm(HttpServletRequest request){
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) request.getSession().getAttribute("authorizationRequest");
        log.info("clientid:{}", authorizationRequest.getClientId());
        return "confirm";
    }

    @GetMapping("/oauth/login")
    public String login() {
        log.info("login form");
        return "login"; // login.html 또는 login.jsp와 같은 로그인 페이지 템플릿의 이름을 반환합니다.
    }
}

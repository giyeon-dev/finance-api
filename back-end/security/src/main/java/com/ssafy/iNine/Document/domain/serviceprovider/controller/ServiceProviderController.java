package com.ssafy.iNine.Document.domain.serviceprovider.controller;

import com.ssafy.iNine.Document.domain.serviceprovider.dto.OAuthClientDetailsDto;
import com.ssafy.iNine.Document.domain.serviceprovider.dto.ServiceProviderDto;
import com.ssafy.iNine.Document.domain.serviceprovider.service.ServiceProviderService;
import com.ssafy.iNine.Document.common.response.CommonResponse;
import com.ssafy.iNine.Document.common.response.DataResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/docs/service")
@RequiredArgsConstructor
@Slf4j
public class ServiceProviderController {

    private final ServiceProviderService serviceProviderService;
    @PostMapping
    public CommonResponse signUp(@RequestBody ServiceProviderDto.RegistForm registForm) {
        serviceProviderService.signUp(registForm);
        return new CommonResponse(200, "success");
    }

    @PostMapping("/login")
    public DataResponse<?> login(@RequestBody ServiceProviderDto.LoginForm loginDto) {
        Map<String, String> token = serviceProviderService.login(loginDto);
        return new DataResponse<>(200, "success", token);
    }

    @DeleteMapping
    public CommonResponse deleteUser(Principal principal) {
        Long serviceProviderId = Long.parseLong(principal.getName());
        serviceProviderService.deleteUser(serviceProviderId);
        return new CommonResponse(200, "success");
    }

    @PutMapping("/password")
    public CommonResponse modifyPassword(Principal principal, @RequestBody Map<String, String> passwordMap) {
        Long userId = Long.parseLong(principal.getName());
        serviceProviderService.modifyPassword(userId, passwordMap.get("password"));
        return new CommonResponse(200, "success");
    }

    @PutMapping("/client")
    public CommonResponse setClient(Principal principal, @RequestBody OAuthClientDetailsDto.OAuthClientRegistForm oAuthClientRegistForm) {
        Long userId = Long.parseLong(principal.getName());
        serviceProviderService.setOAuthClient(userId, oAuthClientRegistForm);
        return new CommonResponse(200, "success");
    }
}

package com.ssafy.iNine.FinancialAPI.domain.serviceprovider.controller;

import com.ssafy.iNine.FinancialAPI.common.response.CommonResponse;
import com.ssafy.iNine.FinancialAPI.common.response.DataResponse;
import com.ssafy.iNine.FinancialAPI.domain.serviceprovider.dto.ServiceProviderDto;
import com.ssafy.iNine.FinancialAPI.domain.serviceprovider.service.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("/service")
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

}

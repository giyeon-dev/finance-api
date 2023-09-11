package com.ssafy.iNine.FinancialAPI.domain.user.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class UserDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegistForm {
        private String email;
        private String password;
        private String ssafyClass;
        private String area;
        private String content;
        private String url;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Login {
        private String email;
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class detail {
        private String email;
        private String password;
        private String ssafyClass;
        private String area;
        private String content;
        private String url;
        private LocalDateTime createdTime;
        private LocalDateTime deletedTime;
        private Boolean isDeleted;
    }
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class info {
        private String email;
        private String password;
        private String ssafyClass;
        private String area;
        private String content;
        private String url;
        private LocalDateTime createdTime;
        private LocalDateTime deletedTime;
        private Boolean isDeleted;
    }

}

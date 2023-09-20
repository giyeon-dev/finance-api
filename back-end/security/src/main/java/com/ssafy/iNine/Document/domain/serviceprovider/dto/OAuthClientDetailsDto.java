package com.ssafy.iNine.Document.domain.serviceprovider.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class OAuthClientDetailsDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OAuthClientRegistForm {
        private String web_server_redirect_uri;
        private String additional_information;
    }
}

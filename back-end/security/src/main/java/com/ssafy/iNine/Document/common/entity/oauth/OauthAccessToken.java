package com.ssafy.iNine.Document.common.entity.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_access_token")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OauthAccessToken {
    @Id
    private String authenticationId;
    private String tokenId;
    @Lob
    private byte[] token;
    private String userName;
    private String clientId;
    @Lob
    private byte[] authentication;
    private String refreshToken;
}

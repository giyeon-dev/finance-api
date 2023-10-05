package com.ssafy.iNine.OAuth.common.entity.oauth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_refresh_token")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OAuthRefreshToken {
    @Id
    private String tokenId;
    @Lob
    private byte[] token;
    @Lob
    private byte[] authentication;
}

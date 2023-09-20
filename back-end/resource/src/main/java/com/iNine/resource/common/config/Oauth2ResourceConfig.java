package com.iNine.resource.common.config;

import com.google.gson.Gson;
import com.iNine.resource.common.dto.JWTKey;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.StringUtils;

@EnableResourceServer
@Configuration
public class Oauth2ResourceConfig extends ResourceServerConfigurerAdapter {
    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String publicKeyUri; // key 정보를 받아오기 위한 인증서버 URL 선언
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/main")
                .access("#oauth2.hasAnyScope('read')")
                .anyRequest()
                .authenticated();
    }

    // 토큰 저장소를 jwt 체크하는것으로 수정
    @Bean
    public TokenStore tokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        try{
            /***
             * 공개키를 직접 파일로 만들어 읽어서 jwt 디코드 키 등록
             */
           /* JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            Resource resource = new ClassPathResource("key.txt");
            converter.setVerifierKey(IOUtils.toString(resource.getInputStream()));
            return converter;*/

            /***
             * 직접 oauth 서버를 호출하여 공개키 읽어서 jwt 디코드 키 등록
             */
            JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
            converter.setVerifierKey(getPublicKeyValue(publicKeyUri));
            return converter;
        }catch (Exception e){
            return new JwtAccessTokenConverter();
        }
    }


    private String getPublicKeyValue(String uriKey) {
        JsonNode response = Unirest.get(uriKey)
                .asJson().getBody();
        return StringUtils.isEmpty(response.toString()) ? "" : new Gson().fromJson(response.toString(), JWTKey.class).getValue();
    }

//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        RemoteTokenServices remoteTokenService = new RemoteTokenServices();
//        remoteTokenService.setClientId("clientId");
//        remoteTokenService.setClientSecret("secretKey");
//        remoteTokenService.setCheckTokenEndpointUrl("http://localhost:8085/oauth/check_token");
//        resources.tokenServices(remoteTokenService);
//    }
}

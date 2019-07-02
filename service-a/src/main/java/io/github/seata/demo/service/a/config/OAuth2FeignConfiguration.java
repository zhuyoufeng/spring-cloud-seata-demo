package io.github.seata.demo.service.a.config;

import feign.Feign;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@Configuration
@ConditionalOnClass({Feign.class})
public class OAuth2FeignConfiguration {

    private final AuthorizationCodeResourceDetails authorizationCodeResourceDetails;

    public OAuth2FeignConfiguration(AuthorizationCodeResourceDetails authorizationCodeResourceDetails) {
        this.authorizationCodeResourceDetails = authorizationCodeResourceDetails;
    }

    @Bean
    @Qualifier("ClientCredentialsOAuth2FeignRequestInterceptor")
    public OAuth2FeignRequestInterceptor oauth2schemeRequestInterceptor() {
        return new OAuth2FeignRequestInterceptor(new DefaultOAuth2ClientContext(), oauth2schemeResourceDetails());
    }

    @Bean
    public ClientCredentialsResourceDetails oauth2schemeResourceDetails() {
        ClientCredentialsResourceDetails details = new ClientCredentialsResourceDetails();
        details.setClientId(authorizationCodeResourceDetails.getClientId());
        details.setClientSecret(authorizationCodeResourceDetails.getClientSecret());
        details.setAccessTokenUri(authorizationCodeResourceDetails.getAccessTokenUri());
        details.setScope(authorizationCodeResourceDetails.getScope());
        return details;
    }

}
package com.thoughtmechanix.licenses.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@Configuration
@EnableOAuth2Client
public class OAuth2Configuration {

	@Bean
	public OAuth2ProtectedResourceDetails authorizationCode() {
		AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
		details.setId("oauth2server");
		details.setClientId("eagleeye");
		details.setClientSecret("thisissecret");
		details.setUseCurrentUri(true);
		details.setUserAuthorizationUri("http://localhost:8901/auth/oauth/authorize");
		details.setAccessTokenUri("http://localhost:8901/auth/oauth/token");
		return details;
	}

	@Bean
	public OAuth2RestTemplate restTemplate(OAuth2ClientContext context) {
		
		System.out.println("###############  oauth2ClientContext: " + context.getClass().getCanonicalName());
		
		return new OAuth2RestTemplate(authorizationCode(), context);
	}

}

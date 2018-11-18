package com.thoughtmechanix.licenses;

import com.thoughtmechanix.licenses.config.ServiceConfig;
import com.thoughtmechanix.licenses.utils.UserContextInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableResourceServer
public class Application {

    @Autowired
    private ServiceConfig serviceConfig;

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

//    @Bean    
//    public OAuth2RestTemplate oauth2RestTemplate(@Autowired OAuth2ClientContext oauth2ClientContext,
//    		@Autowired OAuth2ProtectedResourceDetails details) {
//    	System.out.println("###############  oauth2ClientContext: "+oauth2ClientContext.getClass().getCanonicalName());;
//        return new OAuth2RestTemplate(details, oauth2ClientContext);
//    }
    
//    @Bean
//    public OAuth2RestTemplate restTemplate(OAuth2ClientContext context) {
//        return new OAuth2RestTemplate(authorizationCode(), context);
//    }
    
//    /***
//     * TEST
//     * ******/
//    @Bean
//    public OAuth2ProtectedResourceDetails authorizationCode() {
//        AuthorizationCodeResourceDetails details =
//            new AuthorizationCodeResourceDetails();
//        details.setId("oauth2server");
//        details.setClientId("clientapp");
//        details.setClientSecret("123");
//        details.setUseCurrentUri(true);
//        details.setUserAuthorizationUri("http://localhost:8080/oauth/authorize");
//        details.setAccessTokenUri("http://localhost:8080/oauth/token");
//        return details;
//    }
    
//    @Primary
//    @Bean
//    public RestTemplate getCustomRestTemplate() {
//        RestTemplate template = new RestTemplate();
//        List interceptors = template.getInterceptors();
//        if (interceptors == null) {
//            template.setInterceptors(Collections.singletonList(new UserContextInterceptor()));
//        } else {
//            interceptors.add(new UserContextInterceptor());
//            template.setInterceptors(interceptors);
//        }
//
//        return template;
//    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

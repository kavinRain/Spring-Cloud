package com.spring.cloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/3/22.
 */
@SpringBootApplication
@EnableAuthorizationServer
@EnableDiscoveryClient
public class SpringSecurityOAuth2Application {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SpringSecurityOAuth2Application.class).web(true).run(args);

    }

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

}

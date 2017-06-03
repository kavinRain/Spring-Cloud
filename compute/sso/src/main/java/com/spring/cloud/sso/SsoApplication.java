package com.spring.cloud.sso;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SsoApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(SsoApplication.class).web(true).run(args);

    }

}

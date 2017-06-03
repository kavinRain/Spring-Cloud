package com.vue.web.ui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by Administrator on 2017/5/31.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class VueApplication {


    public static void main(String[] args) {

        new SpringApplicationBuilder(VueApplication.class).web(true).run(args);

    }
}

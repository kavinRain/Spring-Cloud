package com.vue.web.ui;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by Administrator on 2017/5/31.
 */
@SpringBootApplication
public class VueApplication {


    public static void main(String[] args) {

        new SpringApplicationBuilder(VueApplication.class).web(true).run(args);

    }
}

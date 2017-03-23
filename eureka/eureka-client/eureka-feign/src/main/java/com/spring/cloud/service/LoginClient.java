package com.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/3/23.
 */
@FeignClient(value = "spring-securtity-oauth2")
public interface LoginClient {

    @RequestMapping(method = RequestMethod.POST,value = "/login")
    Object login(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password);
}

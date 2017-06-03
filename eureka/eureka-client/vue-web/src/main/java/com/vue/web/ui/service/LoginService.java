package com.vue.web.ui.service;

import com.spring.cloud.common.beans.Result;
import com.vue.web.ui.service.hystrix.LoginServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/3.
 */
@FeignClient(value = "sso", fallback = LoginServiceHystrix.class)
public interface LoginService {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Result<String> login(String username, String password);
}

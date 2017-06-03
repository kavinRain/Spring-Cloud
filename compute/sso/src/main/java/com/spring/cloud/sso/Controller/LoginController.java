package com.spring.cloud.sso.controller;

import com.spring.cloud.common.beans.Result;
import com.spring.cloud.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/3.
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("login")
    public Result login(String username, String password) {
        Result<String> result = loginService.login(username, password);
        return result;
    }
}

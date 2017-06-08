package com.vue.web.ui.controller;

import com.spring.cloud.common.beans.Result;
import com.vue.web.ui.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/31.
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    public Result login(@RequestParam(defaultValue = "admin") String username, @RequestParam(defaultValue = "123456")
            String password) {
        Result<String> result = loginService.login(username, password);
        return result;
    }
}

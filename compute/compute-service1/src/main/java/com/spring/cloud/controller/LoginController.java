package com.spring.cloud.controller;

import com.spring.cloud.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 柯伟 on 2017/3/21.
 */
@RestController
@RequestMapping(method = RequestMethod.POST)
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "login")
    public Object login(String userName, String password) {
        loginService.login(userName, password);
        return null;
    }
}

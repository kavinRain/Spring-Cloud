package com.vue.web.ui.controller;

import com.vue.web.ui.common.beans.Result;
import com.vue.web.ui.common.enums.ResultType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/31.
 */
@RestController
public class LoginController {

    @PostMapping("login")
    public Result<Object> login(String username, String password) {
        return new Result<Object>(ResultType.SUCCESS, null);
    }
}

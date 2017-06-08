package com.vue.web.ui.controller;

import com.spring.cloud.common.beans.Page;
import com.spring.cloud.common.beans.Result;
import com.spring.cloud.common.enums.ResultType;
import com.vue.web.ui.entity.User;
import com.vue.web.ui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Administrator on 2017/6/7.
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @PostMapping("queryUserList")
    public Result<Map<String,Object>> queryUserList(Page<User> page, String name){
        return new Result<>(ResultType.SUCCESS,userService.queryUserList(page,name));
    }

}

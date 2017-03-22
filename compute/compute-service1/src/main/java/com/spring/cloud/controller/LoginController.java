package com.spring.cloud.controller;

import com.spring.cloud.entity.SysUser;
import com.spring.cloud.service.LoginService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 柯伟 on 2017/3/21.
 */
@RestController
@Api("LoginController.Api")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userName", dataType = "String", required = true, value =
                    "登录名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value =
                    "密码")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "login")
    public SysUser login(String userName, String password) {
        return loginService.login(userName, password);
    }
}

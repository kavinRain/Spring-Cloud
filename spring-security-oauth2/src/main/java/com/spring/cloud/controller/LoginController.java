package com.spring.cloud.controller;

import com.spring.cloud.service.LoginService;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
@Api("LoginController.Api")
public class LoginController extends BaseController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    @ApiOperation("登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "username", dataType = "String", required = true, value =
                    "登录名"),
            @ApiImplicitParam(paramType = "query", name = "password", dataType = "String", required = true, value =
                    "密码")
    })
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "login")
    public Object login(String username, String password) {
        logger.info("接收参数:{}", String.format("%s;%s", username, password));
        return loginService.login(username, password);
    }
}

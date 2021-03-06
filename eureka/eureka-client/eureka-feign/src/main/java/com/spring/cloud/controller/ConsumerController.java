package com.spring.cloud.controller;

import com.spring.cloud.service.ComputeClient;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController extends BaseController {

    @Autowired
    ComputeClient computeClient;

    @ApiOperation("测试接口")
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数没填好"),
            @ApiResponse(code = 404, message = "请求路径没有或页面跳转路径不对")
    })
    @RequestMapping(value = "/add")
    public Integer add() {
        return computeClient.add(10, 20);
    }

}
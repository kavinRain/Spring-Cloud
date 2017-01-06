package com.spring.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.spring.cloud.entity.SysStaff;
import com.spring.cloud.service.SysStaffService;
import com.spring.cloud.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/1/6.
 */
@RestController
@RequestMapping(value = "user")
@Api(value = "user", description = "用户管理", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private SysStaffService sysStaffService;

    /**
     * @param id 客户表Id
     * @return user 对象信息
     */
    @ApiOperation(value = "用户查询", notes = "根据用户的Id查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户主键", required = true, dataType = "Integer", paramType =
                    "query"),
    })
    @RequestMapping(value = "/findById")
    public Object findById(@RequestParam(name = "id") Integer id) {
//        logger.info(JSON.toJSONString(userService.findById(id)));
//        logger.info(JSON.toJSONString(sysStaffService.findById(id)));
        SysStaff sysStaff = new SysStaff();
        sysStaff.setId(1);
        logger.info(JSON.toJSONString(sysStaffService.find2ById(sysStaff)));
        return null;
    }
}

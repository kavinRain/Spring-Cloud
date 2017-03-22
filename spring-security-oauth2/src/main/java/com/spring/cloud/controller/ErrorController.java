package com.spring.cloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * Created by Administrator on 2017/3/22.
 */
@RestController
@SessionAttributes("authorizationRequest")
public class ErrorController {

    @RequestMapping("/oauth/error")
    public String error(@RequestParam Map<String, String> parameters) {
        String uri = parameters.get("redirect_uri");
        return "redirect:" + uri + "?error=1";
    }
}

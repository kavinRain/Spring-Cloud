package com.vue.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "/login";
    }

    @PostMapping("login")
    public String login(String username, String password) {
        return "redirect:/login";
    }
}

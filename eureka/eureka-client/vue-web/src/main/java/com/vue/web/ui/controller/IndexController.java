package com.vue.web.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
public class IndexController {

    @GetMapping({"/index", "/", ""})
    public String index(Model model) {
        model.addAttribute("hello", "哈喽!");
        return "/index";
    }
}

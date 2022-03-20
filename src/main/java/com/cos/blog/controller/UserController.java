package com.cos.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping({"", "/"})
    public String index(){
        return "index";
    }

    @GetMapping("/joinForm")
    public String joinUser(){
        return "user/joinForm";
    }

    @GetMapping("/loginForm")
    public String loginUser(){
        return "user/loginForm";
    }

}

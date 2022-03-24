package com.cos.blog.controller;

import com.cos.blog.config.auth.PrincipalDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinUser(){
        return "user/joinForm";
    }

    @GetMapping("/auth/loginForm")
    public String loginUser(){
        return "user/loginForm";
    }

}

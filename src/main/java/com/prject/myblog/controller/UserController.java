package com.prject.myblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    // 회원 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}
package com.wzhy.controller;

import com.wzhy.pojo.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/login")
    public RespBean login(){
        return
                RespBean.error("登录异常",null);
    }
}


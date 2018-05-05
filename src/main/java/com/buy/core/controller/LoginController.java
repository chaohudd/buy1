package com.buy.core.controller;

import com.buy.core.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletResponse response;

    @RequestMapping(value = "/buy/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        System.out.println(111);
        if (" ".equals(username) || username == null) {
            throw new RuntimeException("用户名不能为空");
        }
        if (" ".equals(password) || password == null) {
            throw new RuntimeException("登录密码不能为空");
        }
//        response.setContentType("text/html;charset=UTF-8");
//        response.setContentType("application/json;charset=UTF-8");
        return loginService.Login(username, password);
    }
}

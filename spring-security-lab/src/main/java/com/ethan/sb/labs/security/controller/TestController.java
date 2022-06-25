package com.ethan.sb.labs.security.controller;

import com.ethan.sb.labs.security.bo.TestBo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author zhenghui
 * @Description 测试控制器
 * @Date 2022/6/25
 */
@Controller
public class TestController {

    @GetMapping(value = "/hello")
    public String sayHello() {
        return "hello";
    }

    @GetMapping(value = {"/home", "/"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping(value = "/admin")
    @Secured("ROLE_ADMIN")
    public String admin() {
        return "admin";
    }

    @PostMapping(value = "submit")
    @ResponseBody
    public Integer submit(@RequestBody TestBo testBo) {
        return testBo.getId();
    }
}

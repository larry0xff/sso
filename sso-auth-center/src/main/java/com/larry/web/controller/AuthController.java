package com.larry.web.controller;

import com.larry.pojo.LoginParam;
import com.larry.pojo.Result;
import com.larry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    public UserService userService;

    @GetMapping("/checkStatus")
    public Result checkStatus(@RequestParam String token) {
        return new Result();
    }

    /**
     * 登录
     * @param param
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginParam param) {
        userService.verify(param.getUsername(), param.getPassword(), param.getSystemId());
        return new Result();
    }
}

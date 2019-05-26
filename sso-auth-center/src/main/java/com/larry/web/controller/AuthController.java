package com.larry.web.controller;

import com.larry.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/checkStatus")
    public Result test(@RequestParam String token) {
        return new Result();
    }
}

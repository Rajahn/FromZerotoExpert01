package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/FromZerotoExpert")
    @ResponseBody
    public String hello(){
        return "嗨，欢迎您来到 from zero to expert.";
    }
}

package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
    @GetMapping("/FromZerotoExpert")
    @ResponseBody
    public String hello(HttpServletResponse response, HttpServletRequest request){

        if(request.getCookies()!=null){
            Cookie[] cookie = request.getCookies();
            logger.info("有cookie");
            if(cookie[0].getName().equals("times")){
                logger.info("输出有cookie");
                return "嗨，欢迎您再次到 from zero to expert";
            }
        }else{
            Cookie newcookie=new Cookie("times","2");
            newcookie.setMaxAge(24*60*60);
//            newcookie.setComment("second");
            response.addCookie(newcookie);
            logger.info("没有cookie");
            return "嗨，欢迎您来到 from zero to expert.";
        }
        return "嗨，欢迎您来到 from zero to expert.";
    }
}

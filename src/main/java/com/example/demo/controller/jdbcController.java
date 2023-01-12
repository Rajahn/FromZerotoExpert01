package com.example.demo.controller;

import com.mysql.cj.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
//和controller有什么区别？用controller不行
public class jdbcController {
    @Autowired(required = false)
    JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("users/query")
    public List<Map<String,Object>> queryAll(){
        logger.error("query");
        List<Map<String,Object>> list =jdbcTemplate.queryForList("select * from tb_user");
        logger.info(String.valueOf(list));
        return list;
    }

    @GetMapping("users/insert")
    public Object insert(String name, String password){
        logger.info("insert");
        jdbcTemplate.execute("insert into tb_user(`name`,`password`) value (\"" + name + "\",\"" + password + "\")");;
        logger.info("insert finish");
        return true;
    }


}

package com.changgou.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.spring.annotation.MapperScan;

@RestController
@RequestMapping("/demo")
public class TestDemo {
    @GetMapping
    public String test(){
        return "nihao";
    }
}

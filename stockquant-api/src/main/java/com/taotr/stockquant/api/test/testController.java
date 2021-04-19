package com.taotr.stockquant.api.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-03-31 20:38
 **/
@RestController
public class testController {
    @GetMapping("/hello1")
    public String hello1(){
        return "我是moudle1";
    }
}

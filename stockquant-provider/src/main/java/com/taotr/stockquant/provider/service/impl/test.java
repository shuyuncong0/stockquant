package com.taotr.stockquant.provider.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-04-17 19:10
 **/
@RestController
public class test {
    @Value("${server.port}")
    String port;


}

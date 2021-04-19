package com.taotr.stockquant.api;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.taotr"})
@EnableDubbo //开启dubbo的注解支持
@Configuration
public class StockquantApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockquantApiApplication.class, args);
    }

}

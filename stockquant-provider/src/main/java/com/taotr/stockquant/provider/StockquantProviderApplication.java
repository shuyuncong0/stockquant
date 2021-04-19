package com.taotr.stockquant.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDubbo
@EnableScheduling
@MapperScan("com.taotr.stockquant.provider.dao")
public class StockquantProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockquantProviderApplication.class, args);
    }

}

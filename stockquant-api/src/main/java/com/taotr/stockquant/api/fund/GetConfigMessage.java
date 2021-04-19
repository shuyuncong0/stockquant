package com.taotr.stockquant.api.fund;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-04-17 18:02
 **/

@RestController
@RequestMapping("config")
public class GetConfigMessage {

    @GetMapping("get")
    public Object getConfigMessage() throws NacosException {
        String serverAddr = "47.98.189.101:9090";
        String dataId = "spring.application.name";
        String group = "DEFAULT_GROUP";
        String namespace = "dc0db51e-91c3-45be-8d0b-937fc809afe6";  //命名空间ID
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        properties.put("namespace",namespace);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId,group,2000);
        return content;
    }
}
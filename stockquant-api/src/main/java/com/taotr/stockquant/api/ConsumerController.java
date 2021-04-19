package com.taotr.stockquant.api;


import com.taotr.stockquant.commons.model.um.ProviderDTO;
import com.taotr.stockquant.commons.result.CrhBeanResult;
import com.taotr.stockquant.commons.result.CrhListResult;
import com.taotr.stockquant.service.IProviderService;
import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 消费测试接口
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-04-18 18:12
 **/

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Reference
    private IProviderService providerService;

    @RequestMapping(value = "/obj",method = RequestMethod.GET)
    public CrhBeanResult getObject(){
        // 远程调用
        CrhBeanResult<ProviderDTO> providerTestDTOList = providerService.getObject();
        return providerTestDTOList;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CrhListResult getList(){
        // 远程调用
        CrhListResult<ProviderDTO> providerTestDTOList = providerService.getList();
        return providerTestDTOList;
    }
}
package com.taotr.stockquant.provider.service.impl;

/**
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-04-18 17:58
 **/


import com.alibaba.dubbo.config.annotation.Service;
import com.taotr.stockquant.commons.enums.CommonResultCode;
import com.taotr.stockquant.commons.model.um.ProviderDTO;
import com.taotr.stockquant.commons.result.CrhBeanResult;
import com.taotr.stockquant.commons.result.CrhListResult;
import com.taotr.stockquant.service.IProviderService;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者Dubbo接口实现
 * @Author Sans
 * @CreateTime 2019/11/6 23:01
 */
@Service
public class ProviderServiceImpl implements IProviderService {

    @Override
    public CrhBeanResult<ProviderDTO> getObject() {
        CrhBeanResult crhBeanResult = new CrhBeanResult(CommonResultCode.SUCCESS);
        // 初始化数据
        ProviderDTO testDTO1 = new ProviderDTO();
        testDTO1.setId(1);
        testDTO1.setName("学生");
        testDTO1.setNumber(100);
        crhBeanResult.setResult_bean(testDTO1);
        return crhBeanResult;
    }

    @Override
    public CrhListResult<ProviderDTO> getList() {

        CrhListResult crhBeanResult = new CrhListResult(CommonResultCode.SUCCESS);
        // 初始化数据
        ProviderDTO testDTO1 = new ProviderDTO();
        testDTO1.setId(1);
        testDTO1.setName("学生");
        testDTO1.setNumber(100);
        ProviderDTO testDTO2 = new ProviderDTO();
        testDTO2.setId(2);
        testDTO2.setName("教师");
        testDTO2.setNumber(101);
        // 组装数据
        List<ProviderDTO> list = new ArrayList<>();
        list.add(testDTO1);
        list.add(testDTO2);
        crhBeanResult.setList(list);
        return crhBeanResult;
    }
}

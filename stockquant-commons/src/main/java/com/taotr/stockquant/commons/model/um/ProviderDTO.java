package com.taotr.stockquant.commons.model.um;

import lombok.Data;
import java.io.Serializable;

/**
 *  RPC接口DTO
 *  注意这里要实现序列化接口
 * @program: stockquant
 * @description:
 * @author: Mr.cc
 * @create: 2021-04-18 18:04
 **/
@Data
public class ProviderDTO implements Serializable {
    // ID
    private int id;
    // 名字
    private String name;
    // 序号
    private Integer number;
}
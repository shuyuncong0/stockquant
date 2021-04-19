package com.taotr.stockquant.provider.dao.fund;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taotr.stockquant.commons.model.um.Umrights;

import java.util.List;
import java.util.Map;

public interface UmrightsMapper extends BaseMapper<Umrights> {

	List<Map> selectUmrightsPage(Map<String, Object> paramMap);


}

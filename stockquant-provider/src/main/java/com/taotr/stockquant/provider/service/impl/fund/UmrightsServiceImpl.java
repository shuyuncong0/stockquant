package com.taotr.stockquant.provider.service.impl.fund;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.taotr.stockquant.commons.base.BaseServiceImpl;
import com.taotr.stockquant.commons.model.um.Umrights;
import com.taotr.stockquant.commons.model.um.UmrightsVO;
import com.taotr.stockquant.provider.dao.fund.UmrightsMapper;
import com.taotr.stockquant.service.fund.IUmrightsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;


@Service
public class UmrightsServiceImpl  extends BaseServiceImpl<Umrights> implements IUmrightsService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private UmrightsMapper umrightsMapper;


	@Override
	public Map<String, Object> getUmRightsGetList(UmrightsVO regcust_id) {
		Map<String, Object> result = super.getSuccessResultMap();
		Umrights umrights = umrightsMapper.selectById("1");

		//查询文章表
		QueryWrapper<Umrights> queryWrapper = new QueryWrapper<>();
		List<Umrights> articleList = umrightsMapper.selectList(queryWrapper);
		return result;
	}
}

package com.taotr.stockquant.provider.dao;

import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface AllTableSqlMapper {

	
	
    List<Map<String, Object>> commonquery(Map<String, String> param);
}

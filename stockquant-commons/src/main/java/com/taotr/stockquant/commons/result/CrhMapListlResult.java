package com.taotr.stockquant.commons.result;


import com.taotr.stockquant.commons.returncode.ResultCode;

import java.util.List;
import java.util.Map;

public class CrhMapListlResult<T> extends CrhBaseResult {
	
private static final long serialVersionUID = 3070215199804564449L;
	
	private Map<String, Object> result_map;// 用于非结果集返回
	private List<T> result_list;// 用于结果集返回
	
	public CrhMapListlResult(ResultCode resultCode) {
		super(resultCode);
	}

	public CrhMapListlResult(ResultCode resultCode, List<T> list, Map<String, Object> map) {
		super(resultCode);
		this.result_list = list;
		this.result_map = map;
	}

	public Map<String, Object> getResult_map() {
		return result_map;
	}

	public void setResult_map(Map<String, Object> result_map) {
		this.result_map = result_map;
	}

	public List<T> getResult_list() {
		return result_list;
	}

	public void setResult_list(List<T> result_list) {
		this.result_list = result_list;
	}

}

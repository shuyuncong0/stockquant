package com.taotr.stockquant.commons.result;



import com.taotr.stockquant.commons.returncode.ResultCode;

import java.util.HashMap;
import java.util.Map;

public class CrhMapResult extends CrhBaseResult {

	private static final long serialVersionUID = 3070215199804564449L;
	
	private Map<String, Object> res_map = new HashMap<String, Object>();

	
	public Map<String, Object> getRes_map() {
		return res_map;
	}

	public void setRes_map(Map<String, Object> res_map) {
		this.res_map = res_map;
	}
	
    public CrhMapResult(boolean success, String error_no, String error_info, String error_view) {
    	super(success, error_no, error_info, error_view);
    }
    
    public CrhMapResult(boolean success, String error_no, String error_info, String error_view, Map<String, Object> res_map) {
    	super(success, error_no, error_info, error_view);
    	this.res_map = res_map;
    }
    
    public CrhMapResult(ResultCode resultCode, Map<String, Object> res_map) {
    	super(resultCode);
    	this.res_map = res_map;
    }
    
    public CrhMapResult() {
		super();
	}

	public CrhMapResult(ResultCode resultCode) {
    	super(resultCode);
    }
}

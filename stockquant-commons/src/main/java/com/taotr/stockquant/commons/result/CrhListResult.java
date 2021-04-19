package com.taotr.stockquant.commons.result;


import com.taotr.stockquant.commons.returncode.ResultCode;

import java.util.List;

public class CrhListResult<T> extends CrhBaseResult {

	private static final long serialVersionUID = 3070215199804564449L;
	
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public CrhListResult(boolean success, String error_no, String error_info, String error_view) {
    	super(success, error_no, error_info, error_view);
    }
    
    public CrhListResult(boolean success, String error_no, String error_info, String error_view, List<T> list) {
    	super(success,error_no,error_info, error_view);
    	this.list = list;
    }
    
    public CrhListResult(ResultCode resultCode, List<T> list) {
    	super(resultCode);
    	this.list = list;
    }
    
    public CrhListResult() {
		super();
	}

	public CrhListResult(ResultCode resultCode) {
    	super(resultCode);
    }
}

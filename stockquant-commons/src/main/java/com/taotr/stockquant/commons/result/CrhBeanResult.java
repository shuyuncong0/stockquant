package com.taotr.stockquant.commons.result;


import com.taotr.stockquant.commons.returncode.ResultCode;

public class CrhBeanResult<T> extends CrhBaseResult {

	private static final long serialVersionUID = 3070215199804564449L;
	
	private T result_bean;

	public T getResult_bean() {
		return result_bean;
	}

	public void setResult_bean(T result_bean) {
		this.result_bean = result_bean;
	}

	public CrhBeanResult(boolean success, String error_no, String error_info, String error_view) {
    	super(success, error_no, error_info, error_view);
    }
    
    public CrhBeanResult(boolean success, String error_no, String error_info, String error_view, T result_bean) {
    	super(success,error_no,error_info, error_view);
    	this.result_bean = result_bean;
    }
    
    public CrhBeanResult(ResultCode resultCode, T result_bean) {
    	super(resultCode);
    	this.result_bean = result_bean;
    }
    
    public CrhBeanResult() {
		super();
	}

	public CrhBeanResult(ResultCode resultCode) {
    	super(resultCode);
    }
	
}

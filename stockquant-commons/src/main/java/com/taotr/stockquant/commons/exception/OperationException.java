package com.taotr.stockquant.commons.exception;


import com.taotr.stockquant.commons.returncode.ResultCode;

/**
 * 
 */
public class OperationException extends RuntimeException {

    /**
     * 序列化对象
     */
    private static final long serialVersionUID = -7379735002437428654L;

    /** 结果码 */
    private String error_code;

    /** 额外的异常信息 */
    private String error_msg;

    public OperationException(String message) {
        super(message);
    }
    
    /**
     * 
     * 构造函数
     * 
     * @param errorCode
     * @param errorMsg
     */
    public OperationException(String error_code, String error_msg) {
        this.error_code = error_code;
        this.error_msg = error_msg;
    }
    
    public OperationException(ResultCode resultCode) {
        this.error_code = resultCode.getCode();
        this.error_msg = resultCode.getDesc();
    }
    
    
    @Override
    public String getMessage() {
        return error_msg;
    }
    
	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getError_msg() {
		return error_msg;
	}

	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}
}

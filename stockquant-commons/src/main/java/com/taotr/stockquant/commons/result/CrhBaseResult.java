package com.taotr.stockquant.commons.result;

import com.taotr.stockquant.commons.enums.CommonResultCode;
import com.taotr.stockquant.commons.returncode.ResultCode;

import java.io.Serializable;


/**
 * @Type CommonResult
 * @Desc 标准通用结果
 * @author xuhailun
 * @date 2015-10-27
 * @Version V1.0
 */
public class CrhBaseResult implements Serializable {

	
	private static final long serialVersionUID = -4641709205708801779L;

	/** 成功状态 */
    private boolean success;

    /** 结果码 */
    private String error_no;
    
    /** 结果描述 */
    private String error_info;
    
    /** 错误结果显示 */
    private String error_view;
    

    /**
     * 默认构造函数。
     */
    public CrhBaseResult() {
        super();
    }

    /**
     * 全参构造函数。
     * 
     */
    public CrhBaseResult(boolean success, String error_no, String error_info, String error_view) {
    	this.success = success;
        this.error_no = error_no;
        this.error_info = error_info;
        this.error_view = error_view;
    }
    
    
    public CrhBaseResult(ResultCode resultCode) {
    	this.success = CommonResultCode.SUCCESS.getCode().equals(resultCode.getCode())?true:false;
        this.error_no = resultCode.getCode();
        this.error_info = resultCode.getDesc();
    }
    

	public String getError_no() {
		return error_no;
	}

	public void setError_no(String error_no) {
		this.error_no = error_no;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String error_info) {
		this.error_info = error_info;
	}

	public String getError_view() {
		return error_view;
	}

	public void setError_view(String error_view) {
		this.error_view = error_view;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}

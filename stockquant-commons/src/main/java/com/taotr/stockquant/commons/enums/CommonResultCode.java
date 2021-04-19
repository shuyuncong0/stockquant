package com.taotr.stockquant.commons.enums;


import com.taotr.stockquant.commons.returncode.ResultCode;

/**编号范围 320000 -320999*/
public enum CommonResultCode implements ResultCode {
			
    /** 处理成功 */
    SUCCESS("0", "处理成功", "处理成功"),
    
    FAIL("320001", "处理失败", "处理失败"),
    PART_FAIL("320002", "部分处理失败", "网络繁忙，请重试。"),
    UNKNOWN_ERROR("320003", "未知异常", "网络繁忙，请重试。"),
    ILLEGAL_PARAMETERS("320004", "非法参数", "网络繁忙，请重试。"),
    ILLEGAL_REQUEST("3200017", "非法请求", "网络繁忙，请重试。"),
    SYSTEM_ERROR("320005", "系统错误", "网络繁忙，请重试。"),
    FAIL_TO_OTHER_REASON("320006", "其他原因失败", "网络繁忙，请重试。"),
    DATA_REPEAT("320007", "获取数据重复", "处理失败"),
    OPER_HIGH("320008", "高频操作", "处理失败"),

    TOKEN_EXPRIED_ERR("320009", "无效登录", "token已经过期"),
    TOKEN_INVALID_ERR("320010", "无效登录", "token非法"),
    TOKEN_GEN_ERR("320011", "无效登录", "token生成异常"),
    
    SIGN_GEN_ERR("320012", "非授权接入", "sign生成异常"),
    SIGN_INVALID_ERR("320013", "非授权接入", "sign签名非法"),
    SIGN_EXPRIED_ERR("320014", "非授权接入", "sign授权已经过期"),
    SIGN_NOTEXISTS_ERR("320015", "非授权接入", "sign未设置"),
    EMPTY_PARAMETERS("320016", "请求参数不能为空", "请求参数不能为空"),
    
    
    /*
    PROTECT_WORD("19","保护词异常","保护词异常"),

    MOBILE_FORMAT_ERR("10", "手机号码格式错误", "手机号码格式错误"),

    EMAIL_FORMAT_ERR("11", "邮箱格式错误", "邮箱格式错误"),

    REGCUST_ID_UNKNOW("12","该用户不存在","该用户不存在"),

   
    USER_PWD_UNIDENTICAL("13","两次输入的密码不一致","两次输入的密码不一致"),

    USER_OLDPWD_ERROR("14","旧密码错误","旧密码错误"),

    USER_REG_ACCTYPE_ERROR("15","请选择账号类别","请选择账号类别"),

    USER_REG_ACC_ERROR("16","请填写正确的账号","请填写正确的账号"),

    USER_REG_VERIFYCODE_ERROR("17","短信验证码不正确","短信验证码不正确"),

    
    USER_REG_EXIST("17","账号已被注册","账号已被注册"),

    TOKEN_EXPRIED_ERR("20", "无效登录", "token已经过期"),
    TOKEN_INVALID_ERR("21", "无效登录", "token非法"),
    TOKEN_GEN_ERR("22", "无效登录", "token生成异常"),
    
    SIGN_GEN_ERR("25", "非授权接入", "sign生成异常"),
    SIGN_INVALID_ERR("26", "非授权接入", "sign签名非法"),
    SIGN_EXPRIED_ERR("27", "非授权接入", "sign授权已经过期"),
    SIGN_NOTEXISTS_ERR("28", "非授权接入", "sign未设置"),
     
    
    REGCUST_STATUS_ERROR("30","用户状态不正常","用户状态不正常"),
    
    EMPTY_PARAMETERS("31","参数不能为空","参数不能为空"),
    
    IMAGE_CODE_ERROR("32", "验证码错误", "验证码错误"),
    */
    
    ;

    /** 错误码 */
    private String code;

    /** 描述 */
    private String desc;

    /** 显示错误内容 */
    private String view;

    /**
     * 构造函数
     * 
     * @param code 错误码
     * @param desc 描述
     * @param view 显示错误内容
     */
    private CommonResultCode(String code, String desc, String view) {
        this.code = code;
        this.desc = desc;
        this.view = view;
    }

    /**
     * 通过name获取结果码
     * 
     * @param code 错误码
     * @return 返回业务结果码
     */
    public static CommonResultCode getResultEnum(String code) {
        for (CommonResultCode result : values()) {
            if (result.getCode().equalsIgnoreCase(code)) {
                return result;
            }
        }
        return null;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

   
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

   
    public String getView() {
        return view;
    }

    
    public void setView(String view) {
        this.view = view;
    }

}

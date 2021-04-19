package com.taotr.stockquant.commons.returncode;


/**编号范围 321000 -321999*/
public enum UCResultCode implements ResultCode{

	ACCOUNT_EXISTS("321000", "账户已经存在", "账户已经存在"), 
	
	USER_REG_ACCTYPE_ERROR("321001", "非授权账户类别", "非授权账户类别"),
	USER_REG_ACC_ERROR("321002", "请填写正确的账号", "请填写正确的账号"),
	REGCUST_STATUS_ERROR("321003", "用户状态不正常", "用户状态不正常"), 
	REGCUST_ID_UNKNOW("321004", "用户不存在", "用户不存在"),	
	
	USER_BIND_NOTEXISTS("321005", "绑定账户不存在", "绑定账户不存在"),
	USER_BIND_ERROR("321006", "绑定账户不匹配", "绑定账户不匹配"),	
	USER_UNBIND_NOTEXISTS("321007", "解绑账户不存在", "解绑账户不存在"),
	USER_UNBIND_ERROR("321008", "解绑账户不匹配", "解绑账户不匹配"),
    USER_ACCOUNT_BINDED("321024", "账户已经被绑定", "账户已经被绑定"),
    USER_MERGE_FAIL("321045", "账户合并失败", "账户合并失败"),
    
    USER_ACCTYPE_BINDED("321025", "该账户类型已经绑定", "该账户类型已经绑定"),
	MOBILE_IMPERFECT_ERR("321026", "需要完善手机号码", "需要完善手机号码"),
    USER_BIND_MOBILE_ERROR("321027", "该手机号码已经绑定资金账号", "该手机号码已经绑定资金账号"),
    USER_MOBILE_UNBIND_ERROR("321028", "该账户未绑定资金账号", "该账户未绑定资金账号"),

	USER_PWD_UNIDENTICAL("321009", "两次输入的密码不一致", "两次输入的密码不一致"),
	USER_OLDPWD_ERROR("321010", "旧密码错误", "旧密码错误"),
	USER_PWD_ERROR("321011", "登录密码错误", "登录密码错误"),
	CHECK_WEAK_PWD("321012", "密码过于简单", "密码过于简单"),
	NICK_NAME_EXISTS("321013", "该用户昵称已存在", "该用户昵称已存在"),
	BADWORD_PROTECT("321014", "存在保留词，请重新输入", "存在保留词，请重新输入"),
	BADWORD_FILTER("321015", "存在敏感词，请重新输入", "存在敏感词，请重新输入"),
	
	MOBILE_FORMAT_ERR("321017", "手机号码格式错误", "手机号码格式错误"),
	EMAIL_FORMAT_ERR("321018", "邮箱格式错误", "邮箱格式错误"),		
	VERIFYCODE_ERROR("321019", "短信验证码不正确", "短信验证码不正确"),
	IMAGECODE_ERROR("321020", "图形验证码不正确", "图形验证码不正确"),
	
	VERIFYCODE_SEND_DAYLIMIT("321045", "短信验证码数量限制", "短信验证码数量限制"),
	VERIFYCODE_SEND_FREQUENCYLIMIT("321046","请稍后再获取短信验证码", "请稍后再获取短信验证码"),
	VERIFYCODE_NEEED_IMAGECODE("321047","请先获取图形验证码", "请先获取图形验证码"),
	
	NICK_NAME_NOT_NULL("321024", "用户昵称不能为空", "用户昵称不能为空"),
	USER_PWD_NOT_NULL("321022", "密码不能为空", "密码不能为空"),
	BADWORD_NOT_NULL("321023", "输入不能为空", "输入不能为空"),
	BADWORD_CHECK_ERROR("321029", "敏感词校验不通过", "敏感词校验不通过"),

	PRIVILEGES_NOT_EXIST("321030","权限不存在","权限不存在"),
	PRIVILEGES_OP_ERROR("321031","特权配置异常","特权配置异常"),
	CUSTPRIVILEGES_NOT_EXIST("321040","用户权限不存在","用户权限不存在"),
	CUSTPRIVILEGES_NOT_ENOUGH("321041","用户权限不足","用户权限不足"),
	VERIFYCODE_SEND_FAIL("321042", "短信验证码发送失败", "短信验证码发送失败"),
	CUSTPRIVILEGES_OVERDUE("321043","用户权限已过期","用户权限已过期"),
	
	THIRDPART_AUTHLOGIN_FAIL("321044","登录失败","第三方授权登录失败"),
	
    CHG_MOBILE_BIND_ACC_ERROR("321045","请使用手机号绑定资金账户校验","请使用手机号绑定资金账户校验"),
    THIRDPART_ADDRESS_NOT_EXISTS("321046","第三方平台地址信息不存在","第三方平台地址信息不存在"),
    HA_LOGIN_PRIVATEKEY_ERROR("334060","尚未配置登录私钥","尚未配置登录私钥"),
    THIRDPART_UMLEVEL_NOTFUND("334061","未获取到三方系统会员信息","未获取到三方系统会员信息"),
    CANNOT_FOUND_CLIENT_ID("334062","客户号查无资金账号信息","客户号查无资金账号信息"),
	SYNC_LEVELINFO_FAILED("334063","同步权益会员等级信息失败","同步权益会员等级信息失败"),
	UM_RIGHTS_NOT_EXISTS("334064","会员权益不存在","会员权益不存在"),
	UM_RIGHTSPROD_NOT_EXISTS("334064","会员权益产品不存在","会员权益产品不存在")
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
	 * @param code
	 *            错误码
	 * @param desc
	 *            描述
	 * @param view
	 *            显示错误内容
	 */
	private UCResultCode(String code, String desc, String view) {
		this.code = code;
		this.desc = desc;
		this.view = view;
	}

	/**
	 * 通过name获取结果码
	 * 
	 * @param code
	 *            错误码
	 * @return 返回业务结果码
	 */
	public static UCResultCode getResultEnum(String code) {
		for (UCResultCode result : values()) {
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

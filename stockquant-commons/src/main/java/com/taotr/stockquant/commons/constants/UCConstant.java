package com.taotr.stockquant.commons.constants;

public class UCConstant {
	
   public static final String CUR_SUB_SYS_NO ="17";

   public static final String DATETIME_BEGIN = " 00:00:00"; //每天的开始时刻
   public static final String DATETIME_END = " 23:59:59"; //每天的结束时刻

   //业务编号
   public static final String BIZ_UC_REGISTER ="6400";  // 用户注册
   public static final String BIZ_UC_RESETPWD ="6401"; //找回密码 
   public static final String BIZ_UC_LOGIN ="6402"; //登录  
   public static final String BIZ_UC_CHNAGE_MOBILE ="6403"; //变更手机号
 
   public static final String BIZ_RIGHTS_DEL ="6599"; //DEL
   public static final String BIZ_RIGHTS_SET ="6598"; //set
   public static final String BIZ_RIGHTS_CUT ="6597"; //cut
   public static final String BIZ_RIGHTS_EXP ="6596"; //exp
   
   public static final String UC_VALIDATECODE_TYPE = "uc.validatecode.type";
   
   public static final String UC_REQUEST_PARAMS = "请求参数%s不能为空";

   public static final String UM_RIGHTS_DESC = "已获得";
}

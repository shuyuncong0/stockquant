package com.taotr.stockquant.commons.enums;



import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum UmRightsGainStatus {
    APPLYING("1","申请中"),    // 申请中
    APPLY_SUCCESS("8","成功"),      // 成功
    APPLY_FAILURE("9","失败")     // 失败
    ;

    private String code;

    private String desc;

    private UmRightsGainStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static UmRightsGainStatus getGainStatusByCode(String code) {
        for (UmRightsGainStatus temp: UmRightsGainStatus.values()) {
            if (StringUtils.equals(code, temp.getCode())) {
                return temp;
            }
        }
        return null;
    }

    public static String getDescByCode(String code) {
        for (UmRightsGainStatus transType : UmRightsGainStatus.values()) {
            if (StringUtils.equals(code, transType.getCode())) {
                return transType.getDesc();
            }
        }
        return null;
    }


    public static List<Map<String, String>> getAllGainStatus() {
        List<Map<String, String>> mapList = new ArrayList<>();
        for (UmRightsGainStatus temp : UmRightsGainStatus.values()) {
            Map<String,String> data = new HashMap<>();
            data.put("code", temp.getCode());
            data.put("desc", temp.getDesc());
            mapList.add(data);
        }
        return mapList;
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
}

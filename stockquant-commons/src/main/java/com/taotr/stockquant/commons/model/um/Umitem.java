package com.taotr.stockquant.commons.model.um;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName(value = "crh_uc.umitem")
@KeySequence(value = "crh_uc.umitem_seq")
public class
Umitem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId
    private String prod_id;

    private String level1;

    private String prod_name;

    private String brief_info;

    private String icon_url;

    private String img_url;

    private String prod_content;

    private String status;

}
package com.taotr.stockquant.commons.model.um;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
@TableName(value = "umrightsget")
//@KeySequence(value = "crh_uc.umrightsget_seq")
public class Umrightsget implements Serializable {

	private static final long serialVersionUID = 1L;
	

    private String serial_no;

    private String regcust_id;

    @TableId
    private String rights_id;
    

}
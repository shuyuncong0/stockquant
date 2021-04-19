package com.taotr.stockquant.commons.model.um;

import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;


@Data
@TableName(value = "l78z.umrights")
//@KeySequence(value = "crh_uc.umrights_seq")
public class Umrights implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@TableId
    private String rights_id;

    private String serial_no;

    private String regcust_id;
    

}
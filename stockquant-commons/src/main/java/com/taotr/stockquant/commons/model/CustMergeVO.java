package com.taotr.stockquant.commons.model;

import java.io.Serializable;

public class CustMergeVO implements Serializable {

    private String serial_no;
	
	private String regcust_id;

	private String old_regcust_id;
	
	private long  occur_datetime;
	
	

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getRegcust_id() {
		return regcust_id;
	}

	public void setRegcust_id(String regcust_id) {
		this.regcust_id = regcust_id;
	}

	public String getOld_regcust_id() {
		return old_regcust_id;
	}

	public void setOld_regcust_id(String old_regcust_id) {
		this.old_regcust_id = old_regcust_id;
	}

	public long getOccur_datetime() {
		return occur_datetime;
	}

	public void setOccur_datetime(long occur_datetime) {
		this.occur_datetime = occur_datetime;
	}

}

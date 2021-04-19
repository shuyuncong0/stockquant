package com.taotr.stockquant.commons.model.um;

import lombok.Data;

import java.io.Serializable;


@Data
public class UmrightsVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String rightsbiz_id;

    private String rightsbiz_name;
    
    private String light_level;
    
    private String link_type;
    
    private String link_url;
    
    private String rights_light_img;
    
    private String rights_nolight_img;
    
    private String gain_way;

    private String rights_id;
    
    private String rights_kind;
    
    private String gain_type;
    
}
package com.taotr.stockquant.service.fund;



import com.taotr.stockquant.commons.model.um.UmrightsVO;

import java.util.Map;

public interface IUmrightsService {

	Map<String, Object> getUmRightsGetList(UmrightsVO regcust_id);

}

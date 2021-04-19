package com.taotr.stockquant.service;

import com.taotr.stockquant.commons.model.um.ProviderDTO;
import com.taotr.stockquant.commons.result.CrhBeanResult;
import com.taotr.stockquant.commons.result.CrhListResult;

public interface IProviderService {

    CrhBeanResult<ProviderDTO> getObject();

    CrhListResult<ProviderDTO> getList();
}

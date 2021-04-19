package com.taotr.stockquant.api.fund;


import com.taotr.stockquant.commons.model.um.UmrightsVO;
import com.taotr.stockquant.service.fund.IUmrightsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UmRightsController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Reference
	private IUmrightsService umrightsService;


    /**
     * 查询会员权益领取情况,用户领取情况表（参数：权益业务 权益id  等级  用户token）
     * @Param: uc
     * @return:
     */
    @RequestMapping("/um/rights/inquiry")
    public Object quiryUmRightsGetList(UmrightsVO rights_id) {
        umrightsService.getUmRightsGetList(rights_id);
        return null;
    }





}
package com.xpyz.lotterdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpyz.lotterdata.apis.ILotterDataService;
import com.xpyz.lotterdata.apis.ILotterDataLoader;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 开奖信息服务
 * 
 * @author Ajaxfan
 */
@Service("lotterDataService")
final class LotterDataService implements ILotterDataService {
    /** 数据载入工具 */
    private @Autowired ILotterDataLoader<LotterBean> dataLoadFacade;

    @Override
    public void synchnizedRemoteDataToLocal(String url) {
        List<LotterBean> list = dataLoadFacade.load(url);

        for (LotterBean bean : list) {
            System.out.println("----------------------------");
            System.out.println(bean.getLotterNo());
            System.out.println(bean.getLotterResult());
            System.out.println(bean.getLotterDate());
            System.out.println("----------------------------");
        }
    }
}

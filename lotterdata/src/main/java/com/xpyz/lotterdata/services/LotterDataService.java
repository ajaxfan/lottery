package com.xpyz.lotterdata.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xpyz.lotterdata.apis.ILotterDataDao;
import com.xpyz.lotterdata.apis.ILotterDataLoader;
import com.xpyz.lotterdata.apis.ILotterDataService;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 开奖信息服务
 * 
 * @author Ajaxfan
 */
@Service("lotterDataService")
final class LotterDataService implements ILotterDataService {
    /** 要检查的连续数据量 */
    private @Value("${data.continulity.count}") int continulityCount;
    /** 数据载入工具 */
    private @Autowired ILotterDataLoader<LotterBean> dataLoadFacade;
    /** 数据服务 */
    private @Autowired ILotterDataDao<LotterBean> lotterDataDao;

    /**
     * 远端数据写入到本地
     * 
     * @param url
     *            服务器地址
     */
    @Override
    public synchronized void synchnizedRemoteDataToLocal(String url) {
        lotterDataDao.writeData2db(dataLoadFacade.load(url));
    }

    /**
     * 检查现有数据是否连续
     * 
     * @return
     */
    public boolean isDataContinulity() {
        List<LotterBean> list = lotterDataDao.getRecordByCount(continulityCount);

        if (list.size() < continulityCount) {// 如果数据量小于规定数值，也需要返回false
            return false;
        }

        // 前一个号码
        int lotterNo = 0;
        for (LotterBean bean : list) {// 比对号码是否连续
            int no = Integer.parseInt(bean.getLotterNo());

            if (lotterNo > 0 && lotterNo - no > 1) {
                return false;
            }
            lotterNo = no;
        }
        return true;
    }
}

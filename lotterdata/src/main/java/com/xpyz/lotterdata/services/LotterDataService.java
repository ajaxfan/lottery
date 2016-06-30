package com.xpyz.lotterdata.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void synchnizedRemoteDataToLocal(String url) {
		lotterDataDao.writeData2db(dataLoadFacade.load(url));
	}
}

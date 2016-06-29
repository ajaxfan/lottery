package com.xpyz.lotterdata.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xpyz.lotterdata.inters.IDataLoaderFacade;
import com.xpyz.lotterdata.models.LotterBean;
import com.xpyz.lotterdata.services.ILotterDataService;

/**
 * 开奖信息服务
 * 
 * @author Ajaxfan
 */
@Service("lotterDataService")
final class LotterDataService implements ILotterDataService {
	private @Autowired IDataLoaderFacade<LotterBean> dataLoadFacade;

	public void saveData() {
		List<LotterBean> list = dataLoadFacade.load("http://www.bwlc.net/bulletin/trax.html");

		for (LotterBean bean : list) {
			System.out.println("----------------------------");
			System.out.println(bean.getLotterNo());
			System.out.println(bean.getLotterResult());
			System.out.println(bean.getLotterDate());
			System.out.println("----------------------------");
		}
	}
}

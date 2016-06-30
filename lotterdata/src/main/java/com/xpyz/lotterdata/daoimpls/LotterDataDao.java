package com.xpyz.lotterdata.daoimpls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xpyz.lotterdata.apis.ILotterDataDao;
import com.xpyz.lotterdata.mappers.ILotterDataMapper;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 保存数据到数据库中
 * 
 * @author Ajaxfan
 */
@Repository
class LotterDataDao implements ILotterDataDao<LotterBean> {
	/***/
	private @Autowired ILotterDataMapper lotterDataMapper;

	/**
	 * @param records
	 */
	@Override
	public void writeData2db(List<LotterBean> records) {
		for (LotterBean bean : records) {
			lotterDataMapper.insertRecord(bean);
		}
	}

	/**
	 * @return
	 */
	@Override
	public LotterBean getLastRecord() {
		return lotterDataMapper.findLastRecord();
	}
}

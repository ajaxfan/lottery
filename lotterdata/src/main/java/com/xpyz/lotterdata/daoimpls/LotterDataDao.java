package com.xpyz.lotterdata.daoimpls;

import java.text.MessageFormat;
import java.util.List;

import org.apache.log4j.Logger;
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
	/** 数据工具 */
	private @Autowired ILotterDataMapper lotterDataMapper;
	/** 日志工具 */
	private Logger logger = Logger.getLogger("com.xpyz.lotterdata");

	/**
	 * @param records
	 */
	@Override
	public void writeData2db(List<LotterBean> records) {
		int size = records.size();// 数据总量
		int successSize = 0;// 有效数据量

		try {
			successSize = lotterDataMapper.insertRecord(records);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info(MessageFormat.format("共获得数据{0}条，其中有效数据{1}条。", size, successSize));
	}

	/**
	 * @return
	 */
	@Override
	public LotterBean getLastRecord() {
		return lotterDataMapper.findLastRecord();
	}
}

package com.xpyz.lotterdata.daos;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xpyz.lotterdata.apis.ILotterDataSaver;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 保存数据到数据库中
 * 
 * @author Ajaxfan
 */
@Repository
final class LotterDataSaver implements ILotterDataSaver<LotterBean> {

	/**
	 * @param records
	 */
	@Override
	public void writeData2db(List<LotterBean> records) {
	}
}

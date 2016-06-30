package com.xpyz.lotterdata.apis;

import java.util.List;

import com.xpyz.lotterdata.models.LotterBean;

/**
 * 保存开奖信息
 * 
 * @author Ajaxfan
 */
public interface ILotterDataDao<T> {
	/**
	 * 数据写入到本地数据库
	 * 
	 * @param records
	 */
	public void writeData2db(List<T> records);

	/**
	 * 获取最新的数据记录
	 * 
	 * @return
	 */
	public LotterBean getLastRecord();
}

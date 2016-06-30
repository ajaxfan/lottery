package com.xpyz.lotterdata.mappers;

import com.xpyz.lotterdata.models.LotterBean;

import tk.mybatis.mapper.common.Mapper;

/**
 *
 * @author Ajaxfan
 */
public interface ILotterDataMapper {
	public void insertRecord(LotterBean bean);
	public LotterBean findLastRecord();
}

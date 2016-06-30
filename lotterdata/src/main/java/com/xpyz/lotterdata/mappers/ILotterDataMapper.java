package com.xpyz.lotterdata.mappers;

import java.util.List;

import com.xpyz.lotterdata.models.LotterBean;

/**
 *
 * @author Ajaxfan
 */
public interface ILotterDataMapper {
	public int insertRecord(List<LotterBean> bean);
	public LotterBean findLastRecord();
}

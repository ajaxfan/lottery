package com.xpyz.lotterdata.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.IHtmlConvertor;
import com.xpyz.lotterdata.apis.IHtmlReader;
import com.xpyz.lotterdata.apis.ILotterDataBuilder;
import com.xpyz.lotterdata.apis.ILotterDataLoader;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 数据读取工具集合
 * 
 * @author Ajaxfan
 */
@Component
final class DataLoadFacade implements ILotterDataLoader<LotterBean> {
	/** 数据读取 */
	private @Autowired IHtmlReader htmlReader;
	/** 数据转换 */
	private @Autowired IHtmlConvertor<LotterBean> htmlConvertor;
	/** 数据构建工具 */
	private @Autowired ILotterDataBuilder<LotterBean> dataCollectionBuilder;
	
	/**
	 * 数据读取工具
	 * 
	 * @param str
	 * @return
	 */
	public List<LotterBean> load(String str) {
		// 按步骤构建数据集合
		dataCollectionBuilder.createRemoteConnection(str);
		dataCollectionBuilder.readHtmlFromStream(htmlReader);
		dataCollectionBuilder.buildJavaCollectionFromHtml(htmlConvertor);

		return dataCollectionBuilder.getLotterDatas();
	}
}

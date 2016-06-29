package com.xpyz.lotterdata.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.inters.IDataCollectionBuilder;
import com.xpyz.lotterdata.inters.IDataLoaderFacade;
import com.xpyz.lotterdata.inters.IHtmlConvertor;
import com.xpyz.lotterdata.inters.IHtmlReader;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 数据读取工具集合
 * 
 * @author Ajaxfan
 */
@Component
public class DataLoadFacade implements IDataLoaderFacade<LotterBean> {
	/** 数据读取 */
	private @Autowired IHtmlReader htmlReader;
	/** 数据转换 */
	private @Autowired IHtmlConvertor<LotterBean> htmlConvertor;
	/** 数据构建工具 */
	private @Autowired IDataCollectionBuilder<LotterBean> dataCollectionBuilder;

	/**
	 * 数据读取工具
	 * 
	 * @param str
	 * @return
	 */
	public List<LotterBean> load(String str) {
		// 按步骤构建数据集合
		dataCollectionBuilder.buildUrl(str);
		dataCollectionBuilder.buildHtmlContent(htmlReader);
		dataCollectionBuilder.buildDataCollection(htmlConvertor);

		return dataCollectionBuilder.getDataCollection();
	}
}

package com.xpyz.lotterdata.inters;

import java.util.List;

/**
 * 数据集合构建工具
 * 
 * @author Ajaxfan
 */
public interface IDataCollectionBuilder<T> {
	/**
	 * @param url 访问的地址
	 */
	public void buildUrl(String str);

	/**
	 * 构建读取到的内容
	 */
	public void buildHtmlContent(IHtmlReader reader);

	/**
	 * 构建数据集合
	 */
	public void buildDataCollection(IHtmlConvertor<T> convert);

	/**
	 * @return 获得最终的数据集合
	 */
	public List<T> getDataCollection();
}

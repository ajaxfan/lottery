package com.xpyz.lotterdata.apis;

import java.util.List;

/**
 * HTML数据转换
 * 
 * @author Ajaxfan
 */
public interface IHtmlConvertor<T> {
	/**
	 * 转换为Java数据集合
	 * 
	 * @param html
	 * @return
	 */
	public List<T> convert2JavaObject(String html);
}

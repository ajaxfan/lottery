package com.xpyz.lotterdata.inters;

import java.util.List;

/**
 * 数据同步
 * 
 * @author Ajaxfan
 */
public interface IDataLoaderFacade<T> {
	/**
	 * @param str
	 *            数据读取地址
	 * @return
	 */
	public List<T> load(String str);
}

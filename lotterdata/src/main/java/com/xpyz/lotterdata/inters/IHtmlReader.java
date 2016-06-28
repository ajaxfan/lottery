package com.xpyz.lotterdata.inters;

import java.net.URL;

/**
 * HTML页面信息读取
 * 
 * @author Ajaxfan
 */
public interface IHtmlReader {
	/**
	 * @return HTML页面内容
	 */
	public String readHtmlContent(URL url);
}

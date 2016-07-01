package com.xpyz.lotter.helpers;

/**
 *
 * @author Ajaxfan
 */
public final class StringUtil {
	private StringUtil() {

	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNullOrEmpty(String value) {
		return value == null || value.trim().length() == 0;
	}
}

package com.xpyz.lotterdata.converts;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.inters.IHtmlConvertor;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * HTML文本转换
 * 
 * @author Ajaxfan
 */
@Component
final class HtmlConvert implements IHtmlConvertor<LotterBean> {
	/** 正则匹配规则 */
	private Pattern pattern = Pattern.compile("<tr>([\\d\\Wtd])+</tr>");

	/**
	 * 文本转换为Java对象
	 * 
	 * @param html
	 * @return
	 */
	public List<LotterBean> convert2JavaObject(String html) {
		Matcher matcher = pattern.matcher(html);

		while (matcher.find()) {
			System.out.println(matcher.group().replaceAll("(<td>)|(</td>)", ""));
		}

		return null;
	}
}

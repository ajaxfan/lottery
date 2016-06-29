package com.xpyz.lotterdata.converts;

import java.util.ArrayList;
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
	private static Pattern html_pattern = Pattern.compile("<tr>([\\d\\Wtd])+</tr>");
	private static Pattern tr_pattern = Pattern.compile("<td>([\\d\\W])+</td>");

	/**
	 * 文本转换为Java对象
	 * 
	 * @param html
	 * @return
	 */
	public List<LotterBean> convert2JavaObject(String html) {
		List<LotterBean> list = new ArrayList<LotterBean>();
		Matcher matcher = html_pattern.matcher(html);

		while (matcher.find()) {
			List<String> tds = expand2tds(matcher.group());

			if (tds.size() == 3) {
				LotterBean bean = new LotterBean();
				bean.setLotterNo(tds.get(0));
				bean.setLotterResult(tds.get(1));
				bean.setLotterDate(tds.get(2));

				list.add(bean);
			}
		}
		return list;
	}

	/**
	 * 展开TR对象，生成TD数据集合
	 * 
	 * @param tr
	 * @return
	 */
	private List<String> expand2tds(String tr) {
		Matcher matcher = tr_pattern.matcher(tr);

		List<String> list = new ArrayList<String>();
		while (matcher.find()) {
			list.add(matcher.group().replaceAll("(<td>)|(</td>)", ""));
		}
		return list;
	}
}

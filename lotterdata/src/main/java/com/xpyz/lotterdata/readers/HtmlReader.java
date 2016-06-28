package com.xpyz.lotterdata.readers;

import java.io.IOException;
import java.net.URL;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.ParserException;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.inters.IHtmlReader;

/**
 * HTML内容读取
 * 
 * @author Ajaxfan
 */
@Component
final class HtmlReader implements IHtmlReader {
	/** 去除文本中包含该的样式索引 */
	private static final String REPLACE_PATTERN = "((\\s)*(class=\"(odd)?\")?)";

	/**
	 * 读取指定网址下的制定内容文本
	 * 
	 * @param url
	 *            读取数据的地址
	 * @return
	 */
	public String readHtmlContent(URL url) {
		StringBuilder sb = new StringBuilder();

		try {
			// Dom节点名称过滤器
			Parser parser = new Parser(url.openConnection());

			// 设置要读取的html标签名称
			NodeFilter tagNameFilter = new TagNameFilter("tr");
			// 设置过滤属性所需要的条件
			NodeFilter filter1 = new HasAttributeFilter("class", "");
			NodeFilter filter2 = new HasAttributeFilter("class", "odd");

			// 应用过滤条件，查询出满足上面过滤条件的全部数据
			AndFilter andfilter = new AndFilter(tagNameFilter, new OrFilter(filter1, filter2));

			// 读取到的结果文本
			sb.append(replaceClassIndicator(parser.extractAllNodesThatMatch(andfilter).toHtml()));
		} catch (ParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * @param html
	 * @return
	 */
	private String replaceClassIndicator(String html) {
		return html.replaceAll(REPLACE_PATTERN, "");
	}
}

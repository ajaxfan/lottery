package com.xpyz.lotterdata;

import java.net.URL;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.junit.Test;

public class LoadDemo {

	@Test
	public void load() throws Exception {
		// 要连接的网址 (202: 江西时时彩)
		URL url = new URL("http://www.bwlc.net/bulletin/trax.html");
		// HTML解析器
		Parser parser = new Parser(url.openConnection());

		// Dom节点名称过滤器
		TagNameFilter tagNameFilter = new TagNameFilter("tr");
		// 属性过滤器
		HasAttributeFilter td2Filter = new HasAttributeFilter("class", "");
		HasAttributeFilter td3Filter = new HasAttributeFilter("class", "odd");
		// 与过滤器
		AndFilter andfilter = new AndFilter(tagNameFilter, new OrFilter(td2Filter, td3Filter));
		// 过滤节点
		NodeList nodes = parser.extractAllNodesThatMatch(andfilter);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nodes.size(); i++) {
			String str = nodes.elementAt(i).toHtml();

			System.out.println(str);
		}
	}
}

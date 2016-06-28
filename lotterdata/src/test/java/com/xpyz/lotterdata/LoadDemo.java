package com.xpyz.lotterdata;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.junit.Test;

public class LoadDemo {

	@Test
	public void load() throws Exception {
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
		
		eval(parser.extractAllNodesThatMatch(andfilter).toHtml().replaceAll("((\\s)*(class=\"(odd)?\")?)", ""));
	}
	
	private void eval(String str){
		Pattern pattern = Pattern.compile("<tr>([\\d\\Wtd])+</tr>");
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()){
			System.out.println(matcher.group());
//			System.out.println(matcher.group().replaceAll("(<td>)|(</td>)", ""));
		}
	}
}

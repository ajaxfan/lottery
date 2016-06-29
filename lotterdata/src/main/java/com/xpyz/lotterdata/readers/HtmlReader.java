package com.xpyz.lotterdata.readers;

import java.io.IOException;
import java.net.URL;

import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.ParserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.IHtmlReader;

/**
 * HTML内容读取
 * 
 * @author Ajaxfan
 */
@Component
final class HtmlReader implements IHtmlReader {
    /** 去除文本中包含该的样式索引 */
    private @Value("${regular.html.cssclass}") String REPLACE_PATTERN;
    
    /** 日志工具 */
    private Logger log = LoggerFactory.getLogger("com.xpyz.lotterdata");

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

            // 针对我们需要的标签进行过滤，找到页面中所有class为空或odd的tr标签
            AndFilter andfilter = new AndFilter(new TagNameFilter("tr"),
                    new OrFilter(new HasAttributeFilter("class", ""), new HasAttributeFilter("class", "odd")));

            // 读取到的结果文本
            sb.append(replaceClassIndicator(parser.extractAllNodesThatMatch(andfilter).toHtml()));
        } catch (ParserException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return sb.toString();
    }

    /**
     * 去除HTML中与数据无关的信息
     * 
     * @param html  HTML文本
     * @return
     */
    private String replaceClassIndicator(String html) {
        return html.replaceAll(REPLACE_PATTERN, "");
    }
}

package com.xpyz.lotterdata.converts;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.IHtmlConvertor;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * HTML文本转换
 * 
 * @author Ajaxfan
 */
@Component
final class HtmlConvert implements IHtmlConvertor<LotterBean> {
    /** 每一期的记录过滤条件 */
    private @Value("${regular.lotter.record.pattern}") String lotter_record_pattern;
    /** 每一期记录中单独一个数据项的过滤条件 */
    private @Value("${regular.lotter.record.item.pattern}") String lotter_record_item_pattern;
    /** 与内容无关标签的替换规则 */
    private @Value("${regular.html.td}") String td_tag_text;

    /**
     * 文本转换为Java对象
     * 
     * @param html
     * @return
     */
    public List<LotterBean> convert2JavaObject(String html) {
        Matcher matcher = Pattern.compile(lotter_record_pattern).matcher(html);
        List<LotterBean> list = new ArrayList<LotterBean>();

        while (matcher.find()) {// 读取每一条开奖信息，并对其内容进行过滤
            List<String> tds = expand2tds(matcher.group());

            if (tds.size() >= 3) {// 分析当前版本，每条开奖记录只有是三个属性
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
        Matcher matcher = Pattern.compile(lotter_record_item_pattern).matcher(tr);
        List<String> list = new ArrayList<String>();

        while (matcher.find()) {// 遍历一天记录中每一个属性
            list.add(matcher.group().replaceAll("td_tag_match", ""));
        }
        return list;
    }
}

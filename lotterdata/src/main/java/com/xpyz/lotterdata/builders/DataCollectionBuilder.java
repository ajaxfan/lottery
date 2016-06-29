package com.xpyz.lotterdata.builders;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.IHtmlConvertor;
import com.xpyz.lotterdata.apis.IHtmlReader;
import com.xpyz.lotterdata.apis.ILotterDataBuilder;
import com.xpyz.lotterdata.models.LotterBean;

/**
 * 数据集合构建工具
 * 
 * @author Ajaxfan
 */
@Component
final class DataCollectionBuilder implements ILotterDataBuilder<LotterBean> {
	/** URL地址 */
	private URL url;
	/** HTML内容 */
	private String html;
	/** 数据集合 */
	private List<LotterBean> list;

	/**
	 * @param url
	 */
	public void createRemoteConnection(String str) {
		try {
			this.url = new URL(str);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 读取HTML内容
	 */
	public void readHtmlFromStream(IHtmlReader reader) {
		if (this.url != null) {
			this.html = reader.readHtmlContent(this.url);
		}
	}

	/**
	 * 读取数据集合
	 */
	public void buildJavaCollectionFromHtml(IHtmlConvertor<LotterBean> convert) {
		if (this.html != null) {
			this.list = convert.convert2JavaObject(this.html);
		}
	}

	/**
	 * @return
	 */
	public List<LotterBean> getLotterDatas() {
		return list;
	}
}

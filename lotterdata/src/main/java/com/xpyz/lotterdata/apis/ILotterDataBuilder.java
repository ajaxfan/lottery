package com.xpyz.lotterdata.apis;

import java.util.List;

/**
 * 开奖数据Java对象集合的创建
 * 
 * @author Ajaxfan
 */
public interface ILotterDataBuilder<T> {
    /**
     * 创建到远程服务器的连接
     */
    public void createRemoteConnection(String url);

    /**
     * 构建读取到的内容
     */
    public void readHtmlFromStream(IHtmlReader reader);

    /**
     * 构建数据集合
     */
    public void buildJavaCollectionFromHtml(IHtmlConvertor<T> convert);

    /**
     * @return 获得最终的数据集合
     */
    public List<T> getLotterDatas();
}

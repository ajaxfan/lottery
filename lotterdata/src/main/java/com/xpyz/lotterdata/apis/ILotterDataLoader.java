package com.xpyz.lotterdata.apis;

import java.util.List;

/**
 * 开奖数据同步接口
 * 
 * @author Ajaxfan
 */
public interface ILotterDataLoader<T> {
    /**
     * @param url
     *            要连接的远程地址
     * @return
     */
    public List<T> load(String url);
}

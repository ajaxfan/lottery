package com.xpyz.lotterdata.apis;

/**
 * 数据服务
 * 
 * @author Ajaxfan
 */
public interface ILotterDataService {
    /**
     * 从远程服务器将数据同步到本地
     * 
     * @param url
     */
    public void synchnizedRemoteDataToLocal(String url);
}

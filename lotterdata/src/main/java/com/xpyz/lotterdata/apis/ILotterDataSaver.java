package com.xpyz.lotterdata.apis;

import java.util.List;

/**
 * 保存开奖信息
 * 
 * @author Ajaxfan
 */
public interface ILotterDataSaver<T> {
    /**
     * 数据写入到本地数据库
     * 
     * @param records
     */
    public void writeData2db(List<T> records);
}

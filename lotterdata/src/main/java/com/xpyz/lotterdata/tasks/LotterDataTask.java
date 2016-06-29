package com.xpyz.lotterdata.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.ILotterDataService;

@Component
final class LotterDataTask {
    /** 远程数据服务地址 */
    private @Value("${remote.url}") String url;

    /** 数据同步服务 */
    private @Autowired ILotterDataService lotterDataService;

    /**
     * 每分钟执行一次数据同步
     */
    @Scheduled(fixedRate = 1 * 60 * 1000)
    public void pullDataFromStream() {
        lotterDataService.synchnizedRemoteDataToLocal(url);
    }
}

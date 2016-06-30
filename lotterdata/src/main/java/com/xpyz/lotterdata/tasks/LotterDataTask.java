package com.xpyz.lotterdata.tasks;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.xpyz.lotterdata.apis.ILotterDataService;

@Component
final class LotterDataTask {
    /** 远程服务器的地址 */
    private @Value("${remote.url}") String url;
    /** 要检查的连续数据量 */
    private @Value("${data.continulity.count}") int continulityCount;
    /** 每页的数据量 */
    private @Value("${data.continulity.everypage.count}") int everypageCount;

    /** 数据同步服务 */
    private @Autowired ILotterDataService lotterDataService;

    /**
     * 每分钟执行一次数据同步
     */
    @Scheduled(fixedRate = 1 * 60 * 1000)
    public void pullDataFromStream() {
        lotterDataService.synchnizedRemoteDataToLocal(MessageFormat.format(url, 1));
    }

    /**
     * 后台常驻线程，系统启动后一分钟运行一次。之后每隔一个小时运行一次
     */
    @Scheduled(initialDelay = 1 * 60 * 1000, fixedRate = 1 * 60 * 60 * 1000)
    public void corretDataset() {
        // 如果数据不连续，则需要重新来去定量的数据，以补齐数据集
        if (!lotterDataService.isDataContinulity()) {
            // 从第二页开始补数据，因为第一页的数据由主线程负责F
            for (int i = 2; i <= Math.round(continulityCount / everypageCount); i++) {
                lotterDataService.synchnizedRemoteDataToLocal(MessageFormat.format(url, i));
            }
        }
    }
}

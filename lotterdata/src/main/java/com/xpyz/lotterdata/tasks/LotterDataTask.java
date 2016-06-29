package com.xpyz.lotterdata.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("lotterDataTask")
public class LotterDataTask {

	/**
	 * 从服务器拉去数据，每30秒执行一次
	 */
	@Scheduled(cron = "0/3 * * * * ?")
	public void pullDataFromStream() {
		System.out.println("123");
	}
}

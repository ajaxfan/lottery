package com.xpyz.lotterdata;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xpyz.lotterdata.apis.ILotterDataDao;
import com.xpyz.lotterdata.models.LotterBean;

public class DaoTest {
	@Test
	public void test() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
		ILotterDataDao<LotterBean> dao = (ILotterDataDao<LotterBean>) context.getBean("lotterDataDao");

		try {
            System.out.println(dao.getRecordByCount(30).size());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		context.close();
	}
}

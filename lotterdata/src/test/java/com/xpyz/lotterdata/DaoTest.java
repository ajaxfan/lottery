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

		LotterBean bean = new LotterBean();
		bean.setLotterNo("wrwer");
		bean.setLotterResult("2938792374");
		bean.setLotterDate("234-234-2342");

		dao.writeData2db(Arrays.asList(new LotterBean[] { bean }));

		context.close();
	}
}

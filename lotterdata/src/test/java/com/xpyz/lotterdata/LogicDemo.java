package com.xpyz.lotterdata;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LogicDemo {
	@Test
	public void logicTest() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:spring-*.xml");
		// IUserLoginLogService dao = (IUserLoginLogService)
		// context.getBean("userLoginLogService");

		context.close();
	}
}

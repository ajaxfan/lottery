package com.xpyz.lotterdata;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegularDemo {
	@Test
	public void test() {
		String str = "<tr><td>561902</td><td>02,08,07,01,06,05,09,04,10,03</td><td>2016-06-2911:57</td></tr>";
		Pattern pattern = Pattern.compile("<td>([\\d\\W])+</td>");
		Matcher matcher = pattern.matcher(str);
		
		

	}
}

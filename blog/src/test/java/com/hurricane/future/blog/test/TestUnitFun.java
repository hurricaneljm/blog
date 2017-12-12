package com.hurricane.future.blog.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class TestUnitFun {


	@Test
	public void testRegexp() {
		String str = "8201248";
		String pattern = "[0-9-()（）]{7,18}";

		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(str);
		System.out.println(m.matches());
	}
}

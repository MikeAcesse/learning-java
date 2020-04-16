package com.itranswarp.learnjava;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/16 14:27
 */
public class StringTest {


    @Test
	public void testString(){

		String a="123";

		System.out.println(a);
		a="456";
		System.out.println(a);

	}
	@Test
	public void testDate(){
    	Date date = new Date();
		System.out.println(date.getYear()+1900);
		System.out.println(date.getYear());
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		System.out.println(date.getDay());
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
	}

	@Test
	public void testDate2(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	@Test
	public void testDate3(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd,yyyy");
		System.out.println(sdf.format(date));
	}
}

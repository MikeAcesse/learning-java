package com.itranswarp.learnjava;

import org.junit.Test;

import java.util.Calendar;
import java.util.Locale;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/17 10:15
 */
public class TestDateTime {
	@Test
	public void testCalendar(){
		Calendar c =Calendar.getInstance();
		int y = c.get(Calendar.YEAR);
		System.out.println("y="+y);
		int m= c.get(Calendar.MONTH);
		System.out.println("m="+(m+1));
		int d=c.get(Calendar.DAY_OF_MONTH);
		System.out.println("d="+d);
		int w=c.get(Calendar.DAY_OF_WEEK);
		System.out.println("w="+w);
		int hh=c.get(Calendar.HOUR);
		System.out.println("hh="+hh);
		int hh24=c.get(Calendar.HOUR_OF_DAY);
		System.out.println("hh24="+hh24);
		int ss = c.get(Calendar.SECOND);
		int ms = c.get(Calendar.MILLISECOND);
		int mm = c.get(Calendar.MINUTE);
		System.out.println(y + "-" + m + "-" + d + " " + w + " " + hh + ":" + mm + ":" + ss + "." + ms);
	}

	public void testSetCalendar(){

	}
}

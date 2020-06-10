package com.itranswarp.time;

import org.junit.Test;
import org.openqa.grid.common.JSONConfigurationUtils;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/8 16:26
 */
public class TestTime {

	@Test
	public void testInstant(){
		Instant now = Instant.now();
		System.out.println(now.getEpochSecond()); //秒
		System.out.println(now.toEpochMilli()); //毫秒

		Instant ins = Instant.ofEpochSecond(1591604951);
		System.out.println(ins);
		ZonedDateTime zdt = ins.atZone(ZoneId.systemDefault());
		System.out.println(zdt);
	}
	@Test
	public void testConvertToOldApi(){
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println(zdt);
		long ts =zdt.toEpochSecond()*1000;
		System.out.println(ts);
		Date date = new Date(ts);
		System.out.println(date);
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar);
		calendar.clear();
		System.out.println(calendar);
		calendar.setTimeZone(TimeZone.getTimeZone(zdt.getZone().getId()));
		System.out.println("\n"+calendar);
		calendar.setTimeInMillis(zdt.toEpochSecond()*1000);
		System.out.println("\n"+calendar);
	}


	@Test
	public void test2(){
		long ts = 1574208900000L;
		System.out.println(timestampToString(ts,Locale.CHINA,"Asia/Shanghai"));
		System.out.println(timestampToString(ts,Locale.US,"America/New_York"));

	}
	static String timestampToString(long epochMilli, Locale lo, String zoneId) {
		Instant ins = Instant.ofEpochMilli(epochMilli);
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		return f.withLocale(lo).format(ZonedDateTime.ofInstant(ins, ZoneId.of(zoneId)));
	}



}

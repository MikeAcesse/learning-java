package com.imooc.time;

import info2soft.qa.common.util.StringUtil;
import info2soft.qa.common.util.WaitUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/5 11:17
 */
public class TimeUtil {
	public static final int DAY_SECONDS = 24 * 60 * 60;
	public static final int HOUR_SECONDS = 60 * 60;
	public static final int MINUTE_SECONDS = 60;
	public static final int MILISECONDS_PER_SECOND = 1000;
	public enum TimeZoneAbbr {
		GMT("GMT"), PDT("America/Los_Angeles"), PST("America/Los_Angeles");
		final String strWithJavaFormat;
		private TimeZoneAbbr(String strWithJavaFormat) {
			this.strWithJavaFormat = strWithJavaFormat;
		}
		public String getStrWithJavaFormat() {
			return strWithJavaFormat;
		}
	}
	public static TimeZone timeZoneBeijing() {
		return TimeZone.getTimeZone("Asia/Shanghai");
	}
	public static TimeZone timeZoneChinaMainland() {
		return timeZoneBeijing();
	}
	/**
	 * return a human friendly string for a time span in unit second
	 *
	 * @param seconds
	 * @return
	 */
	public static String toStringSpan(long seconds) {
		return toStringSpan((int) seconds);
	}
	/**
	 * append a time stamp string to name
	 *
	 * @param name
	 * @return
	 */
	public static String parameterize(String name) {
		String newName = name + getTime();
		final int DELAY_MS = 3;
		WaitUtil.Sleep(DELAY_MS);
		return newName;
	}
	private static final String _SECONDS = " seconds";
	private static final String _SECOND = " second";
	/**
	 * return a human friendly string for a time span in unit milisecond
	 *
	 * @param miliseconds
	 * @return
	 */
	public static String toStringSpanMS(long miliseconds) {
		int seconds = (int) (miliseconds / MILISECONDS_PER_SECOND);
		int mili = (int) (miliseconds % MILISECONDS_PER_SECOND);
		String ss = toStringSpan((int) seconds);
		if (mili == 0)
			return ss;
		else {
			if (ss.endsWith(_SECONDS)) {
				String prefix = ss.substring(0, ss.length() - _SECONDS.length());
				String miliPart = String.format(".%03d", mili);
				return prefix + miliPart + _SECONDS;
			} else if (ss.endsWith(_SECOND)) {
				String prefix = ss.substring(0, ss.length() - _SECOND.length());
				String miliPart = String.format(".%03d", mili);
				return prefix + miliPart + _SECONDS;
			} else {
				ss += " " + mili + " ms";
				ss = ss.trim();
				return ss;
			}
		}
	}
	/**
	 * return a human friendly string for a time span in unit second
	 *
	 * @param seconds
	 * @return
	 */
	public static String toStringSpan(int seconds) {
		if (seconds == 0)
			return "0" + _SECOND;
		int day = seconds / DAY_SECONDS;
		int s_day = seconds % DAY_SECONDS;
		int hour = s_day / HOUR_SECONDS;
		int s_hour = s_day % HOUR_SECONDS;
		int minute = s_hour / MINUTE_SECONDS;
		int s_minute = s_hour % MINUTE_SECONDS;
		StringBuilder sb = new StringBuilder();
		if (day > 1)
			sb.append(day + " days");
		else if (day > 0)
			sb.append(day + " day");
		if (hour > 1)
			sb.append(" " + hour + " hours");
		else if (hour > 0)
			sb.append(" " + hour + " hour");
		if (minute > 1)
			sb.append(" " + minute + " minutes");
		else if (minute > 0)
			sb.append(" " + minute + " minute");
		if (s_minute > 1)
			sb.append(" " + s_minute + _SECONDS);
		else if (s_minute > 0)
			sb.append(" " + s_minute + _SECOND);
		String r = sb.toString();
		r = r.trim();
		return r;
	}
	/**
	 * Get time and convert it to specific format
	 *
	 * @return time in format MMddHHmmss
	 */
	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");
		return sdf.format(new java.util.Date());
	}
	public static String currentDateTime(String format) {
		final String actualFormat = StringUtil.isEmpty(format) ? "yyyy-MM-dd HH:mm:ss.SSS" : format;
		SimpleDateFormat sdf = new SimpleDateFormat(actualFormat);
		return sdf.format(new java.util.Date());
	}
	public static String currentDateTime() {
		final String DEFAULT_DATE_FORMAT = null;
		return currentDateTime(DEFAULT_DATE_FORMAT);
	}
	public static String getTimeMMddyyyy() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(new java.util.Date());
	}
	public static String getTomorrowTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
		// sdf.setTimeZone(TimeZone.getTimeZone("PST8PDT"));
		long time = 1000 * 60 * 60 * 24 + System.currentTimeMillis();
		return sdf.format(new java.util.Date(time));
	}
	public static long currentTimeSeconds() {
		return System.currentTimeMillis() / 1000;
	}
	public static long currentTimeMiliseconds() {
		return System.currentTimeMillis();
	}
	/**
	 * Get the current time with the specific timezone and format
	 *
	 * @param timezone
	 * @param format
	 * @return
	 */
	public static String getCurrentTime(String timezone, String format) {
		return getCurrentTime(timezone, format, 0);
	}
	/**
	 * Get the time which is current time plus postponed seconds with the
	 * specific timezone and format
	 *
	 * @param timezone
	 * @param format
	 * @param sTimeToPostpone
	 *            Seconds to be postponed according to the current time
	 * @return
	 */
	public static String getCurrentTime(String timezone, String format, int sTimeToPostpone) {
		Date date = new Date(System.currentTimeMillis() + sTimeToPostpone * 1000);
		return formatDateWithTimezone(date, timezone, format);
	}
	/**
	 * Format the given timestamp with the specific timezone and format
	 *
	 * @param timestamp
	 * @param timezone
	 * @param format
	 * @return
	 */
	public static String getFormatedTime(long timestamp, String timezone, String format) {
		Date date = new Date(timestamp);
		return formatDateWithTimezone(date, timezone, format);
	}
	/**
	 * Change the specific time from the default timezone to another timezone
	 *
	 * @param inputTime
	 * @param inputTimeTimezone
	 * @param inputTimeFormat
	 * @param outputTimeTimezone
	 * @param outputTimeFormat
	 * @return the time in the new timezone with format as
	 *         "EEE MMM d HH:mm:ss yyyy Z"
	 */
	private static String transformTimeStringToDifferentTimezone(String inputTime, String inputTimeTimezone, String inputTimeFormat,
	                                                             String outputTimeTimezone, String outputTimeFormat) {
		Date date = parseDateStringWithTimezone(inputTime, inputTimeTimezone, inputTimeFormat);
		String outputTime = formatDateWithTimezone(date, outputTimeTimezone, outputTimeFormat);
		return outputTime;
	}
	/**
	 * Format Date with the specific Timezone
	 *
	 * @param date
	 * @param strTimezone
	 * @param strTimeFormat
	 * @return Date as String with the specific format
	 */
	public static String formatDateWithTimezone(Date date, String strTimezone, String strTimeFormat) {
		SimpleDateFormat format = getDateFormat(strTimezone, strTimeFormat);
		return format.format(date);
	}
	public static String simpleFormatDate(String time, String inputFormat, String outputFormat) {
		return transformTimeStringToDifferentTimezone(time, null, inputFormat, null, outputFormat);
	}
	public static String simpleFormatDate(String time, String inputTimzone, String inputFormat, String outputFormat) {
		return transformTimeStringToDifferentTimezone(time, inputTimzone, inputFormat, inputTimzone, outputFormat);
	}
	/**
	 * Format input time with the specific timezone
	 *
	 * @param inputDate
	 * @param strTimezone
	 * @param strTimeFormat
	 * @return Date
	 */
	private static Date parseDateStringWithTimezone(String inputDate, String strTimezone, String strTimeFormat) {
		SimpleDateFormat format = getDateFormat(strTimezone, strTimeFormat);
		Date date = null;
		try {
			date = format.parse(inputDate);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage());
		}
		return date;
	}
	/**
	 * Get format by specifying timezone and format type
	 *
	 * @param strTimezone
	 * @param strTimeFormat
	 * @return SimpleDateFormat
	 */
	public static SimpleDateFormat getDateFormat(String strTimezone, String strTimeFormat) {
		SimpleDateFormat format = new SimpleDateFormat(strTimeFormat, Locale.US);
		if (strTimezone != null) {
			TimeZone timeZone = TimeZone.getTimeZone(strTimezone);
			format.setTimeZone(timeZone);
		}
		return format;
	}
	/**
	 * return format : 2013-03-07T02:38:55.000+0000
	 */
	public static String toUTCStringFromMS(long time_ms) {
		Date dt = new Date(time_ms);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		TimeZone tz = TimeZone.getTimeZone("UTC-0");
		df.setTimeZone(tz);
		String utc = df.format(dt);
		return utc;
	}
	public static String toUTCStringFromMS(long time_ms, String targetFormat) {
		Date dt = new Date(time_ms);
		DateFormat df = new SimpleDateFormat(targetFormat);
		TimeZone tz = TimeZone.getTimeZone("UTC-0");
		df.setTimeZone(tz);
		String utc = df.format(dt);
		return utc;
	}
	public static String toGMTStringFromMS(long time_ms) {
		Date dt = new Date(time_ms);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		TimeZone tz = TimeZone.getTimeZone("GMT-0");
		df.setTimeZone(tz);
		String utc = df.format(dt);
		return utc;
	}
	/**
	 * Get the timestamp of the specific time string
	 *
	 * @param strTime
	 * @return
	 */
	public static long getTimestamp(String strTime) {
		return StringUtil.toTimeMiliseconds(strTime);
	}
	public static void main(String[] args) {
		String time = "Dec 18, 2012 20:10:47 AM";
		String inputFormat = "MMM dd, yyyy hh:mm:ss aa";
		String outputFormat = "EEE MMM d HH:mm:ss yyyy z";
		System.out.println(getDaysBetween("18-JUN-2013 03:03AM", "18-JUL-2013 03:03AM"));
		/*
		 * System.out.println(TimeUtil.getFormatedTime(System.currentTimeMillis()
		 * , "PST", "MMM dd, yyyy hh:mm:ss aa z"));
		 */
		System.out.println(info2soft.qa.common.util.TimeUtil.simpleFormatDate(time, "PST", inputFormat, outputFormat));
		/*
		 * System.out.println(TimeUtil.getTimeChanged(time, "America/New_York",
		 * inputFormat, "CST", outputFormat));
		 * System.out.println(TimeUtil.getCurrentTime("PST",
		 * "MMM dd  yyyy hh:mm:ss aa"));
		 * System.out.println(TimeUtil.getCurrentTime("CST",
		 * "MMM dd  yyyy hh:mm:ss aa"));
		 * System.out.println(TimeUtil.getCurrentTime("Asia/Shanghai",
		 * "MMM dd  yyyy hh:mm:ss aa")); System.out.println(toStringSpan(30));
		 * System.out.println(toStringSpan(120));
		 * System.out.println(toStringSpan(24 * 60 * 60 + 120));
		 * System.out.println(toStringSpan(24 * 60 * 60 + 4 * 60 * 60 + 120 +
		 * 2)); System.out.println(toStringSpanMS((24 * 60 * 60 + 4 * 60 * 60 +
		 * 120 + 2) * 1000 + 2)); System.out.println(toStringSpanMS(2));
		 * System.out.println(toStringSpanMS(1002));
		 *
		 * System.out.println(getTomorrowTime());
		 */
		// testCSTShouldBeCentralStandardTime();
	}
	protected static void testCSTShouldBeCentralStandardTime() {
		// String strTime0 = "Mar 6, 2013 10:28:50 PM CST";
		String strTime0 = "Mar 7, 2013 10:38:55 AM CST";
		final long t0 = StringUtil.toTimeMiliseconds(strTime0);
		System.out.println("t0 : " + strTime0 + "  , " + t0);
		final String format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		final String expected = "2013-03-06T14:28:50.000+0000";
		String strTime1 = info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t0);
		final long t1 = StringUtil.toTimeMiliseconds(strTime1, format, Locale.US);
		System.out.println("t1 : " + strTime1 + " , " + t1);
		String strTime2 = info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t1);
		final long t2 = StringUtil.toTimeMiliseconds(strTime2, format, Locale.US);
		System.out.println("t2 : " + strTime2 + " , " + t2);
		if (!strTime1.equalsIgnoreCase(expected))
			throw new RuntimeException("actual is [" + strTime1 + "] and expected is [" + expected + "]");
		if (!strTime2.equalsIgnoreCase(expected))
			throw new RuntimeException("actual is [" + strTime1 + "] and expected is [" + expected + "]");
	}
	protected static void test1() {
		final long t1 = StringUtil.toTimeMiliseconds("Mar 5, 2013 02:32:29 PM PST");
		final long t2 = StringUtil.toTimeMiliseconds("Mar 5, 2013 03:32:29 PM PDT");
		final long t3 = StringUtil.toTimeMiliseconds("Mar 6, 2013 06:32:29 AM CST");
		String time = info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t1);
		System.out.println("UTC t1 : " + time);
		System.out.println("UTC t2 : " + info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t2));
		System.out.println("UTC t3 : " + info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t3));
		final String format = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		final long t4 = StringUtil.toTimeMiliseconds(time, format, Locale.US);
		System.out.println("UTC t4 : " + info2soft.qa.common.util.TimeUtil.toUTCStringFromMS(t4));
		System.out.println("t1 : " + t1);
		System.out.println("t2 : " + t2);
		System.out.println("t3 : " + t3);
		System.out.println("t4 : " + t4);
		System.out.println("UTC t4 : " + time);
		System.out.println("t1-t2 : " + (t1 - t2) / (60 * 60 * 1000));
		System.out.println("t1-t3 : " + (t1 - t3) / (60 * 60 * 1000));
		System.out.println("t1-t4 : " + (t1 - t4) / (60 * 60 * 1000));
	}
	public static int getDaysBetween(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mma");
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			long ms = end.getTime() - start.getTime();
			int ret = (int) (ms / (1000 * 60 * 60 * 24));
			return ret;
		} catch (Exception e) {
			throw new RuntimeException("Parse date error start=" + startDate + " endDate");
		}
	}

	public static int getHoursBetween(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy hh:mma");
		try {
			Date start = sdf.parse(startDate);
			Date end = sdf.parse(endDate);
			long ms = end.getTime() - start.getTime();
			int ret = (int) (ms / (1000 * 60 * 60));
			return ret;
		} catch (Exception e) {
			throw new RuntimeException("Parse date error start=" + startDate + " endDate");
		}
	}
}

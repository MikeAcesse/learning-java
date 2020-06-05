package com.imooc.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/5 10:23
 */
public class time4 {
	public static void main(String[] args) {
		LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
		System.out.println(firstDay);
		System.out.println(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(LocalDate.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.THURSDAY)));
	}
}

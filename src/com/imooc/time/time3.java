package com.imooc.time;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/5 10:12
 */
public class time3 {
	public static void main(String[] args) {
		LocalDateTime dt = LocalDateTime.of(2019,10,26,20,30,59);
		System.out.println(dt);
		LocalDateTime dt2= dt.plusDays(5).minusHours(3);
		System.out.println(dt2);
		LocalDateTime dt3= dt2.minusMonths(1);
		System.out.println(dt3);
		LocalDateTime dt4= dt3.plusMonths(1).withDayOfMonth(21);
		System.out.println(dt4);
		LocalDateTime dt5= dt4.withMonth(9);
		System.out.println(dt5);
	}
}

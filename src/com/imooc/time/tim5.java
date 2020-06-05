package com.imooc.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/5 10:29
 */
public class tim5 {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime target = LocalDateTime.of(2019,11,19,8,15,0);
		System.out.println(now.isBefore(target));
		System.out.println(now.isAfter(target));
		System.out.println(LocalDate.now().isBefore(LocalDate.of(2019,11,19)));
		System.out.println(LocalTime.now().isAfter(LocalTime.parse("08:15:00")));
	}
}

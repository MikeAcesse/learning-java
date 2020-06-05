package com.imooc.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/5 10:34
 */
public class time6 {
	public static void main(String[] args) {
		LocalDateTime start = LocalDateTime.of(2019,11,19,8,15,0);
		LocalDateTime end = LocalDateTime.of(2020,1,9,19,25,30);
		Duration d = Duration.between(start, end);
		System.out.println(d);

		Period p = LocalDate.of(2019,11,19).until(LocalDate.of(2020,1,9));
		System.out.println(p);

		System.out.println(Duration.ofHours(10));
		System.out.println(Duration.parse("P1DT2H3M"));
	}
}

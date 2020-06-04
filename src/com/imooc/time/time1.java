package com.imooc.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/4 16:10
 */
public class time1 {
	public static void main(String[] args) throws InterruptedException {
//		LocalDate d = LocalDate.now(); //当前日期
//		System.out.println(d);  //严格按照ISO 8601格式打印
//		Thread.sleep(1000);
//		LocalTime t = LocalTime.now(); //当前时间
//		System.out.println(t); //严格按照ISO 8601 格式打印
//		Thread.sleep(1000);
//		LocalDateTime dt= LocalDateTime.now(); //当前日期和时间
//		System.out.println(dt); //严格按照ISO 8601 格式打印

//        LocalDateTime dt2 = LocalDateTime.now();
//		System.out.println(dt2);
//        LocalDate d2 = dt2.toLocalDate();
//		System.out.println(d2);
//		Thread.sleep(1000);
//		LocalTime t2 = dt2.toLocalTime();
//		System.out.println(t2);
//
//		LocalDate d3= LocalDate.of(2019,11,30);
//		System.out.println(d3);
//		LocalTime t3= LocalTime.of(15,16,17);
//		System.out.println(t3);
//		LocalDateTime dt3 = LocalDateTime.of(2019,11,30,15,16,17);
//		System.out.println(dt3);
//		LocalDateTime dt33= LocalDateTime.of(d3,t3);
//		System.out.println(dt33);


		LocalDateTime dt =LocalDateTime.parse("2019-11-19T15:16:17");
		System.out.println(dt);
		LocalDate d5= LocalDate.parse("2019-11-19");
		System.out.println(d5);
		LocalTime t5= LocalTime.parse("15:16:17");
		System.out.println(t5);



	}
}

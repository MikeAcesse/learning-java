package com.imooc.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/4 19:20
 */
public class time2 {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		System.out.println(dtf.format(LocalDateTime.now()));

		LocalDateTime dt2= LocalDateTime.parse("2019/11/30 15:16:17",dtf);
		System.out.println(dt2);
	}
}

package com.itranswarp.dataStructs;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/23 14:49
 */
public class TestPerson {
	public static void main(String[] args) {
		Person p1= new Person("wangtao",23);
		System.out.println(p1.toString());
		Person p2= p1;
		System.out.println(p2.toString());
		p2.setAge(100);
		p2.setName("fanzhikang");
		System.out.println(p2.toString());
		System.out.println(p1.toString());
	}
}

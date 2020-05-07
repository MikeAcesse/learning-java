package com.itranswarp.dataStructs;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/23 14:48
 */
public class Person {
	String name;
	int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name: "+this.name+",age="+age;
	}
}

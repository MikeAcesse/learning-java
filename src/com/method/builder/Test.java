package com.method.builder;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:27
 */
public class Test {
	public static void main(String[] args) {
		PersonDirector pd = new PersonDirector();
		Person person = pd.constructPerson(new ManBuilder());
		System.out.println(person.getBody());
		System.out.println(person.getFoot());
		System.out.println(person.getHead());
	}

}

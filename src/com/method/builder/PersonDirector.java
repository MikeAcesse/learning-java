package com.method.builder;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:15
 */
public class PersonDirector {
	public Person constructPerson(PersonBuilder pb){
		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();
		return pb.buildPerson();

	}
}

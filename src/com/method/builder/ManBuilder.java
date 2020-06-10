package com.method.builder;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:18
 */
public class ManBuilder implements PersonBuilder {
	Person person;

	public ManBuilder() {
		this.person = new Man();
	}

	@Override
	public void buildHead() {
		person.setHead("建造男人的头");

	}

	@Override
	public void buildBody() {
       person.setBody("建造男人的身体");
	}

	@Override
	public void buildFoot() {
		person.setFoot("建造男人的脚");

	}

	@Override
	public Person buildPerson() {
		return person;
	}
}

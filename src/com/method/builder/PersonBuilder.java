package com.method.builder;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:12
 */
public interface PersonBuilder {
	void buildHead();
	void buildBody();
	void buildFoot();
	Person buildPerson();
}

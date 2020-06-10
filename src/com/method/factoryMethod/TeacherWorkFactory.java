package com.method.factoryMethod;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/10 9:13
 */
public class TeacherWorkFactory implements IWorkFactory {
	@Override
	public Work getWork() {
		return new TeacherWork();
	}
}

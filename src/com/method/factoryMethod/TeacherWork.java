package com.method.factoryMethod;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/10 9:11
 */
public class TeacherWork implements Work {
	@Override
	public void doWork() {
		System.out.println("老师审批作业！");
	}
}

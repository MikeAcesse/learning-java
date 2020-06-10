package com.method.factoryMethod;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/10 9:14
 */
public class Test {
	public static void main(String[] args) {
		IWorkFactory studentWorkFactory = new StudentWorkFactory();
		studentWorkFactory.getWork().doWork();

		IWorkFactory teacherWorkFactory = new TeacherWorkFactory();
		teacherWorkFactory.getWork().doWork();

	}
}

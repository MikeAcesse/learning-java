package com.imooc.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/7 17:25
 */
public class Main {
	public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		String name="Xiao ming";
		int age =20;
		Person p = new Person();
		Class clzz= p.getClass();
		Method m =clzz.getMethod("setName", String.class);
		m.invoke(p,name);
		Method m1= clzz.getMethod("setAge", int.class);
		m1.invoke(p,age);
		System.out.println(p.getName());
		System.out.println(p.getAge());

	}
}

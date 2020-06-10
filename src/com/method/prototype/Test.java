package com.method.prototype;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 17:59
 */
public class Test {
	public static void main(String[] args) {
		Prototype pro = new ConcretePrototype("prototype");
		Prototype pro2 = (Prototype) pro.clone();
		System.out.println(pro.getName());
		System.out.println(pro2.getName());

	}
}

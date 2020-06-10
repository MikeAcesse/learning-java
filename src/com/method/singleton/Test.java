package com.method.singleton;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:09
 */
public class Test {
	public static void main(String[] args) {
		Singleton sing = Singleton.getInstance();
		Singleton sing2= Singleton.getInstance();
		System.out.println(sing);
		System.out.println(sing2);
	}

}

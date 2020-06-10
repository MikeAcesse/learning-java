package com.method.singleton;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:05
 */
public class Singleton {
	private static Singleton sing;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if(sing == null){
			sing = new Singleton();
		}
		return sing;
	}
}

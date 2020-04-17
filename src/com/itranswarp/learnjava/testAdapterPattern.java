package com.itranswarp.learnjava;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/17 13:47
 */


public class testAdapterPattern {
	public static void main(String[] args) {
		Target target=new Adapter(new Adaptee());
		target.adapteeMethod();
		target.adapterMethod();

	}
}

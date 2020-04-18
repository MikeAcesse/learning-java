package com.itranswarp.learnjava;

import org.junit.Test;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/18 10:34
 */
public class TestBase {
	@Test
	public void test1(){
		int a=10;
		int b= 10 >> 2;
		System.out.println("b= "+b);
		int c=a<<2;
		System.out.println("c= "+c);
	}
}

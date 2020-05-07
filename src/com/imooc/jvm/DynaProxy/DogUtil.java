package com.imooc.jvm.DynaProxy;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/20 9:12
 */
public class DogUtil {
	// 第一个拦截器方法
	public  void method1(){
		System.out.println("=============模拟第一个通用方法===========");
	}
	// 第二个拦截器方法
	public  void method2(){
		System.out.println("=============模拟通用方法二===========");
	}
}

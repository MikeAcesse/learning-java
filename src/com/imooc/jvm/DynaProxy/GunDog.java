package com.imooc.jvm.DynaProxy;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/20 9:15
 */
public class GunDog implements Dog {
	// 实现info()方法，仅仅打印一个字符串
	@Override
	public void info() {
		System.out.println("我是一只猎狗");
	}

	@Override
	public void run() {
		System.out.println("我奔跑迅速");
	}
}

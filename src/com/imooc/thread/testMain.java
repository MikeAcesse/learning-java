package com.imooc.thread;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 16:28
 */
public class testMain {
	public static void main(String[] args) {
			log("start main ...");
			new Thread(()->{
				log("run task...");
			}).start();
			new Thread(()->{
				log("print ...");
			}).start();
			log("end main.");
	}
	static void log(String s){
		System.out.println(Thread.currentThread().getName()+" : "+s);
	}


}

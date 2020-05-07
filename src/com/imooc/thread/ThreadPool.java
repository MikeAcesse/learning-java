package com.imooc.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 21:17
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 6; i++) {
			es.submit(new Task4(""+i));
		}
		es.shutdown();
	}
}
class Task4 implements Runnable{
	private final String name;
	public Task4(String name){
		this.name=name;
	}

	@Override
	public void run() {
		System.out.println("start task "+name);
		try{
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end task "+name);
	}
}

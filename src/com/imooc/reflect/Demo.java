package com.imooc.reflect;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 9:57
 */
public class Demo <T extends  Animal> {
	private T obj;

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Demo(T obj){
		//super();
		this.obj=obj;
		System.out.println("this is Dmeo constructor");
	}
	public void print(){
		System.out.println("T 的类型是： "+obj.getClass().getName());
	}
	public void print1(){
		System.out.println("T 的类型是： "+obj.getClass().getName());
	}
}

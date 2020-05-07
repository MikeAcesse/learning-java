package com.imooc.jvm;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/21 15:15
 */
public class ProxyTest {
	public static void main(String[] args) {
		// 创建一个InvocationHandler对象
		InvocationHandler handler = new MyInvokationHandler();
		// 使用指定的InvocationHandler来生成一个动态代理对象
		Person p = (Person) Proxy.newProxyInstance(Person.class.getClassLoader()
				, new Class[]{Person.class}, handler);
		// 调用动态代理对象的walk()和sayHello()方法
		p.walk();
		p.sayHello("孙悟空");
	}
}

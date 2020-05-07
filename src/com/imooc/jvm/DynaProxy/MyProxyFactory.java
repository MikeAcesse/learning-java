package com.imooc.jvm.DynaProxy;

import java.lang.reflect.Proxy;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/20 9:22
 */
public class MyProxyFactory {
	public static Object getProxy(Object target){
		// 创建一个MyInvokationHandler对象
		MyInvocationHandler handler = new MyInvocationHandler();
		// 为MyInvokationHandler设置target对象
		handler.setTarget(target);
		//创建并返回一个动态代理对象
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);

	}
}

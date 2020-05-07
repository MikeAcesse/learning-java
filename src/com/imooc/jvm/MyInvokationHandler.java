package com.imooc.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 22:19
 */
public class MyInvokationHandler implements InvocationHandler {
   //执行动态代理对象的所有方法时，都会被替换成执行如下的invoke 方法
	//proxy, 代表动态代理对象
	// method :代表正在执行的方法
	// args:代表调用目标方法时传入的实参、
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("-------正在执行的方法："+method);
		if(args !=null){
			System.out.println("下面是执行方法时传入的实参为： ");
			for (Object val :args){
				System.out.println(val);
			}

		}else{
			System.out.println("该方法没有实参");
		}
		return null;
	}
}

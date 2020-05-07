package com.imooc.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 22:05
 */
public class GenericTest {
	private Map<String,Integer> score;

	public static void main(String[] args) throws NoSuchFieldException {
		Class<GenericTest> clazz= GenericTest.class;
		Field f = clazz.getDeclaredField("score");
		Class<?> a =f.getType();
		System.out.println("score的类型是： "+a);
		//获取成员变量f的泛型类型
		Type gType = f.getGenericType();
		System.out.println("gType="+gType);
		//如果gType类型是ParameterizedType对象
		if(gType instanceof ParameterizedType){
			ParameterizedType pType=(ParameterizedType)gType;
			//获取原始leixing
			Type rType= pType.getRawType();
			System.out.println("原始类型是： "+rType);
			Type[] tArgs=pType.getActualTypeArguments();
			System.out.println(tArgs);
			for (int i = 0; i <tArgs.length ; i++) {
				System.out.println("第" + i + "个泛型类型是：" + tArgs[i]);
			}
		}else{
			System.out.println("获取泛型类型出错！");
		}

	}
}

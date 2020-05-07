package com.imooc.jvm;

import java.util.Date;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 22:01
 */
public class CrazyitObjectFactory2 {
	public static <T> T getInstance(Class<T> cls){
		try{
			return cls.newInstance();
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		Date d= CrazyitObjectFactory2.getInstance(Date.class);
	}

}

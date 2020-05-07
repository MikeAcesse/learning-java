package com.imooc.jvm;

import java.lang.reflect.Array;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/19 21:44
 */
public class CrazyitArray {
	public static <T> T[] newInstance(Class<T> componetType,int length){
		return (T[]) Array.newInstance(componetType,length);
	}

	public static void main(String[] args) {
		String[] arr = CrazyitArray.newInstance(String.class,10);
		int[][] intArr =CrazyitArray.newInstance(int[].class,5);
		arr[5]="疯狂Java讲义";
		intArr[1]=new int[]{23,12};
		System.out.println(arr[5]);
		System.out.println(intArr[1][0]);
	}
}

package com.imooc.jvm.chapter18;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/21 16:44
 */
public class exercise3 {
	public static void main(String[] args) {
		int max=1;
		int min=1;
		int array[][]={{2,3,1},{6,7,8},{8,7,9}};
		for (int i = 0; i <array.length ; i++) {
			Arrays.sort(array[i]);
			max=Math.max(max,array[i][2]);
			min=Math.min(min,array[i][0]);
		}
		System.out.println("最大值="+max);
		System.out.println("最小值="+min);
		for (int i = 0; i <array.length ; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print("array["+i+"]["+j+"]="+array[i][j]+",");
				if(j % 3==0){
					System.out.println();
				}
			}

		}
	}
}

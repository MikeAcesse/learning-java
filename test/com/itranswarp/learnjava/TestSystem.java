package com.itranswarp.learnjava;

import org.junit.Test;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/24 16:17
 */
public class TestSystem {
	@Test
	public void testArrayCopy(){
		String[] src = new String[]{"hello", "huang", "bao", "kang"};
		String[] dest=new String[5];
		System.arraycopy(src,0,dest,0,3);
		for (String str:dest
		     ) {
			System.out.println(str);
		}

		System.out.println("=========华丽的分割线=========");
		System.arraycopy(src, 0, src, 1, 2);
		for (String str : src) {
			System.out.println(str);
		}
	}
}

package com.itranswarp.learnjava;


import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/16 14:27
 */
public class StringTest {


    @Test
	public void testString(){

		String a="123";

		System.out.println(a);
		a="456";
		System.out.println(a);

	}
	@Test
	public void testDate(){
    	Date date = new Date();
		System.out.println(date.getYear()+1900);
		System.out.println(date.getYear());
		System.out.println(date.getMonth()+1);
		System.out.println(date.getDate());
		System.out.println(date.getDay());
		System.out.println(date.toString());
		System.out.println(date.toGMTString());
		System.out.println(date.toLocaleString());
	}

	@Test
	public void testDate2(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd--HH:mm:ss");
		System.out.println(sdf.format(date));
	}
	@Test
	public void testDate3(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd,yyyy");
		System.out.println(sdf.format(date));
	}
	@Test
	public void testString4(){
    	String str="剩余空间: 49.82 GB, 99.68%";
    	String stra="已用容量: 164.1 MB, 0.32%";
		String str1=parseMemoryInfo(stra);
		Double strDou=transformDiskUnitToByte(str1);
		System.out.println(strDou);

	}

	@Test
	public void test5(){
    	String express="[(GB)|G|(MB)|M]";
    	String a="49.82GB";
    	String b="52.43G 43.4GB 56MB 78M";
    	String[] aa = a.split("[(GB)|G|(MB)|M]");
		System.out.println(aa);
		String[] bb=b.split(express);
		System.out.println(bb);
	}

	public double transformDiskUnitToByte(String diskSize){
		double result=0;
		if(diskSize.contains("G")){
			result=Double.parseDouble(diskSize.substring(0,diskSize.length()-1))*1024*1024*1024;
		}else if(diskSize.contains("M")){
			result=Double.parseDouble(diskSize.substring(0,diskSize.length()-1))*1024*1024;
		}
		return  result;
	}
	public String parseMemoryInfo(String parseMemoryInfo){
		String expression="[(\\s+)|(,\\s+)]";
		String[] remainingSpaceArray= parseMemoryInfo.split(expression);
		return remainingSpaceArray[1]+remainingSpaceArray[2].substring(0,remainingSpaceArray[2].trim().length()-1);
	}
	@Test
	public void testLastIndexOf(){
    	String str="kfankzhikangkbaba";
    	int a=str.lastIndexOf('k');
		System.out.println("a= "+a);
		int b=str.indexOf("a",7);
		System.out.println("b="+b);
	}
	@Test
	public void testIndexOf(){
		String str="kfankzhikangkbaba";
		int a=str.indexOf('k');
		System.out.println("a= "+a);

		int b=str.indexOf('a',7);
		System.out.println("b= "+b);

		char c= str.charAt(3);
		System.out.println("c= "+c);

		int d =str.codePointAt(2);
		System.out.println("d= "+d);

	}
	@Test
	public void testValueOf(){
    	boolean a =false;
    	String aa =String.valueOf(a);
		System.out.println("aa= "+aa);

		int b=56;
		String bb=String.valueOf(b);
		System.out.println("bb= "+bb);
		System.out.println(bb.intern());

		System.out.println();


	}
}

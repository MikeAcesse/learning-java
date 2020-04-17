package com.itranswarp.learnjava;

import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/16 17:14
 */
public class TestIO {
	@Test
	public void testPrintWriter(){
		StringWriter buffer = new StringWriter();
		PrintWriter pw = new PrintWriter(buffer);
		pw.println("Hello");
		pw.println(12345);
		pw.println(true);
		System.out.println(buffer.toString());
	}
	@Test
	public void testPrintStream(){
		System.out.println("fanzhikang");
		System.out.println("mikefan");
	}

}

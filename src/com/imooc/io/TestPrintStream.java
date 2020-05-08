package com.imooc.io;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 10:59
 */
public class TestPrintStream {

	public static void main(String[] args) {
		StringWriter buffer = new StringWriter();
		try(PrintWriter pw = new PrintWriter(buffer)){
			pw.println("hello");
			pw.println(12345);
			pw.println(true);
		}
		System.out.println(buffer.toString());
	}

}

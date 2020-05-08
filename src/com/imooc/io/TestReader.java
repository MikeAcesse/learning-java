package com.imooc.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 14:34
 */
public class TestReader {
	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("src/readme.txt");
		for (;;){
			int n = reader.read();
			if(n==-1){
				break;
			}
			System.out.print((char)n);
		}
		reader.close();
//		try (Reader reader1 = new FileReader("src/readme.txt", StandardCharsets.UTF_8)) {
//			char[] buffer = new char[1000];
//			int n;
//			while ((n = reader.read(buffer)) != -1) {
//				System.out.println("read " + n + " chars.");
//			}
//		}
	}
}

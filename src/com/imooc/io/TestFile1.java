package com.imooc.io;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/21 13:58
 */
public class TestFile1 {
	public static void main(String[] args) {
		File f = new File("./src");
		File[] fs1 = f.listFiles(); // 列出所有文件和子目录
		prinFiles(fs1);
		File[] fs2= f.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".exe");
			}
		});
		prinFiles(fs2);
		System.out.println("========================");
		String[] fstr=f.list();
		for (String str: fstr
		     ) {
			System.out.println(str);
		}
	}
	static void prinFiles(File[] files){
		System.out.println("========================");
		if(files !=null){
			for (File f : files
			     ) {
				if(f.isDirectory()){
					File[] fs3 = f.listFiles(new FilenameFilter() {
						@Override
						public boolean accept(File dir, String name) {
							return name.endsWith(".txt");
						}
					});
					prinFiles(fs3);
				}
				System.out.println(f);
			}
		}
		System.out.println("========================");
	}
	@Test
	public void testio() throws IOException {
		File currentDir = new File(".");
		System.out.println(currentDir.getCanonicalFile());
		File[] fs = currentDir.listFiles();
		if (fs != null) {
			for (File f : fs) {
				System.out.println(f.getName());
			}
		}
	}
}

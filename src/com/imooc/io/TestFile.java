package com.imooc.io;

import java.io.File;
import java.io.IOException;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 15:09
 */
public class TestFile {
	public static void main(String[] args) throws IOException {
		File currentDir = new File(".");
		listDir(currentDir.getCanonicalFile());

	}
	static void listDir(File dir){
          //递归打印所有文件和子文件夹的内容
		File[] fs = dir.listFiles();
		if(fs !=null){
			for (File f: fs
			     ) {
				System.out.println(f.getName());

			}
			System.out.println("*********f.getAbsolutePath()*******************");
			for (File f : fs
			     ) {
				System.out.println(f.getAbsolutePath());
			}
			System.out.println("***********f.getPath()*****************");
			for (File f : fs
			) {
				System.out.println(f.getPath());
			}
		}
	}
}

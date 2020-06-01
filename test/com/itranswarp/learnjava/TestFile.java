package com.itranswarp.learnjava;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/21 14:31
 */
public class TestFile {
	@Test
	public void testMkdir(){
		File f = new File("D:\\kangkang");
		f.mkdir();
		System.out.println(f.getParent());
		File f1= new File(f,"zhi\\kang");
		f1.mkdirs();
		System.out.println(f1);
	}
	@Test
	public void testDelete(){
		File f =new File("D:\\kangkang\\zhi\\kang");
		f.delete();
	}
	@Test
	public void testMain(){
		File f1 = new File("C:\\Windows");
		File f2 = new File("C:\\Windows\\notepad.exe");
		File f3 = new File("C:\\Windows\\nothing");
		System.out.println(f1.isFile());
		System.out.println(f1.isDirectory());
		System.out.println(f2.isFile());
		System.out.println(f2.isDirectory());
		System.out.println(f3.isFile());
		System.out.println(f3.isDirectory());
		System.out.println(f2.length());
		System.out.println(f1.canExecute());
		System.out.println(f1.canRead());
		System.out.println(f1.canWrite());
	}
	@Test
	public void testCreateNewFile() throws IOException {
		File f = new File("D:\\kangkang\\zhi\\fa.log");
		if(f.createNewFile()){
			f.delete();
		}
		f = File.createTempFile("tmp-", ".txt"); // 提供临时文件的前缀和后缀
		f.deleteOnExit(); // JVM退出时自动删除
		System.out.println(f.isFile());
		System.out.println(f.getAbsolutePath());

	}

	@Test
	public void testPath(){
		Path p1 = Paths.get(".","src","com");  //构造一个Path 对象
		System.out.println(p1);
		Path p2 = p1.toAbsolutePath();
		System.out.println(p2);
		Path p3= p2.normalize();
		System.out.println(p3);
		File f = p3.toFile();
		System.out.println(f);
		for (Path p : Paths.get("..").toAbsolutePath()
		     ) {
			System.out.println(" "+p);
		}
	}
}

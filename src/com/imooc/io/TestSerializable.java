package com.imooc.io;

import java.io.*;
import java.util.Arrays;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 13:37
 */
public class TestSerializable {
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream buffer= new ByteArrayOutputStream();
		try(ObjectOutputStream output = new ObjectOutputStream(buffer)){
			output.writeInt(12345);
			output.writeUTF("Hello");
			output.writeObject(Double.valueOf(123.456));
		}
		System.out.println(Arrays.toString(buffer.toByteArray()));
		ByteArrayInputStream bufferin = new ByteArrayInputStream(buffer.toByteArray());
		try(ObjectInputStream in = new ObjectInputStream(bufferin)){
			int n = in.readInt();
			String s= in.readUTF();
			Double d = (Double) (in.readObject());
			System.out.println(n);
			System.out.println(s);
			System.out.println(d);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

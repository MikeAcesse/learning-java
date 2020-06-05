package com.excel;

import com.sun.corba.se.spi.ior.Writeable;
import jxl.Workbook;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/4 20:06
 */
public class JxlExpExcel {
	public static void main(String[] args) {
		String[] title ={"id","name","sex"};
		//创建Excel 文件
		File file = new File("e:/jxl_text.xls");
		try {
			file.createNewFile();
			//创建工作簿
			WritableWorkbook workbook = Workbook.createWorkbook(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

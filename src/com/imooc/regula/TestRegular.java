package com.imooc.regula;

import info2soft.qa.common.util.StringUtil;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/14 18:33
 */
public class TestRegular {
	public static void main(String[] args) {
		test2();
	}
	public static void test1(){
		Pattern p = Pattern.compile("(\\d+,)(\\d+)");
		String s = "123,456-34,345-123,789-432,111";
		Matcher m = p.matcher(s);
		int index=7;
		while(m.find())
		{
			System.out.println("m.group():"+m.group()); //打印一个大组
			System.out.println("m.group(1):"+m.group(1)); //打印组1
			System.out.println("m.group(2):"+m.group(2)); //打印组2
			System.out.println("m.group(0):"+m.group(0));
			System.out.println();
		}
		System.out.println("捕获个数:groupCount()="+m.groupCount());
	}
	public static void test2(){
		Pattern pattern = Pattern.compile("Java");
		System.out.println(pattern.pattern());
		System.out.println(pattern.flags());
	}

	public static void test3(){
		Pattern pattern = Pattern.compile("Java");
		System.out.println(pattern.pattern());
		System.out.println(pattern.flags());
	}

	@Test
	public  void test4(){
		String out="C:\\Program Files\\OpenSSH\\home\\Administrator>cd /d C:\\Program Files (x86)\\info2soft\\node\\etc & type regnode.conf\n" +
				"node_name = bm9kZTE=\n" +
				"node_uuid = CDA88199-A589-1A38-B9AF-6C64E78F3FB6\n" +
				"config_addr = 172.20.68.195\n" +
				"data_addr = 172.20.68.195\n" +
				"cc_uuid = 6C1EFF4C-6CCA-3E9F-93DB-43DA7BA0BF5F\n" +
				"cc_ip = 172.20.68.129\n" +
				"memlimit = 644\n" +
				"disklimit = 18402\n" +
				"disk_free_space_limit = 4096\n" +
				"logdir = C:\\Program Files (x86)\\info2soft\\node\\log\\\n" +
				"cachedir = C:\\Program Files (x86)\\info2soft\\node\\cache\\\n" +
				"cc_type = STD\n" +
				"proxy_switch = 0\n" +
				"lvrepsize = 1G\n" +
				"lvcdpsize = 1G\n" +
				"en_snap = 0\n" +
				"security_check = 0";
		String data_add = "data_addr\\s\\S\\s\\S+";
		String str=substringEqual(data_add,out);
		System.out.println(str);
	}

	public String substringEqual(String trueRule, String output) {
		Pattern P = Pattern.compile(trueRule);
		Matcher M = P.matcher(output);
		if (M.find()) {
			String s = M.group().trim();
			return s.substring(s.indexOf("=") + 1).trim();
		}
		return null;
	}


	@Test
	public void test5(){
		String s="DevMapper.txt \n" +
				"MonInfo.txt\n" +
				"SystemInfo.txt";

		Pattern p = Pattern.compile("(MonInfo)|(DevMapper)|(SystemInfo)");
		Matcher m = p.matcher(s);
		while(m.find())
		{
			System.out.println("m.group():"+m.group()); //打印一个大组
			System.out.println("m.group(1):"+m.group(1)); //打印组1
			System.out.println("m.group(2):"+m.group(2)); //打印组2
			System.out.println("m.group(3):"+m.group(3)); //打印组2
			System.out.println("m.group(0):"+m.group(0));
			System.out.println();
		}
		System.out.println("捕获个数:groupCount()="+m.groupCount());
	}
}

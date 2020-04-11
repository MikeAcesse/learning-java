package com.itranswarp.learnjava;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/11 16:06
 */
public class TemplateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void render() {
		Template t = new Template("Hello, ${name}! You are learning ${lang}!");
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Bob");
		data.put("lang", "Java");
		assertEquals("Hello, Bob! You are learning Java!",t.render(data));

	}

	@Test
	public void render2() {
		Template t = new Template("Hello, ${name}! You are learning ${lang}!");
		Map<String, Object> data = new HashMap<>();
		data.put("name", "Bob");
		data.put("lang", "Java");
		assertEquals("Hello, Bob! You are learning Java!",t.render2(data));
	}
}
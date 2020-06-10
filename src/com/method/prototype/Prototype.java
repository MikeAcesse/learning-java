package com.method.prototype;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 17:53
 */
public class Prototype implements Cloneable {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() {
		try {
			return super.clone();

		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}

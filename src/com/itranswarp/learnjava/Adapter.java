package com.itranswarp.learnjava;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/4/17 13:59
 */
public class Adapter implements Target{
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee){
		this.adaptee=adaptee;
	}

	@Override
	public void adapteeMethod() {
		adaptee.adapteeMethod();
	}

	@Override
	public void adapterMethod(){
		System.out.println("Adapter method! ");
	}
}

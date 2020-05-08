package com.imooc.reflect;


/**
 * @author fanzk
 * @version 1.8
 * @date 2020/5/8 10:03
 */
public class Test {
	private static void take(Demo<?> a){
		a.print();
	}

	public static void main(String[] args) {
		Demo<Dog> dog= new Demo<Dog>(new Dog());
		take(dog);
		Demo<Cat> cat = new Demo<Cat>(new Cat());
		take(cat);
		Demo<Animal> animal= new Demo(new Animal());
		take(animal);
	}
}

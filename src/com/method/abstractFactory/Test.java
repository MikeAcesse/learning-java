package com.method.abstractFactory;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:52
 */
public class Test {
	public static void main(String[] args) {
		IAnimalFactory blackAnimalFactory = new BlackAnimalFactory();
		ICat blackCat = blackAnimalFactory.createCat();
		blackCat.eat();

		IDog blackDog = blackAnimalFactory.createDog();
		blackDog.eat();

		IAnimalFactory whiteAnimalFactory = new WhiteAnimalFactory();
		ICat whiteCat = whiteAnimalFactory.createCat();
		whiteCat.eat();
		IDog whiteDog = whiteAnimalFactory.createDog();
		whiteDog.eat();

	}
}

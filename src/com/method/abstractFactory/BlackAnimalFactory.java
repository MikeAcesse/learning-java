package com.method.abstractFactory;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:48
 */
public class BlackAnimalFactory implements IAnimalFactory {
	@Override
	public ICat createCat() {
		return new BlackCat();
	}

	@Override
	public IDog createDog() {
		return new BlackDog();
	}
}

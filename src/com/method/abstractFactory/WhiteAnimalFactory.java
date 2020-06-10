package com.method.abstractFactory;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:50
 */
public class WhiteAnimalFactory implements IAnimalFactory {
	@Override
	public ICat createCat() {
		return new WhiteCat();
	}

	@Override
	public IDog createDog() {
		return new WhiteDog();
	}
}

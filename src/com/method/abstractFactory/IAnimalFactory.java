package com.method.abstractFactory;

/**
 * @author fanzk
 * @version 1.8
 * @date 2020/6/9 18:36
 */
public interface IAnimalFactory {
	ICat createCat();
	IDog createDog();
}

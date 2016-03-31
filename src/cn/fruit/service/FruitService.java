package cn.fruit.service;

import java.util.List;

import cn.fruit.domain.Fruit;

public interface FruitService {
	
	/**
	 * get the top N fruit info from db
	 * @param num
	 * @return
	 */
	public List<Fruit> getTopN(int num);
	
	/**
	 * add the fruit info to db
	 * @param form
	 */
	public void addFruit(Fruit form);

}

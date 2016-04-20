package cn.fruit.dao;

import cn.fruit.domain.Fruit;

public interface FruitDao extends BaseDao<Fruit> {
	
	/**
	 * get the number of record
	 * @return
	 */
	public int getNumbers(String sql);

}

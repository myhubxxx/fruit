package cn.test.service;

import java.util.List;

import org.junit.Test;

import cn.fruit.domain.Fruit;
import cn.fruit.service.FruitService;
import cn.fruit.service.impl.FruitServiceImpl;

public class FruitServiceTest {
	
	FruitService service = new FruitServiceImpl();
	@Test
	public void getTopNTest(){
		
		List<Fruit> fruits =  service.getTopN(5);
		for (Fruit fruit : fruits) {
			System.out.println(fruit);
		}
	}

}

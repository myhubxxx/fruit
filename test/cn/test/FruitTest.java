package cn.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.CommonUtils;
import cn.fruit.dao.FruitDao;
import cn.fruit.dao.impl.FruitDaoImpl;
import cn.fruit.domain.Fruit;
import cn.fruit.domain.User;

public class FruitTest {
	
	FruitDao dao = new FruitDaoImpl();
	
	@Test
	public void insertTest() throws SQLException{
		for (int i = 0; i < 20; i++) {
			
		Fruit f = new Fruit();
			f.setFid(CommonUtils.uuid());
			f.setFname("香蕉");
			f.setFprice(1.2);
			f.setFamount(2000);
			f.setFpicture("C:\\temp.jpg");
			f.setFdate(new Date());
			f.setPlace("西南石油");
			
//			f.setProduceaddress("保密");
		
		dao.add("Fruit.insertFruit", f);
		}
	}
	@Test
	public void updateByIdTest() throws SQLException{
		Fruit f = new Fruit();
			f.setFid("20609D8251F34190AD48B83961CFE182");
			f.setFname("西瓜");
			f.setFprice(1.0);
			f.setFamount(2000);
			f.setFpicture("C:\\temp.jpg");
			f.setFdate(new Date());
			f.setPlace("西南石油西瓜种植基地");
			
			f.setProduceaddress("西南油菜花");
		
		dao.add("Fruit.updateById", f);
	}
	@Test
	public void updateByOrderTest() throws SQLException{
		Fruit f = new Fruit();
		f.setFid("20609D8251F34190AD48B83961CFE182");
		f.setFname("苹果");
		f.setFprice(1.0);
		f.setFamount(2000);
		f.setFpicture("C:\\temp.jpg");
		f.setFdate(new Date());
		f.setPlace("西南石油西瓜种植基地");
		f.setSortorder(3);
		f.setProduceaddress("西南油菜花");
	
	dao.add("Fruit.updateByOrder", f);
	}
	@Test
	public void getByIdTest() throws SQLException{
		
		System.out.println(dao.getById("Fruit.getById", "03501054827B41A396A87399E0E22997"));
	}
	@Test
	public void getByOrderTest() throws SQLException{
//		ArrayList
		System.out.println(dao.getByOrder("Fruit.getByOrder", 1));
	}
	@Test
	public void getAllCountTest() throws SQLException{
		
		Number num = dao.allCount("Fruit.getAllCount", "place='西南石油西瓜种植基地'");
		System.out.println(num.longValue());
	}
	@Test
	public void getPage() throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 5);
		map.put("lose", 5);
		map.put("attrUrl", "'a'='a' and place='西南石油'");
		
		List<Fruit> fruits = dao.getCurrentPage("Fruit.getCurrentPage", map);
		for (Fruit fruit  : fruits) {
			System.out.println(fruit);
		}
	}
}

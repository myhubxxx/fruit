package cn.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.CommonUtils;

import cn.fruit.dao.OrdersDao;
import cn.fruit.dao.impl.FruitDaoImpl;
import cn.fruit.dao.impl.OrdersDaoImpl;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.Fruit;
import cn.fruit.domain.Orders;
import cn.fruit.domain.User;

public class OrdersTest {
	
	OrdersDao dao = new OrdersDaoImpl();
	
	@Test
	public void indertTest() throws SQLException{
//		for (int i = 0; i < 20; i++) {
			
		User u = new UserDaoImpl().getById("User.getById", "B523C5AEE64D48458EBD4C59A55C62F6");
		Fruit f = new FruitDaoImpl().getById("Fruit.getById", "20609D8251F34190AD48B83961CFE182");
		Orders order = new Orders();
			order.setFruit(f);
			order.setUser(u);
			order.setNumber(50);
			order.setOdate(new Date());
			order.setOid(CommonUtils.uuid());
			
		Integer flag = dao.add("Orders.insertOrders", order);
		if(null == flag) System.out.println( "null");
		else{System.out.println("not null");}
//		}
	}
	@Test
	public void getById() throws SQLException{
		Orders o = dao.getById("Orders.getById", "7EAC012E87B143C3A0F28F12B42E6211");
		System.out.println(o);
	}
	@Test
	public void getByOrder() throws SQLException{
		Orders o = dao.getByOrder("Orders.getByOrder", 2);
		System.out.println(o);
	}
	@Test
	public void updateById() throws SQLException{
		User u = new UserDaoImpl().getById("User.getById", "FD3BFE0F435F4131BBDD1FF2F28AE040");
		Fruit f = new FruitDaoImpl().getById("Fruit.getById", "E3FBBFB673784D80A4A595B6C0EB1081");
		Orders order = new Orders();
			order.setFruit(f);
			order.setUser(u);
			order.setNumber(100);
			order.setOdate(new Date());

			order.setStatus(1);
			order.setOid("8337E77359AE4A92859C077982931092");
		dao.add("Orders.updateById", order);
	}
	@Test
	public void updateByOrder() throws SQLException{
		User u = new UserDaoImpl().getById("User.getById", "B523C5AEE64D48458EBD4C59A55C62F6");
		Fruit f = new FruitDaoImpl().getById("Fruit.getById", "20609D8251F34190AD48B83961CFE182");
		Orders order = new Orders();
			order.setFruit(f);
			order.setUser(u);
			order.setNumber(100);
			order.setOdate(new Date());
			order.setOid(CommonUtils.uuid());
			order.setStatus(2);
			order.setSortorder(1);
		dao.add("Orders.updateByOrder", order);
	}
	@Test
	public void deleteById() throws SQLException{
		
		dao.deleteById("Orders.deleteById", "1E939E1DCB3F406181D947D5D2114CA7");
	}
	@Test
	public void deleteByOrder() throws SQLException{
		
		dao.deleteByOrder("Orders.deleteByOrder", 2);
	}
	@Test
	public void getAllCountTest() throws SQLException{
		
		Number num = dao.allCount("Orders.getAllCount", "number=50");
		System.out.println(num.longValue());
	}
	@Test
	public void getPage() throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 5);
		map.put("lose", 5);
		map.put("attrUrl", "number=50");
		
		List<Orders> orderss = dao.getCurrentPage("Orders.getCurrentPage", map);
		for (Orders orders  : orderss) {
			System.out.println(orders);
		}
	}
}

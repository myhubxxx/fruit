package cn.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import util.CommonUtils;
import cn.fruit.dao.UserDao;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.User;

public class UserTest {

	UserDao dao = new UserDaoImpl();
	@Test
	public void addTest() throws SQLException{
//		for (int i = 0; i < 20; i++) {
			
		User user = new User();
			user.setUid(CommonUtils.uuid());
			user.setUnumber("張三");
			user.setUpass("123sdfsdfsf");
			user.setUname("ggg");
			user.setUdate(new Date());
			user.setAddress("西南石油大学");
		dao.add("User.insertUser", user);
//		}
	}
	@Test
	public void updateOrderTest() throws SQLException{
		User user = new User();
		user.setUid(" 5");
		user.setUnumber("110001001");
		user.setUpass("=1");
		user.setUname("48wewe");
//		user.setUdate(new Date());
		user.setSortorder(5);
		user.setAddress("西南石油");
		dao.updateByOrder("User.updateByOrder", user);
	}
	@Test
	public void updateIdTest() throws SQLException{
		User user = new User();
		user.setUid("FD3BFE0F435F4131BBDD1FF2F28AE040");
		user.setUnumber("111");
		user.setUpass("333");
		user.setUname("48wewe");
//		user.setUdate(new Date());
		user.setSortorder(5);
		user.setAddress("西南石油大学");
		dao.updateByOrder("User.updateById", user);
	}
	@Test
	public void getById() throws SQLException{
		
		System.out.println(dao.getById("User.getById", "311D3BC128924FC58D089C79995ED4D8"));
		
	}
	@Test
	public void getByOrder() throws SQLException{
		System.out.println(dao.getByOrder("User.getByOrder", 4));
	}
	@Test
	public void deleteById() throws SQLException{
		
		dao.deleteById("User.deleteById", "EF3B5C1F4C28436684790F3B2A90218D");
	}
	@Test
	public void deleteByOrder() throws SQLException{
		
		dao.deleteByOrder("User.deleteByOrder", 4);
	}
	
	@Test
	public void UUIDLengthTest(){
		System.out.println(CommonUtils.uuid()+ ":" + CommonUtils.uuid().length());
		
	}
	@Test
	public void getAllCountTest() throws SQLException{
		
		Number num = dao.allCount("User.getAllCount", "address='西南石油大学' and unumber='xyz' and upass=123");
		System.out.println(num.longValue());
	}
	@Test
	public void getPage() throws SQLException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 5);
		map.put("lose", 5);
		map.put("attrUrl", "address='西南石油大学'  and upass=123");
		
		List<User> users = dao.getCurrentPage("User.getCurrentPage", map);
		for (User user : users) {
			System.out.println(user);
		}
	}
	@Test
	public void getByNumber() throws SQLException{
		System.out.println(dao.getByNumber("111"));
	}
}

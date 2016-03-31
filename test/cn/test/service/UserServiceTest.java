package cn.test.service;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import util.CommonUtils;
import util.UserException;
import cn.fruit.domain.User;
import cn.fruit.service.UserService;
import cn.fruit.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	UserService service = new UserServiceImpl();
	
	@Test
	public void userServiceInsertTest(){
		User user = new User();
		user.setUid(CommonUtils.uuid());
		user.setUnumber("xyz");
		user.setUpass("123");
		user.setUname("ggg");
		user.setUdate(new Date());
		user.setAddress("西南石油大学");
		
		try {
			service.addUser( user);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void ChangePassTest(){
		
		
		
		
	}
	
	
}

package cn.fruit.dao.impl;

import java.sql.SQLException;

import javax.jms.Session;

import cn.fruit.dao.UserDao;
import cn.fruit.domain.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getByNumber(String Number) throws SQLException {
		User user = null;
		
		user = (User) session.queryForObject("User.getByNumber", Number);
		
		return user;
	}



}

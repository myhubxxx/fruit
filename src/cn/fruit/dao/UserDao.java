package cn.fruit.dao;

import java.sql.SQLException;

import cn.fruit.domain.User;

public interface UserDao extends BaseDao<User>{
	
	
	public User getByNumber(String number)throws SQLException;

}

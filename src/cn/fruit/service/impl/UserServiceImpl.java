package cn.fruit.service.impl;

import java.sql.SQLException;
import java.util.Date;

import util.CommonUtils;
import util.SqlMapClientUtil;
import util.UserException;
import cn.fruit.dao.UserDao;
import cn.fruit.dao.impl.UserDaoImpl;
import cn.fruit.domain.User;
import cn.fruit.service.UserService;

import com.ibatis.sqlmap.client.SqlMapSession;

public class UserServiceImpl implements UserService {

	private UserDao dao = new UserDaoImpl();
	private SqlMapSession session = SqlMapClientUtil.client.openSession();
	
	/**
	 * add user to db
	 */
	public void addUser(User form) throws UserException{
		
		form.setUid(CommonUtils.uuid());
		
		try {
			session.startTransaction();
			
			User user = dao.getByNumber(form.getUnumber());
			if(null != user) throw new UserException("该用户名已存在");
			dao.add("User.insertUser", form);
			
			session.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void changePass(User form, String newPass) throws UserException {
		
		try {
			session.startTransaction();
			
			User user = dao.getById("User.getById", form.getUid());
			if(null == user) throw new UserException("用户不存在");
			if(! user.getUpass().equals(form.getUpass()))throw new UserException("旧密码错误");
			
			user.setUpass(newPass);
			dao.updateById("User.updateById", user);
			
			session.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}


	@Override
	public User login(User form) throws UserException {
		User user = null;
		try {
			session.startTransaction();
			
			user = dao.getByNumber(form.getUnumber());
			
			session.commitTransaction();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				session.endTransaction();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public void regist(User form) throws UserException {
		form.setUid(CommonUtils.uuid());
		form.setUdate(new Date());
		try{
			session.startTransaction();
				
			dao.add("User.insertUser", form);
			
			session.commitTransaction();
		}catch(Exception e){
			try {
				session.endTransaction();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new UserException(e);
		}
		
	}
	
	
}


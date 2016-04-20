package cn.fruit.service;


import util.UserException;

import cn.fruit.domain.User;

public interface UserService {


	public void addUser(User form) throws UserException;
	
	public void changePass(User form, String newPass) throws UserException;
	
	public User login(User form)throws UserException;
	
	public void regist(User form) throws UserException;
	
	
}

package cn.fruit.service;


import util.UserException;

import cn.fruit.domain.User;

public interface UserService {


	public void addUser(User form) throws UserException;
	
	public void changePass(User form, String newPass) throws UserException;
	
	
	
	
}

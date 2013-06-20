package com.ycx.reglog.service;

import com.ycx.reglog.dao.UserDao;

public interface UserService {

	// 登录验证
	int loginValidate(String name, String pass) throws Exception;

	// 注册时的用户名可用否
	boolean validateName(String name) throws Exception;

	int addUser(String name, String pass, String email, int level)
			throws Exception;

}
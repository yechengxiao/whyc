package com.ycx.reglog.service;

import com.ycx.reglog.dao.UserDao;
import com.ycx.reglog.entity.User;

public class UserServiceImpl implements UserService {

	private UserDao uDao;

	// 登录验证
	@Override
	public int loginValidate(String name, String pass) throws Exception {
		try {
			User user = uDao.findByNAndP(name, pass);
			if (user != null) {
				return user.getId();
			}
			return -1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// 注册时的用户名可用否
	@Override
	public boolean validateName(String name) throws Exception {
		try {
			User u = uDao.findByName(name);
			if (u == null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public int addUser(String name, String pass, String email, int level)
			throws Exception {
		try {
			User u = new User();
			u.setUsername(name);
			u.setUserpass(pass);
			u.setEmail(email);
			u.setLevel(level);
			uDao.save(u);
			// 直接获取用户id
			return u.getId();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void setuDao(UserDao uDao) {
		this.uDao = uDao;
	}

}

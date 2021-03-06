package com.ycx.reglog.dao;

import java.util.List;

import com.ycx.reglog.entity.User;

public interface UserDao {

	public void save(User transientInstance);

	public void delete(User persistentInstance);

	public User findById(java.lang.Integer id);

	public List findAll();

	public abstract User findByNAndP(String name, String pass);

	public abstract User findByName(String name);
}
package com.ycx.dao;

import java.util.List;

import com.ycx.model.Work;

public interface WorkDAO {

	public void save(Work transientInstance);

	public void update(Work w);

	public void delete(int id);

	public void delete(Work persistentInstance);

	public Work findById(java.lang.Integer id);

	public List findByState(int state);

	public List findAll();

}
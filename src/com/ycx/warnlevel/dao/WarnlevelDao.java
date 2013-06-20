package com.ycx.warnlevel.dao;

import java.util.List;

import com.ycx.warnlevel.entity.Warnlevel;

public interface WarnlevelDao {

	public void save(Warnlevel transientInstance);

	public void delete(Warnlevel persistentInstance);

	public Warnlevel findById(java.lang.Integer id);

	public List findAll();

	public abstract void update(Warnlevel wl);

}
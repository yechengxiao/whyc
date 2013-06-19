package com.ycx.dao;

import java.util.List;

import com.ycx.model.Warnlevel;

public interface WarnlevelDAO {

	public void save(Warnlevel transientInstance);

	public void delete(Warnlevel persistentInstance);

	public Warnlevel findById(java.lang.Integer id);

	public List findAll();

	public abstract void update(Warnlevel wl);

}
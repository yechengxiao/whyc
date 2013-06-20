package com.ycx.dao;

import java.util.List;

import com.ycx.model.IndiWarn;

public interface IndiWarnDao {

	public void save(IndiWarn transientInstance);

	public void update(IndiWarn iw);

	public void delete(int id);

	public void delete(IndiWarn persistentInstance);

	public IndiWarn findById(java.lang.Integer id);

	public List findByIndiId(int id);

	public List findByWarnId(int id);

	public List findAll();

	public abstract List findByMatch(int match);

}
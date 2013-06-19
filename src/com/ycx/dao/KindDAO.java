package com.ycx.dao;

import java.util.List;

import com.ycx.model.Kind;

public interface KindDAO {

	public void save(Kind transientInstance);

	public void delete(Kind persistentInstance);

	public Kind findById(java.lang.Integer id);

	public List findAll();

}
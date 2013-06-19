package com.ycx.dao;

import java.util.List;

import com.ycx.model.Warnstodo;

public interface WarnstodoDAO {

	// property constants
	public static final String NAME = "name";
	public static final String CONTENT = "content";

	public void save(Warnstodo transientInstance);

	public void delete(Warnstodo persistentInstance);

	public Warnstodo findById(java.lang.Integer id);

	public List findByExample(Warnstodo instance);

	public List findByProperty(String propertyName, Object value);

	public List findByName(Object name);

	public List findByContent(Object content);

	public List findAll();

	public Warnstodo merge(Warnstodo detachedInstance);

	public void attachDirty(Warnstodo instance);

	public void attachClean(Warnstodo instance);

}
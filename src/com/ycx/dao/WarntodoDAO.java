package com.ycx.dao;

import java.util.List;

import com.ycx.model.Warntodo;

public interface WarntodoDAO {

	// property constants
	public static final String NAME = "name";
	public static final String KIND = "kind";
	public static final String CONTENT = "content";
	public static final String WARN = "warn";

	public void save(Warntodo transientInstance);

	public void delete(Warntodo persistentInstance);

	public Warntodo findById(java.lang.Integer id);

	public List findAll();

	public abstract List findByState(int state);

	public abstract void update(Warntodo w);
}
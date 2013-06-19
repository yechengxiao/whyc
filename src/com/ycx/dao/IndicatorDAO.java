package com.ycx.dao;

import java.util.List;

import com.ycx.model.Indicator;

public interface IndicatorDAO {

	public void save(Indicator transientInstance);

	public void update(Indicator indi);

	public Indicator findById(java.lang.Integer id);

	public List findByState();

	public List findByState(int state);

	public List findAll();

	public void delete(String rowFlag);

	public abstract List search(String str);

}
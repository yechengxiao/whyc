package com.ycx.indicator.dao;

import java.util.List;

import com.ycx.indicator.entity.Indicator;


public interface IndicatorDao {

	public void save(Indicator transientInstance);

	public void update(Indicator indi);

	public Indicator findById(java.lang.Integer id);

	public List findByState();

	public List findByState(int state);

	public List findAll();

	public void delete(String rowFlag);

	public abstract List search(String str);

}
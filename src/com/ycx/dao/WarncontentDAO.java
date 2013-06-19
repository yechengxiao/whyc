package com.ycx.dao;

import java.util.List;

import com.ycx.model.Warncontent;

public interface WarncontentDAO {

	public void save(Warncontent transientInstance);

	public void update();

	public void delete(String rowFlag);

	public Warncontent findById(java.lang.Integer id);

	public List findAll();

}
package com.ycx.warncontent.dao;

import java.util.List;

import com.ycx.warncontent.entity.Warncontent;

public interface WarncontentDao {

	public void save(Warncontent transientInstance);

	public void update();

	public void delete(String rowFlag);

	public Warncontent findById(java.lang.Integer id);

	public List findAll();

}
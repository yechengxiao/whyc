package com.ycx.dao;

import java.util.List;

import com.ycx.model.Match;

public interface MatchDao {

	public void save(Match transientInstance);

	public void update(Match m);

	public void delete(Match persistentInstance);

	public List findAll();

}
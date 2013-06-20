package com.ycx.warntodo.service;

import java.util.List;

import com.ycx.warntodo.WtodoBean;

public interface WarntodoService {

	WtodoBean getWtodo(int id) throws Exception;

	List getAvailWtodos() throws Exception;

	void doneWtodo(int id, String content) throws Exception;

	public abstract List getDoneWtodos() throws Exception;

}
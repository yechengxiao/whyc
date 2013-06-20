package com.ycx.work.service;

import java.util.List;

import com.ycx.model.IndiWarn;
import com.ycx.work.WorkBean;

public interface WorkService {

	WorkBean getWork(int id) throws Exception;

	List getAllWorks() throws Exception;

	List getAvailWorks() throws Exception;

	void createWtodo(int id, int[] wcIds) throws Exception;

	void updateWorkState() throws Exception;

	void updateWork(int id) throws Exception;

	List<IndiWarn> getIndiWarn(int workMatch) throws Exception;

}
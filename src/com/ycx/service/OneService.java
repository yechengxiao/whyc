package com.ycx.service;

import java.util.List;
import java.util.Map;

import com.ycx.business.IndicatorBean;
import com.ycx.business.WarncontentBean;
import com.ycx.business.WorkBean;
import com.ycx.business.WtodoBean;
import com.ycx.model.Indicator;

public interface OneService {

	public abstract void updateWork(int id) throws Exception;

	public abstract void pubWork(int indiId, Integer[] id) throws Exception;

	public abstract void addIndiWarn(int indiId, Integer[] id) throws Exception;

	public abstract void addWarncontent(String content, int warnlevelId)
			throws Exception;

	public abstract void addIndi(String name, String method, int avail,
			String content, String note, int kindId) throws Exception;

	public abstract WorkBean getWork(int id) throws Exception;

	public abstract List getAllWorks() throws Exception;

	public abstract WarncontentBean getWarncontent(int id) throws Exception;

	public abstract List getAllWarncontents() throws Exception;

	public abstract IndicatorBean getIndicator(int id) throws Exception;

	public abstract List getAllIndicators() throws Exception;

	public abstract List getAllKinds() throws Exception;

	public abstract List getAllWarnlevels() throws Exception;

	public abstract List getIndiWarn(int workMatch) throws Exception;

	public abstract List getWConsByMatch(int match) throws Exception;

	public abstract List getAvailWorks() throws Exception;

	public abstract void createWtodo(int id, int[] wcIds) throws Exception;

	public abstract WtodoBean getWtodo(int id) throws Exception;

	public abstract List getAvailWtodos() throws Exception;

	public abstract void doneWtodo(int id, String content) throws Exception;

	public abstract List getDoneWtodos() throws Exception;

	public abstract void updateWorkState() throws Exception;

	public abstract Map getWLevCount() throws Exception;

	public abstract int addUser(String name, String pass, String email,
			int level) throws Exception;

	public abstract boolean validateName(String name) throws Exception;

	public abstract int loginValidate(String name, String pass)
			throws Exception;

	public abstract void deleteIndi(String rowFlag) throws Exception;

	public abstract void deleteWCon(String rowFlag) throws Exception;

	public abstract List searchIndi(String str) throws Exception;

}
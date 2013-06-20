package com.ycx.indicator.service;

import java.util.List;

import com.ycx.indicator.IndicatorBean;

public interface IndicatorService {

	public abstract void addIndiWarn(int indiId, Integer[] id) throws Exception;

	public abstract void pubWork(int indiId, Integer[] id) throws Exception;

	public abstract List searchIndi(String str) throws Exception;

	public abstract void deleteIndi(String rowFlag) throws Exception;

	public abstract void addIndi(String name, String method, int period,
			String content, String note, int kindId) throws Exception;

	public abstract IndicatorBean getIndicator(int id) throws Exception;

	public abstract List getAllIndicators() throws Exception;

	public abstract List getAllKinds() throws Exception;

}

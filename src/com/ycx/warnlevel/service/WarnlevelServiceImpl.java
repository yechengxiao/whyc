package com.ycx.warnlevel.service;

import java.util.List;

import com.ycx.warnlevel.dao.WarnlevelDao;

public class WarnlevelServiceImpl implements WarnlevelService {
	private WarnlevelDao wlDao;

	@Override
	public List getAllWarnlevels() throws Exception {
		try {
			return wlDao.findAll();
		} catch (Exception e) {
			throw new Exception("getAllWarnlevels  出错。");
		}
	}

	public void setWlDao(WarnlevelDao wlDao) {
		this.wlDao = wlDao;
	}

}

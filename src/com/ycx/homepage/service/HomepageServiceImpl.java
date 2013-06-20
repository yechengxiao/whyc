package com.ycx.homepage.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ycx.warnlevel.dao.WarnlevelDao;
import com.ycx.warnlevel.entity.Warnlevel;

public class HomepageServiceImpl implements HomepageService {
	private WarnlevelDao wlDao;

	// 获取预警数
	@Override
	public Map getWLevCount() throws Exception {
		try {
			Map<String, Integer> map = new HashMap();
			List<Warnlevel> wlList = wlDao.findAll();
			for (int i = 0; i < (wlList.size() - 1); i++) {
				Warnlevel wl = (Warnlevel) wlList.get(i);
				map.put(wl.getLevel(), wl.getCount());
			}
			return map;
		} catch (Exception e) {
			throw new Exception("getWLevCount  出错。");
		}
	}

	public void setWlDao(WarnlevelDao wlDao) {
		this.wlDao = wlDao;
	}

}

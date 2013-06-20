package com.ycx.warntodo.service;

import java.util.ArrayList;
import java.util.List;

import com.ycx.dao.IndiWarnDao;
import com.ycx.model.IndiWarn;
import com.ycx.warncontent.dao.WarncontentDao;
import com.ycx.warnlevel.dao.WarnlevelDao;
import com.ycx.warnlevel.entity.Warnlevel;
import com.ycx.warntodo.WtodoBean;
import com.ycx.warntodo.dao.WarntodoDao;
import com.ycx.warntodo.entity.Warntodo;

public class WarntodoServiceImpl implements WarntodoService {
	private WarntodoDao wtdDao;
	private WarncontentDao wcDao;
	private IndiWarnDao iwDao;
	private WarnlevelDao wlDao;

	@Override
	public WtodoBean getWtodo(int id) throws Exception {
		try {
			Warntodo wtd = wtdDao.findById(id);
			WtodoBean wtdb = new WtodoBean();
			initWtodo(wtdb, wtd);
			return wtdb;
		} catch (Exception e) {
			throw new Exception("	getWtodo  出错。");
		}
	}

	@Override
	public List getAvailWtodos() throws Exception {
		try {
			List result = new ArrayList();
			List l = wtdDao.findByState(1);
			for (int i = 0; i < l.size(); i++) {
				Warntodo wtd = (Warntodo) l.get(i);
				WtodoBean wtdb = new WtodoBean();
				initWtodo(wtdb, wtd);
				result.add(wtdb);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getAvailWtodos  出错。");
		}
	}

	@Override
	public void doneWtodo(int id, String content) throws Exception {
		try {
			Warntodo wtd = wtdDao.findById(id);
			wtd.setContent(content);
			wtd.setState(-1);
			wtdDao.update(wtd);
			reduceWLevCount(id);
		} catch (Exception e) {
			throw new Exception("doneWtodo  出错。");
		}
	}

	// 获取历史
	@Override
	public List getDoneWtodos() throws Exception {
		try {
			List result = new ArrayList();
			List l = wtdDao.findByState(-1);
			for (int i = 0; i < l.size(); i++) {
				Warntodo wtd = (Warntodo) l.get(i);
				WtodoBean wtdb = new WtodoBean();
				initWtodo(wtdb, wtd);
				result.add(wtdb);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getDoneWtodos  出错。");
		}
	}

	// 预警等级数减少。
	private void reduceWLevCount(int wtdId) throws Exception {
		try {
			Warntodo wtd = wtdDao.findById(wtdId);
			int workMatch = wtd.getWork().getWorkMatch();

			List iwList = iwDao.findByMatch(workMatch);

			for (int i = 0; i < iwList.size(); i++) {
				IndiWarn iw = (IndiWarn) iwList.get(i);
				// Warnlevel wl = iw.getWarncontent().getWarnlevel();
				int warnId = iw.getWarnId();
				Warnlevel wl = wcDao.findById(warnId).getWarnlevel();
				int count = wl.getCount();
				if (count > 0) {
					count--;
				} else {
					count = 0;
				}
				wl.setCount(count);
				wlDao.update(wl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initWtodo(WtodoBean wtdb, Warntodo wtd) throws Exception {
		wtdb.setId(wtd.getId());
		wtdb.setWorkid(wtd.getWork().getId());
		wtdb.setName(wtd.getName());
		wtdb.setKind(wtd.getKind());
		wtdb.setWarn(wtd.getWarn());
	}

	public void setWtdDao(WarntodoDao wtDao) {
		this.wtdDao = wtDao;
	}

	public void setWcDao(WarncontentDao wcDao) {
		this.wcDao = wcDao;
	}

	public void setIwDao(IndiWarnDao iwDao) {
		this.iwDao = iwDao;
	}

	public void setWlDao(WarnlevelDao wlDao) {
		this.wlDao = wlDao;
	}

}

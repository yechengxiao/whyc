package com.ycx.warncontent.service;

import java.util.ArrayList;
import java.util.List;

import com.ycx.dao.IndiWarnDao;
import com.ycx.model.IndiWarn;
import com.ycx.warncontent.WarncontentBean;
import com.ycx.warncontent.dao.WarncontentDao;
import com.ycx.warncontent.entity.Warncontent;
import com.ycx.warnlevel.dao.WarnlevelDao;
import com.ycx.warnlevel.entity.Warnlevel;

public class WarncontentServiceImpl implements WarncontentService {
	private WarncontentDao wcDao;
	private WarnlevelDao wlDao;
	private IndiWarnDao iwDao;

	// 一条具体的warncontent
	public WarncontentBean getWarncontent(int id) throws Exception {
		try {
			WarncontentBean wcb = new WarncontentBean();
			initWarncontent(wcb, wcDao.findById(id));
			return wcb;
		} catch (Exception e) {
			throw new Exception("getWarncontent  出错。");
		}
	}

	// 获取所有
	@Override
	public List getAllWarncontents() throws Exception {
		try {
			List result = new ArrayList();
			List l = wcDao.findAll();
			for (int i = 0; i < l.size(); i++) {
				Warncontent wc = (Warncontent) l.get(i);
				WarncontentBean wcb = new WarncontentBean();
				initWarncontent(wcb, wc);
				result.add(wcb);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getAllWarncontents  出错。");
		}
	}

	// 为了匹配多条预警内容
	@Override
	public List getWConsByMatch(int match) throws Exception {
		try {
			List result = new ArrayList();
			List indiWarn = iwDao.findByMatch(match);

			for (int i = 0; i < indiWarn.size(); i++) {
				IndiWarn iw = (IndiWarn) indiWarn.get(i);
				int wcId = iw.getWarnId();
				Warncontent wc = wcDao.findById(wcId);// 第二次去数据库查，效率问题。

				WarncontentBean wcb = new WarncontentBean();

				initWarncontent(wcb, wc);

				result.add(wcb);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getWConsByMatch  出错。");
		}
	}

	// 新增
	public void addWarncontent(String content, int warnlevelId)
			throws Exception {
		try {
			Warnlevel level = wlDao.findById(warnlevelId);
			Warncontent warncon = new Warncontent();

			warncon.setContent(content);
			warncon.setWarnlevel(level);

			wcDao.save(warncon);
		} catch (Exception e) {
			throw new Exception("addWarncontent  出错。");
		}
	}

	// 删除
	public void deleteWCon(String rowFlag) throws Exception {
		try {
			wcDao.delete(rowFlag);
		} catch (Exception e) {
			throw new Exception("service deleteWCon  出错。");
		}
	}

	private void initWarncontent(WarncontentBean wcb, Warncontent wc)
			throws Exception {
		wcb.setId(wc.getId());
		wcb.setContent(wc.getContent());
		wcb.setLevel(wc.getWarnlevel().getLevel());
	}

	// Spirng实例化对象
	public void setWcDao(WarncontentDao wcDao) {
		this.wcDao = wcDao;
	}

	public void setWlDao(WarnlevelDao wlDao) {
		this.wlDao = wlDao;
	}

	public void setIwDao(IndiWarnDao iwDao) {
		this.iwDao = iwDao;
	}

}
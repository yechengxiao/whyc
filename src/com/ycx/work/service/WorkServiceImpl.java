package com.ycx.work.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ycx.dao.IndiWarnDao;
import com.ycx.model.IndiWarn;
import com.ycx.warncontent.WarncontentBean;
import com.ycx.warncontent.dao.WarncontentDao;
import com.ycx.warncontent.entity.Warncontent;
import com.ycx.warnlevel.dao.WarnlevelDao;
import com.ycx.warnlevel.entity.Warnlevel;
import com.ycx.warntodo.WtodoBean;
import com.ycx.warntodo.dao.WarntodoDao;
import com.ycx.warntodo.entity.Warntodo;
import com.ycx.work.WorkBean;
import com.ycx.work.dao.WorkDao;
import com.ycx.work.entity.Work;

public class WorkServiceImpl implements WorkService {
	private WorkDao wDao;
	private WarncontentDao wcDao;
	private WarntodoDao wtdDao;
	private IndiWarnDao iwDao;
	private WarnlevelDao wlDao;
	// 规定格式
	private SimpleDateFormat sdf;

	@Override
	public WorkBean getWork(int id) throws Exception {
		try {
			Work w = wDao.findById(id);
			WorkBean wb = new WorkBean();
			initWork(wb, w);
			return wb;
		} catch (Exception e) {
			throw new Exception("service getWork 出错。");
		}
	}

	@Override
	public List getAllWorks() throws Exception {
		try {
			return wDao.findAll();
		} catch (Exception e) {
			throw new Exception("getAllWorks  出错。");
		}
	}

	@Override
	public List getAvailWorks() throws Exception {
		try {
			return wDao.findByState(1);
		} catch (Exception e) {
			throw new Exception("getAvailWorks 出错。");
		}
	}

	@Override
	public List<IndiWarn> getIndiWarn(int workMatch) throws Exception {
		try {
			return iwDao.findByMatch(workMatch);
		} catch (Exception e) {
			throw new Exception("getIndiWarn  出错。");
		}
	}

	@Override
	public void createWtodo(int id, int[] wcIds) throws Exception {
		try {
			updateWork(id);

			Work w = wDao.findById(id);
			Warntodo wtd = new Warntodo();
			wtd.setName(w.getName());
			wtd.setWork(wDao.findById(id));
			wtd.setKind(w.getKind());

			List<Warncontent> wcons = new ArrayList();
			for (int i = 0; i < wcIds.length; i++) {
				wcons.add(wcDao.findById(wcIds[i]));
			}
			String wcon = ((Warncontent) wcons.get(0)).getContent();
			for (int i = 1; i < wcons.size(); i++) {
				wcon += "\n" + ((Warncontent) wcons.get(i)).getContent();
			}

			wtd.setWarn(wcon);
			wtd.setState(1);
			wtdDao.save(wtd);
			plusWLevCount(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// 预警等级数增加。
	private void plusWLevCount(int workId) throws Exception {
		try {
			int workMatch = wDao.findById(workId).getWorkMatch();
			List iwList = iwDao.findByMatch(workMatch);

			for (int i = 0; i < iwList.size(); i++) {
				IndiWarn iw = (IndiWarn) iwList.get(i);
				// Warnlevel wl = iw.getWarncontent().getWarnlevel();
				int warncontentId = iw.getWarnId();
				Warnlevel wl = wcDao.findById(warncontentId).getWarnlevel();
				int count = wl.getCount();
				count++;
				wl.setCount(count);
				wlDao.update(wl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWorkState() throws Exception {
		try {
			List workList = wDao.findByState(-1);
			for (int i = 0; i < workList.size(); i++) {
				Work w = (Work) workList.get(i);

				sdf = new SimpleDateFormat("yyyyMMdd");
				String doDate = sdf.format(w.getDoDate());
				String current = sdf.format(new Date());
				if (doDate.equals(current)) {
					w.setState(1);
					wDao.update(w);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateWork(int id) throws Exception {
		try {
			Work w = wDao.findById(id);
			sdf = new SimpleDateFormat("yyyyMMdd");
			String oldD = sdf.format(w.getDoDate());
			Date oldDate = sdf.parse(oldD);

			Calendar c = Calendar.getInstance();
			int fre = w.getFrequency();
			c.setTime(oldDate);
			c.add(Calendar.DAY_OF_MONTH, fre);
			Date newDate = c.getTime();

			w.setState(-1);
			w.setDoDate(newDate);
			wDao.update(w);
		} catch (Exception e) {
			throw new Exception("updateWork  出错。");
		}
	}

	private void initWork(WorkBean wb, Work w) throws Exception {
		wb.setId(w.getId());
		wb.setName(w.getName());
		wb.setKind(w.getKind());
		wb.setMethod(w.getMethod());
		wb.setContent(w.getContent());
		wb.setFrequency(w.getFrequency());
		wb.setWorkMatch(w.getWorkMatch());
		wb.setNote(w.getNote());
	}

	public void setwDao(WorkDao wDao) {
		this.wDao = wDao;
	}

	public void setWcDao(WarncontentDao wcDao) {
		this.wcDao = wcDao;
	}

	public void setWtdDao(WarntodoDao wtDao) {
		this.wtdDao = wtDao;
	}

	public void setIwDao(IndiWarnDao iwDao) {
		this.iwDao = iwDao;
	}

	public void setWlDao(WarnlevelDao wlDao) {
		this.wlDao = wlDao;
	}
}

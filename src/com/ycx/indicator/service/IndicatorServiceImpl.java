package com.ycx.indicator.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ycx.dao.IndiWarnDao;
import com.ycx.dao.KindDao;
import com.ycx.dao.MatchDao;
import com.ycx.indicator.IndicatorBean;
import com.ycx.indicator.dao.IndicatorDao;
import com.ycx.indicator.entity.Indicator;
import com.ycx.model.IndiWarn;
import com.ycx.model.Kind;
import com.ycx.model.Match;
import com.ycx.work.dao.WorkDao;
import com.ycx.work.entity.Work;

public class IndicatorServiceImpl implements IndicatorService {
	private IndicatorDao indiDao;
	private KindDao kindDao;
	private MatchDao matchDao;
	private IndiWarnDao iwDao;
	private WorkDao wDao;
	// 任务需要匹配对应的监测指标、预警指标
	private int workMatch;
	private Match ma;

	@Override
	public List getAllKinds() throws Exception {
		try {
			return kindDao.findAll();
		} catch (Exception e) {
			throw new Exception("getAllKinds 出错。");
		}
	}

	@Override
	public List getAllIndicators() throws Exception {
		try {
			List result = new ArrayList();
			List l = indiDao.findAll();
			for (int i = 0; i < l.size(); i++) {
				Indicator indi = (Indicator) l.get(i);
				IndicatorBean ib = new IndicatorBean();
				initIndi(ib, indi);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getAllIndicators 出错。");
		}
	}

	@Override
	public IndicatorBean getIndicator(int id) throws Exception {
		try {
			Indicator indi = indiDao.findById(id);
			IndicatorBean ib = new IndicatorBean();
			initIndi(ib, indi);
			return ib;
		} catch (Exception e) {
			throw new Exception("getIndicator 出错。");
		}
	}

	@Override
	public void addIndi(String name, String method, int period, String content,
			String note, int kindId) throws Exception {
		try {
			Indicator indi = new Indicator();
			Kind kind = kindDao.findById(kindId);

			indi.setName(name);
			indi.setMethod(method);
			indi.setContent(content);
			indi.setNote(note);
			indi.setKind(kind);

			indi.setAddTime(new Date());
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, period + 1);
			indi.setEndTime(c.getTime());

			indi.setState(1);

			indiDao.save(indi);
		} catch (Exception e) {
			throw new Exception("addIndi  出错。");
		}
	}

	// 删除Indicator
	@Override
	public void deleteIndi(String rowFlag) throws Exception {
		try {
			indiDao.delete(rowFlag);
		} catch (Exception e) {
			throw new Exception("service deleteIndi  出错。");
		}
	}

	// 查询Indicaotr
	@Override
	public List searchIndi(String str) throws Exception {
		try {
			List result = new ArrayList();
			List l = indiDao.search(str);
			for (int i = 0; i < l.size(); i++) {
				Indicator indi = (Indicator) l.get(i);
				IndicatorBean ib = new IndicatorBean();
				initIndi(ib, indi);
				result.add(ib);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("service searcherIndi  出错。");
		}
	}

	// 发布工作
	@Override
	public void pubWork(int indiId, Integer[] id) throws Exception {
		try {
			setMatch();
			addIndiWarn(indiId, id);

			Work w = new Work();
			Indicator indi = indiDao.findById(indiId);

			w.setName(indi.getName());
			w.setMethod(indi.getMethod());
			w.setKind(indi.getKind().getName());
			w.setContent(indi.getContent());
			w.setNote(indi.getNote());

			Date addTime = indi.getAddTime();
			Date endTime = indi.getEndTime();
			long dateFre = (endTime.getTime() - addTime.getTime()) > 0 ? (endTime
					.getTime() - addTime.getTime())
					: (addTime.getTime() - endTime.getTime());
			long time = 1000 * 60 * 60 * 24;
			long fre = dateFre / time;
			w.setFrequency((int) fre);

			w.setDoDate(addTime);
			w.setWorkMatch(workMatch);
			w.setState(1);

			wDao.save(w);

			workMatch++;
			ma.setWorkMatch(workMatch);
			matchDao.update(ma);
		} catch (Exception e) {
			throw new Exception("pubWork  出错。");
		}
	}

	private void setMatch() {
		ma = new Match();
		List l = matchDao.findAll();
		if (l.size() == 0) {
			ma.setWorkMatch(1);
			matchDao.save(ma);
			List ll = matchDao.findAll();
			ma = (Match) ll.get(0);
		} else {
			ma = (Match) l.get(0);
		}
		workMatch = ma.getWorkMatch();
	}

	@Override
	public void addIndiWarn(int indiId, Integer[] id) throws Exception {
		try {
			for (int i = 0; i < id.length; i++) {
				IndiWarn iw = new IndiWarn();

				iw.setIndiId(indiId);
				iw.setWarnId(id[i]);
				iw.setWorkMatch(workMatch);
				iwDao.save(iw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 转换Bean
	private void initIndi(IndicatorBean ib, Indicator i) throws Exception {
		ib.setId(i.getId());
		ib.setName(i.getName());
		ib.setKind(i.getKind().getName());
		ib.setMethod(i.getMethod());
		ib.setContent(i.getContent());
		ib.setNote(i.getNote());
	}

	public void setIndiDao(IndicatorDao indiDao) {
		this.indiDao = indiDao;
	}

	public void setKindDao(KindDao kindDao) {
		this.kindDao = kindDao;
	}

	public void setMatchDao(MatchDao matchDao) {
		this.matchDao = matchDao;
	}

	public void setIwDao(IndiWarnDao iwDao) {
		this.iwDao = iwDao;
	}

	public void setwDao(WorkDao wDao) {
		this.wDao = wDao;
	}

	// spring实例化对象

}

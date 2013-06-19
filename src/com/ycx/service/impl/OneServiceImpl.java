package com.ycx.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ycx.business.IndicatorBean;
import com.ycx.business.WarncontentBean;
import com.ycx.business.WorkBean;
import com.ycx.business.WtodoBean;
import com.ycx.dao.IndiWarnDAO;
import com.ycx.dao.IndicatorDAO;
import com.ycx.dao.KindDAO;
import com.ycx.dao.MatchDAO;
import com.ycx.dao.UserDAO;
import com.ycx.dao.WarncontentDAO;
import com.ycx.dao.WarnlevelDAO;
import com.ycx.dao.WarntodoDAO;
import com.ycx.dao.WorkDAO;
import com.ycx.model.IndiWarn;
import com.ycx.model.Indicator;
import com.ycx.model.Kind;
import com.ycx.model.Match;
import com.ycx.model.User;
import com.ycx.model.Warncontent;
import com.ycx.model.Warnlevel;
import com.ycx.model.Warntodo;
import com.ycx.model.Work;
import com.ycx.service.OneService;

public class OneServiceImpl implements OneService {
	private UserDAO userDAO;
	private IndicatorDAO indiDAO;
	private KindDAO kindDAO;
	private IndiWarnDAO iwDAO;
	private WarncontentDAO warncontentDAO;
	private WarnlevelDAO warnlevelDAO;
	private WorkDAO workDAO;
	private WarntodoDAO warntodoDAO;
	private MatchDAO matchDAO;
	// 任务需要匹配对应的监测指标、预警指标
	private int workMatch;
	private Match ma;
	// 规定格式
	private SimpleDateFormat sdf;

	// 登录验证
	public int loginValidate(String name, String pass) throws Exception {
		try {
			User user = userDAO.findByNAndP(name, pass);
			if (user != null) {
				return user.getId();
			}
			return -1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// 注册时的用户名可用否
	public boolean validateName(String name) throws Exception {
		try {
			User u = userDAO.findByName(name);
			if (u == null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public int addUser(String name, String pass, String email, int level)
			throws Exception {
		try {
			User u = new User();
			u.setUsername(name);
			u.setUserpass(pass);
			u.setEmail(email);
			u.setLevel(level);
			userDAO.save(u);
			// 直接获取用户id
			return u.getId();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List getAllKinds() throws Exception {
		try {
			return kindDAO.findAll();
		} catch (Exception e) {
			throw new Exception("getAllKinds 出错。");
		}
	}

	public List getAllIndicators() throws Exception {
		try {
			List result = new ArrayList();
			List l = indiDAO.findAll();
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

	public IndicatorBean getIndicator(int id) throws Exception {
		try {
			Indicator indi = indiDAO.findById(id);
			IndicatorBean ib = new IndicatorBean();
			initIndi(ib, indi);
			return ib;
		} catch (Exception e) {
			throw new Exception("getIndicator 出错。");
		}
	}

	public List getAllWarncontents() throws Exception {
		try {
			List result = new ArrayList();
			List l = warncontentDAO.findAll();
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

	public WarncontentBean getWarncontent(int id) throws Exception {
		try {
			WarncontentBean wcb = new WarncontentBean();
			initWarncontent(wcb, warncontentDAO.findById(id));
			return wcb;
		} catch (Exception e) {
			throw new Exception("getWarncontent  出错。");
		}
	}

	public List getAllWorks() throws Exception {
		try {
			return workDAO.findAll();
		} catch (Exception e) {
			throw new Exception("getAllWorks  出错。");
		}
	}

	public List getAvailWorks() throws Exception {
		try {
			return workDAO.findByState(1);
		} catch (Exception e) {
			throw new Exception("getAvailWorks 出错。");
		}
	}

	public WorkBean getWork(int id) throws Exception {
		try {
			Work w = workDAO.findById(id);
			WorkBean wb = new WorkBean();
			initWork(wb, w);
			return wb;
		} catch (Exception e) {
			throw new Exception("service getWork 出错。");
		}
	}

	// 为了匹配多条预警内容
	public List getWConsByMatch(int match) throws Exception {
		try {
			List result = new ArrayList();
			List indiWarn = iwDAO.findByMatch(match);

			for (int i = 0; i < indiWarn.size(); i++) {
				IndiWarn iw = (IndiWarn) indiWarn.get(i);
				int wcId = iw.getWarnId();
				Warncontent wc = warncontentDAO.findById(wcId);// 第二次去数据库查，效率问题。

				WarncontentBean wcb = new WarncontentBean();

				initWarncontent(wcb, wc);

				result.add(wcb);
			}
			return result;
		} catch (Exception e) {
			throw new Exception("getWConsByMatch  出错。");
		}
	}

	public List getAllWarnlevels() throws Exception {
		try {
			return warnlevelDAO.findAll();
		} catch (Exception e) {
			throw new Exception("getAllWarnlevels  出错。");
		}
	}

	public List<IndiWarn> getIndiWarn(int workMatch) throws Exception {
		try {
			return iwDAO.findByMatch(workMatch);
		} catch (Exception e) {
			throw new Exception("getIndiWarn  出错。");
		}
	}

	public List getAvailWtodos() throws Exception {
		try {
			List result = new ArrayList();
			List l = warntodoDAO.findByState(1);
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

	public List getDoneWtodos() throws Exception {
		try {
			List result = new ArrayList();
			List l = warntodoDAO.findByState(-1);
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

	public WtodoBean getWtodo(int id) throws Exception {
		try {
			Warntodo wtd = warntodoDAO.findById(id);
			WtodoBean wtdb = new WtodoBean();
			initWtodo(wtdb, wtd);
			return wtdb;
		} catch (Exception e) {
			throw new Exception("	getWtodo  出错。");
		}
	}

	// 获取预警数
	public Map getWLevCount() throws Exception {
		try {
			Map<String, Integer> map = new HashMap();
			List<Warnlevel> wlList = warnlevelDAO.findAll();
			for (int i = 0; i < (wlList.size() - 1); i++) {
				Warnlevel wl = (Warnlevel) wlList.get(i);
				map.put(wl.getLevel(), wl.getCount());
			}
			return map;
		} catch (Exception e) {
			throw new Exception("getWLevCount  出错。");
		}
	}

	public void addIndi(String name, String method, int period, String content,
			String note, int kindId) throws Exception {
		try {
			Indicator indi = new Indicator();
			Kind kind = kindDAO.findById(kindId);

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

			indiDAO.save(indi);
		} catch (Exception e) {
			throw new Exception("addIndi  出错。");
		}
	}

	// 删除Indicator
	@Override
	public void deleteIndi(String rowFlag) throws Exception {
		try {
			indiDAO.delete(rowFlag);
		} catch (Exception e) {
			throw new Exception("service deleteIndi  出错。");
		}
	}

	// 查询Indicaotr
	@Override
	public List searchIndi(String str) throws Exception {
		try {
			List result = new ArrayList();
			List l = indiDAO.search(str);
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

	// 删除Warncontent
	@Override
	public void deleteWCon(String rowFlag) throws Exception {
		try {
			warncontentDAO.delete(rowFlag);
		} catch (Exception e) {
			throw new Exception("service deleteWCon  出错。");
		}
	}

	public void addWarncontent(String content, int warnlevelId)
			throws Exception {
		try {
			Warnlevel level = warnlevelDAO.findById(warnlevelId);
			Warncontent warncon = new Warncontent();

			warncon.setContent(content);
			warncon.setWarnlevel(level);

			warncontentDAO.save(warncon);
		} catch (Exception e) {
			throw new Exception("addWarncontent  出错。");
		}
	}

	public void addIndiWarn(int indiId, Integer[] id) throws Exception {
		try {
			for (int i = 0; i < id.length; i++) {
				IndiWarn iw = new IndiWarn();

				iw.setIndiId(indiId);
				iw.setWarnId(id[i]);
				iw.setWorkMatch(workMatch);
				iwDAO.save(iw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pubWork(int indiId, Integer[] id) throws Exception {
		try {
			setMatch();
			addIndiWarn(indiId, id);

			Work w = new Work();
			Indicator indi = indiDAO.findById(indiId);

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

			workDAO.save(w);

			workMatch++;
			ma.setWorkMatch(workMatch);
			matchDAO.update(ma);
		} catch (Exception e) {
			throw new Exception("pubWork  出错。");
		}
	}

	public void updateWork(int id) throws Exception {
		try {
			Work w = workDAO.findById(id);
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
			workDAO.update(w);
		} catch (Exception e) {
			throw new Exception("updateWork  出错。");
		}
	}

	public void createWtodo(int id, int[] wcIds) throws Exception {
		try {
			updateWork(id);

			Work w = workDAO.findById(id);
			Warntodo wtd = new Warntodo();
			wtd.setName(w.getName());
			wtd.setWork(workDAO.findById(id));
			wtd.setKind(w.getKind());

			List<Warncontent> wcons = new ArrayList();
			for (int i = 0; i < wcIds.length; i++) {
				wcons.add(warncontentDAO.findById(wcIds[i]));
			}
			String wcon = ((Warncontent) wcons.get(0)).getContent();
			for (int i = 1; i < wcons.size(); i++) {
				wcon += "\n" + ((Warncontent) wcons.get(i)).getContent();
			}

			wtd.setWarn(wcon);
			wtd.setState(1);
			warntodoDAO.save(wtd);
			plusWLevCount(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	// 预警等级数增加。
	private void plusWLevCount(int workId) throws Exception {
		try {
			int workMatch = workDAO.findById(workId).getWorkMatch();
			List iwList = iwDAO.findByMatch(workMatch);

			for (int i = 0; i < iwList.size(); i++) {
				IndiWarn iw = (IndiWarn) iwList.get(i);
				// Warnlevel wl = iw.getWarncontent().getWarnlevel();
				int warncontentId = iw.getWarnId();
				Warnlevel wl = warncontentDAO.findById(warncontentId)
						.getWarnlevel();
				int count = wl.getCount();
				count++;
				wl.setCount(count);
				warnlevelDAO.update(wl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 预警等级数减少。
	private void reduceWLevCount(int wtdId) throws Exception {
		try {
			Warntodo wtd = warntodoDAO.findById(wtdId);
			int workMatch = wtd.getWork().getWorkMatch();

			List iwList = iwDAO.findByMatch(workMatch);

			for (int i = 0; i < iwList.size(); i++) {
				IndiWarn iw = (IndiWarn) iwList.get(i);
				// Warnlevel wl = iw.getWarncontent().getWarnlevel();
				int warnId = iw.getWarnId();
				Warnlevel wl = warncontentDAO.findById(warnId).getWarnlevel();
				int count = wl.getCount();
				if (count > 0) {
					count--;
				} else {
					count = 0;
				}
				wl.setCount(count);
				warnlevelDAO.update(wl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doneWtodo(int id, String content) throws Exception {
		try {
			Warntodo wtd = warntodoDAO.findById(id);
			wtd.setContent(content);
			wtd.setState(-1);
			warntodoDAO.update(wtd);
			reduceWLevCount(id);
		} catch (Exception e) {
			throw new Exception("doneWtodo  出错。");
		}
	}

	public void updateWorkState() throws Exception {
		try {
			List workList = workDAO.findByState(-1);
			for (int i = 0; i < workList.size(); i++) {
				Work w = (Work) workList.get(i);

				sdf = new SimpleDateFormat("yyyyMMdd");
				String doDate = sdf.format(w.getDoDate());
				String current = sdf.format(new Date());
				if (doDate.equals(current)) {
					w.setState(1);
					workDAO.update(w);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initIndi(IndicatorBean ib, Indicator i) throws Exception {
		ib.setId(i.getId());
		ib.setName(i.getName());
		ib.setKind(i.getKind().getName());
		ib.setMethod(i.getMethod());
		ib.setContent(i.getContent());
		ib.setNote(i.getNote());
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

	private void initWarncontent(WarncontentBean wcb, Warncontent wc)
			throws Exception {
		wcb.setId(wc.getId());
		wcb.setContent(wc.getContent());
		wcb.setLevel(wc.getWarnlevel().getLevel());
	}

	private void initWtodo(WtodoBean wtdb, Warntodo wtd) throws Exception {
		wtdb.setId(wtd.getId());
		wtdb.setWorkid(wtd.getWork().getId());
		wtdb.setName(wtd.getName());
		wtdb.setKind(wtd.getKind());
		wtdb.setWarn(wtd.getWarn());
	}

	private void setMatch() {
		ma = new Match();
		List l = matchDAO.findAll();
		if (l.size() == 0) {
			ma.setWorkMatch(1);
			matchDAO.save(ma);
			List ll = matchDAO.findAll();
			ma = (Match) ll.get(0);
		} else {
			ma = (Match) l.get(0);
		}
		workMatch = ma.getWorkMatch();
	}

	public void setUserDAO(UserDAO u) {
		this.userDAO = u;
	}

	public void setIndiDAO(IndicatorDAO indiDAO) {
		this.indiDAO = indiDAO;
	}

	public void setKindDAO(KindDAO kindDAO) {
		this.kindDAO = kindDAO;
	}

	public void setIwDAO(IndiWarnDAO iwDAO) {
		this.iwDAO = iwDAO;
	}

	public void setWarncontentDAO(WarncontentDAO warncontentDAO) {
		this.warncontentDAO = warncontentDAO;
	}

	public void setWarnlevelDAO(WarnlevelDAO warnlevelDAO) {
		this.warnlevelDAO = warnlevelDAO;
	}

	public void setWorkDAO(WorkDAO workDAO) {
		this.workDAO = workDAO;
	}

	public void setMatchDAO(MatchDAO m) {
		this.matchDAO = m;
	}

	public void setWarntodoDAO(WarntodoDAO wDAO) {
		this.warntodoDAO = wDAO;
	}
}

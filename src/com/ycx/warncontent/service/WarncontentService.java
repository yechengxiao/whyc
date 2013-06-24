package com.ycx.warncontent.service;

import java.util.List;

import com.ycx.warncontent.WarncontentBean;
import com.ycx.warncontent.dao.WarncontentDao;
import com.ycx.warncontent.entity.Warncontent;
import com.ycx.warnlevel.dao.WarnlevelDao;
import com.ycx.warnlevel.entity.Warnlevel;

public interface WarncontentService {
	WarncontentBean getWarncontent(int id) throws Exception;

	List getAllWarncontents() throws Exception;

	// 新增
	void addWarncontent(String content, int warnlevelId) throws Exception;

	// 删除Warncontent
	void deleteWCon(String rowFlag) throws Exception;

	List getWConsByMatch(int match) throws Exception;

	public abstract List search(String content);

}

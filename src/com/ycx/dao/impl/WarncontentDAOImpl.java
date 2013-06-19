package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.WarncontentDAO;
import com.ycx.model.Warncontent;

public class WarncontentDAOImpl extends HibernateDaoSupport implements
		WarncontentDAO {
	private static final Log log = LogFactory.getLog(WarncontentDAOImpl.class);

	protected void initDao() {
	}

	public void save(Warncontent instance) {
		System.out.println("------------WarncontentDAOImpl "+instance.getContent());
		log.debug("saving Warncontent instance");
		try {
			getHibernateTemplate().save(instance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update() {

	}

	// 多选框删除
	@Override
	public void delete(String rowFlag) {
		// rowFlag形式-->33|34
		String hqlDel = "delete from Warncontent as wcon where ";
		String[] rowFlags = rowFlag.split("\\|");

		for (int i = 0; i < rowFlags.length; i++) {
			String temp = rowFlags[i];
			hqlDel += "(wcon.id='" + temp + "') or";
		}
		// 截掉末尾的 or
		hqlDel = hqlDel.substring(0, hqlDel.length() - 2);
		System.out.println("WarncontentDAOImpl-->hqlDel:" + hqlDel);
		
		// 批量删除
		int rownum = getHibernateTemplate().bulkUpdate(hqlDel);
	}

	public Warncontent findById(java.lang.Integer id) {
		log.debug("getting Warncontent instance with id: " + id);
		try {
			Warncontent instance = (Warncontent) getHibernateTemplate().get(
					Warncontent.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Warncontent instances");
		try {
			String queryString = "from Warncontent";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
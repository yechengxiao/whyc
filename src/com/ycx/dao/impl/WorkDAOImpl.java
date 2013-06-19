package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.WorkDAO;
import com.ycx.model.Work;

public class WorkDAOImpl extends HibernateDaoSupport implements WorkDAO {
	private static final Log log = LogFactory.getLog(WorkDAOImpl.class);

	protected void initDao() {
	}

	public void save(Work transientInstance) {
		log.debug("saving Work instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Work w) {
		getHibernateTemplate().saveOrUpdate(w);
	}

	public void delete(int id) {

	}

	public void delete(Work persistentInstance) {
		log.debug("deleting Work instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Work findById(java.lang.Integer id) {
		log.debug("getting Work instance with id: " + id);
		try {
			Work instance = (Work) getHibernateTemplate().get(Work.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByState(int state) {
		String queryString = "from Work as w where w.state=?";
		return getHibernateTemplate().find(queryString, state);
	}

	public List findAll() {
		log.debug("finding all Work instances");
		try {
			String queryString = "from Work";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
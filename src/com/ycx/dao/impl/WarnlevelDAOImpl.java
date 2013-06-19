package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.WarnlevelDAO;
import com.ycx.model.Warnlevel;

public class WarnlevelDAOImpl extends HibernateDaoSupport implements
		WarnlevelDAO {
	private static final Log log = LogFactory.getLog(WarnlevelDAOImpl.class);

	protected void initDao() {
	}

	public void save(Warnlevel transientInstance) {
		log.debug("saving Warnlevel instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Warnlevel wl) {
		getHibernateTemplate().saveOrUpdate(wl);
	}

	public void delete(Warnlevel persistentInstance) {
		log.debug("deleting Warnlevel instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Warnlevel findById(java.lang.Integer id) {
		log.debug("getting Warnlevel instance with id: " + id);
		try {
			Warnlevel instance = (Warnlevel) getHibernateTemplate().get(
					Warnlevel.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Warnlevel instances");
		try {
			String queryString = "from Warnlevel";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
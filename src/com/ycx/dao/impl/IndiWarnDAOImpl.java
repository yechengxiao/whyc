package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.IndiWarnDao;
import com.ycx.model.IndiWarn;

public class IndiWarnDaoImpl extends HibernateDaoSupport implements IndiWarnDao {
	private static final Log log = LogFactory.getLog(IndiWarnDaoImpl.class);

	protected void initDao() {
	}

	public void save(IndiWarn transientInstance) {
		log.debug("saving IndiWarn instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(IndiWarn iw) {
		getHibernateTemplate().saveOrUpdate(iw);
	}

	public void delete(int id) {

	}

	public void delete(IndiWarn persistentInstance) {
		log.debug("deleting IndiWarn instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public IndiWarn findById(java.lang.Integer id) {
		log.debug("getting IndiWarn instance with id: " + id);
		try {
			return (IndiWarn) getHibernateTemplate().get(IndiWarn.class, id);
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByIndiId(int id) {
		String queryString = "from IndiWarn as iw where iw.indicator.id=?";
		return getHibernateTemplate().find(queryString, id);
	}

	public List findByWarnId(int id) {
		String queryString = "from IndiWarn as iw where iw.warncontent.id=?";
		return getHibernateTemplate().find(queryString, id);
	}

	public List findByMatch(int match) {
		String queryString = "from IndiWarn as iw where workMatch=?";
		return getHibernateTemplate().find(queryString, match);
	}

	public List findAll() {
		log.debug("finding all IndiWarn instances");
		try {
			String queryString = "from IndiWarn";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
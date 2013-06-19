package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.KindDAO;
import com.ycx.model.Kind;

public class KindDAOImpl extends HibernateDaoSupport implements KindDAO {
	private static final Log log = LogFactory.getLog(KindDAOImpl.class);

	protected void initDao() {
	}

	public void save(Kind transientInstance) {
		log.debug("saving Kind instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Kind persistentInstance) {
		log.debug("deleting Kind instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Kind findById(java.lang.Integer id) {
		log.debug("getting Kind instance with id: " + id);
		try {
			Kind instance = (Kind) getHibernateTemplate().get(Kind.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Kind instances");
		try {
			String queryString = "from Kind";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
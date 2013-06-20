package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.MatchDao;
import com.ycx.model.Match;

public class MatchDaoImpl extends HibernateDaoSupport implements MatchDao {
	private static final Log log = LogFactory.getLog(MatchDaoImpl.class);

	protected void initDao() {
	}

	public void save(Match transientInstance) {
		log.debug("saving Match instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Match m) {
		log.debug("update Match");
		getHibernateTemplate().saveOrUpdate(m);
	}

	public void delete(Match persistentInstance) {
		log.debug("deleting Match instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Match instances");
		try {
			String queryString = "from Match";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
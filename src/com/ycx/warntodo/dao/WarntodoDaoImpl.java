package com.ycx.warntodo.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.warntodo.entity.Warntodo;


public class WarntodoDaoImpl extends HibernateDaoSupport implements WarntodoDao {
	private static final Log log = LogFactory.getLog(WarntodoDaoImpl.class);

	protected void initDao() {
	}

	public void save(Warntodo transientInstance) {
		log.debug("saving Warntodo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Warntodo w) {
		getHibernateTemplate().saveOrUpdate(w);
	}

	public void delete(Warntodo persistentInstance) {
		log.debug("deleting Warntodo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Warntodo findById(java.lang.Integer id) {
		log.debug("getting Warntodo instance with id: " + id);
		try {
			Warntodo instance = (Warntodo) getHibernateTemplate().get(
					Warntodo.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByState(int state) {
		String queryString = "from Warntodo as wtd where wtd.state=?";
		return getHibernateTemplate().find(queryString, state);
	}

	public List findAll() {
		log.debug("finding all Warntodo instances");
		try {
			String queryString = "from Warntodo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
package com.ycx.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.WarnstodoDAO;
import com.ycx.model.Warnstodo;

public class WarnstodoDAOImpl extends HibernateDaoSupport implements
		WarnstodoDAO {
	private static final Log log = LogFactory.getLog(WarnstodoDAOImpl.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Warnstodo transientInstance) {
		log.debug("saving Warnstodo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Warnstodo persistentInstance) {
		log.debug("deleting Warnstodo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Warnstodo findById(java.lang.Integer id) {
		log.debug("getting Warnstodo instance with id: " + id);
		try {
			Warnstodo instance = (Warnstodo) getHibernateTemplate().get(
					Warnstodo.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Warnstodo instance) {
		log.debug("finding Warnstodo instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Warnstodo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Warnstodo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Warnstodo instances");
		try {
			String queryString = "from Warnstodo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Warnstodo merge(Warnstodo detachedInstance) {
		log.debug("merging Warnstodo instance");
		try {
			Warnstodo result = (Warnstodo) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Warnstodo instance) {
		log.debug("attaching dirty Warnstodo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Warnstodo instance) {
		log.debug("attaching clean Warnstodo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WarnstodoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WarnstodoDAO) ctx.getBean("WarnstodoDAO");
	}
}
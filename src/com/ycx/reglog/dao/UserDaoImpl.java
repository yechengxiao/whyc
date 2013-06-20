package com.ycx.reglog.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.reglog.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	private static final Log log = LogFactory.getLog(UserDaoImpl.class);

	protected void initDao() {
	}

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(User u) {

	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getHibernateTemplate().get(User.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public User findByName(String name) {
		String query = "from User as u where u.username=?";
		List l = getHibernateTemplate().find(query, name);
		if (l != null && l.size() >= 1) {
			return (User) l.get(0);
		}
		return null;
	}

	public User findByNAndP(String name, String pass) {
		String[] info = { name, pass };
		String queryString = "from User as u where u.username=? and u.userpass=?";
		List l = getHibernateTemplate().find(queryString, info);
		if (l != null && l.size() >= 1) {
			return (User) l.get(0);
		}
		return null;
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
package com.ycx.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ycx.dao.IndicatorDAO;
import com.ycx.model.Indicator;

public class IndicatorDAOImpl extends HibernateDaoSupport implements
		IndicatorDAO {
	private static final Log log = LogFactory.getLog(IndicatorDAOImpl.class);

	protected void initDao() {
	}

	public void save(Indicator transientInstance) {
		log.debug("saving Indicator instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void update(Indicator indi) {
		getHibernateTemplate().saveOrUpdate(indi);
	}

	// 多选框删除
	@Override
	public void delete(String rowFlag) {
		// rowFlag形式-->33|34
		String hqlDel = "delete from Indicator as indi where ";
		String[] rowFlags = rowFlag.split("\\|");

		for (int i = 0; i < rowFlags.length; i++) {
			String temp = rowFlags[i];
			hqlDel += "(indi.id='" + temp + "') or";
		}
		// 截掉末尾的 or
		hqlDel = hqlDel.substring(0, hqlDel.length() - 2);
		System.out.println("IndicatorDAOImpl-->hqlDel:" + hqlDel);

		// 批量删除
		getHibernateTemplate().bulkUpdate(hqlDel);
	}

	// 通过id查找
	public Indicator findById(java.lang.Integer id) {
		log.debug("getting Indicator instance with id: " + id);
		try {
			Indicator instance = (Indicator) getHibernateTemplate().get(
					Indicator.class, id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByState() {
		String queryString = "from Indicator as i where i.state=1";
		return getHibernateTemplate().find(queryString);
	}

	public List findByState(int state) {
		String queryString = "from Indicator as i where i.state=?";
		return getHibernateTemplate().find(queryString, state);
	}

	public List findAll() {
		log.debug("finding all Indicator instances");
		try {
			String queryString = "from Indicator";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	// 搜索
	@Override
	public List search(String name) {
		try {
			// Hibernate query
			// Srping ?
			StringBuffer queryBuf = new StringBuffer();
			queryBuf.append("from Indicator as i");
			String con = "";

			final String n = new String(name == null ? "" : name.trim());

			if (!n.equals("")) {// 添加查询条件。若为空，则不要添加
				con += "i.name like :name";
			}
			if (!con.trim().equals("")) {// 若为空，则不要添加
				queryBuf.append(" where " + con);
			}

			final String query = new String(queryBuf);

			List list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query q = session.createQuery(query);
							if (!n.equals("")) {
								q.setString("name", "%" + n + "%");
							}
							return q.list();
						}
					});
			return list;
		} catch (DataAccessException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
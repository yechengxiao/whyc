package com.ycx.warncontent.dao;

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

import com.ycx.warncontent.entity.Warncontent;

public class WarncontentDaoImpl extends HibernateDaoSupport implements
		WarncontentDao {
	private static final Log log = LogFactory.getLog(WarncontentDaoImpl.class);

	protected void initDao() {
	}

	public void save(Warncontent instance) {
		System.out.println("------------WarncontentDAOImpl "
				+ instance.getContent());
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

	// 搜索
	@Override
	public List search(String content) {
		try {
			
			System.out.println(content);
			
			StringBuffer queryBuf = new StringBuffer();
			queryBuf.append("from Warncontent w ");
			String con = "";

			final String n = new String(content == null ? "" : content.trim());

			if (!n.equals("")) {
				con += "w.content like :content";
			}
			if (!con.trim().equals("")) {
				queryBuf.append(" where " + con);
			}

			final String query = new String(queryBuf);

			List list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query q = session.createQuery(query);
							if (!n.equals("")) {
								q.setString("content", "%" + n + "%");
							}
							return q.list();
						}
					});
			return list;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
package com.wlmtxt.User.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.User.dao.UserDao;
import com.wlmtxt.domain.DO.wlmtxt_user;

import util.md5;

public class UserDaoImpl implements UserDao {
	
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public wlmtxt_user findUser(wlmtxt_user accpet_user) {
		String hql = "from wlmtxt_user where user_mail='"+accpet_user.getUser_mail()+"' and user_password='"+md5.GetMD5Code(accpet_user.getUser_password())+"'";
		Query query = getSession().createQuery(hql);
		wlmtxt_user user = (wlmtxt_user)query.uniqueResult();
		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public String saveUser(wlmtxt_user accpet_user) {
		try {
			getSession().save(accpet_user);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

	@Override
	public wlmtxt_user mailRegisted(wlmtxt_user accpet_user) {
		String hql = "from wlmtxt_user where user_mail='"+accpet_user.getUser_mail()+"'";
		Query query = getSession().createQuery(hql);
		wlmtxt_user user = (wlmtxt_user) query.uniqueResult();
		return user;
	}

	@Override
	public String modifyPersonalData(wlmtxt_user accpet_user) {
		try {
			getSession().saveOrUpdate(accpet_user);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

	@Override
	public String modifyPassword(wlmtxt_user user) {
		try {
			getSession().saveOrUpdate(user);
			return "1";
		} catch (Exception e) {
			return "2";
		}
	}

}

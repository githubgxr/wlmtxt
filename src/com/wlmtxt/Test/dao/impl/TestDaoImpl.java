package com.wlmtxt.Test.dao.impl;

import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.domain.DO.Test;
import com.wlmtxt.Test.dao.TestDao;

public class TestDaoImpl implements TestDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
//		return this.sessionFactory.openSession();
	}

	public Test test(Test t) {
		Session session = getSession();
		String hql = "select tt from Test tt where tt.id='"+1+"'";
		Query query = session.createQuery(hql);
		Test new_t = (Test) query.uniqueResult();
		return new_t;
	}

}

package com.wlmtxt.Admin.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.*;

import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_user;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean adminLogin(wlmtxt_admin admin) {
		Session session=getSession();
		String hql = "from wlmtxt_admin where admin_username='" + admin.getAdmin_username() + "' and admin_password='"
				+ admin.getAdmin_password() + "'";
		Query query = session.createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		if(new_admin!=null) {
			return true;
		}
		return false;
	}

	@Override
	public wlmtxt_admin getAdmin(wlmtxt_admin admin) {
		Session session=getSession();
		String hql = "from wlmtxt_admin where admin_id='"+admin.getAdmin_id()+"'";
		Query query = session.createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		return new_admin;
	}

	@Override
	public void saveAdmin(wlmtxt_admin admin) {
		try {
			//id和是否为超级管理员的赋值在service层
			Session session=getSession();
			session.saveOrUpdate(admin);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAdmin(wlmtxt_admin admin) {
		try {
			Session session=getSession();
			session.delete(admin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateAdmin(wlmtxt_admin admin) {
		try {
			Session session=getSession();
			session.update(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<wlmtxt_admin> listAdmin() {
		Session session=getSession();
		String hql="from wlmtxt_admin";
		Query query=session.createQuery(hql);
		List<wlmtxt_admin> admin_list=query.list();
		return admin_list;
	}

}

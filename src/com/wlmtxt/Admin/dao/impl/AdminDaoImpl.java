package com.wlmtxt.Admin.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.*;

import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.domain.DO.wlmtxt_admin;

public class AdminDaoImpl implements AdminDao {
	

private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public wlmtxt_admin getAdmin(wlmtxt_admin admin) {
		String hql = "from wlmtxt_admin where admin.username='"+admin.getAdmin_username()+"' and admin.password='"+admin.getAdmin_password()+"'";
		Query query = getSession().createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		return new_admin;
	}

	@Override
	public void saveAdmin(wlmtxt_admin admin) {
		try {
			admin.setAdmin_id(UUID.randomUUID().toString());
			admin.setAdmin_admin("2");
//			admin.setAdmin_gmt_create((new.java.util.Date().toStrng));
			getSession().saveOrUpdate(admin);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void removeAdmin(wlmtxt_admin admin) {
		try {
			getSession().delete(admin);;			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(wlmtxt_admin admin) {
		try {
			getSession().update(admin);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		try {
//			admin.setAdmin_gmt_modified();
			getSession().update(admin);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<wlmtxt_admin> listAdmin() {
		String hql="";
		return null;
	}

}

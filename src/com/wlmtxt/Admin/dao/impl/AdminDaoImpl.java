package com.wlmtxt.Admin.dao.impl;

import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.*;

import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
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
	public wlmtxt_admin adminLogin(wlmtxt_admin admin) {
		Session session=getSession();
		String hql = "from wlmtxt_admin where admin_username='" + admin.getAdmin_username() + "' and admin_password='"
				+ admin.getAdmin_password() + "'";
		Query query = session.createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		return new_admin;
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

	@Override
	public boolean addFirst_menu(wlmtxt_first_menu first_menu) {
		Session session=getSession();
		session.save(first_menu);
		session.flush();
		return true;
	}

	@Override
	public List<wlmtxt_first_menu> listFirst_menuAll() {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu";
		Query query = session.createQuery(hql);
		List<wlmtxt_first_menu> fristMenuList = query.list();
		return fristMenuList;
	}

	@Override
	public List<wlmtxt_second_menu> listCategoryByFather(String first_menu_id) {
		Session session = getSession();
		String hql = "from wlmtxt_second_menu where second_menu_first_menu_id='"+first_menu_id+"'";
		Query query = session.createQuery(hql);
		List<wlmtxt_second_menu> secondMenuList = query.list();
		return secondMenuList;
	}

	@Override
	public List<wlmtxt_first_menu> listCategory() {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu";
		Query query = session.createQuery(hql);
		List<wlmtxt_first_menu> fristMenuList = query.list();
		return fristMenuList;
	}

	@Override
	public boolean addSecond_menu(wlmtxt_second_menu second_menu) {
		Session session=getSession();
		session.save(second_menu);
		session.flush();
		return true;
	}

	@Override
	public List<wlmtxt_second_menu> getSecond_menuByFirstId(String first_menu_id) {
		Session session = getSession();
	    String hql="from wlmtxt_second_menu where second_menu_first_menu_id='"+first_menu_id+"'";
	    Query query = session.createQuery(hql);
	    List<wlmtxt_second_menu> second_menuList = query.list();
	    return second_menuList;
	}

	@Override
	public void deleteSecond_menu(String second_menu_id) {
		Session session = getSession();
		System.out.println("dao"+second_menu_id);
		String hql="delete  from wlmtxt_second_menu where second_menu_id='"+second_menu_id+"'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void deleteFirst_munu(String first_menu_id) {
	Session session = getSession();
	String hql = "delete from wlmtxt_first_menu where first_menu_id='"+first_menu_id+"'";
	Query query = session.createQuery(hql);
	query.executeUpdate();	
	}

	@Override
	public boolean updateFirst_menu(wlmtxt_first_menu first_menu) {
		Session session = getSession();
		session.update(first_menu);
		session.flush();
		return true;
	}

	@Override
	public boolean updateSecond_menu(wlmtxt_second_menu second_menu) {
		Session session = getSession();
		session.update(second_menu);
		session.flush();
		return true;
		
	}

	@Override
	public wlmtxt_first_menu getFirst_menuById(String first_menu_id) {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu where first_menu_id='"+first_menu_id+"'";
		Query query = session.createQuery(hql);
		wlmtxt_first_menu  first_menu = (wlmtxt_first_menu) query.uniqueResult();
		return first_menu;
	}

	@Override
	public wlmtxt_second_menu getSecondById(String second_menu_id) {
		Session session = getSession();
		String hql="from wlmtxt_second_menu where second_menu_id='"+second_menu_id+"'";
		Query query = session.createQuery(hql);
		wlmtxt_second_menu second_menu = (wlmtxt_second_menu) query.uniqueResult();
		return second_menu;
	}
}

package com.wlmtxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Admin.dao.AdminUserDao;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.VO.UserVO;

public class AdminUserDaoImpl implements AdminUserDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public wlmtxt_user getUserById(String user_id) {
		Session session = getSession();
		String hql = "from wlmtxt_user where user_id='"+user_id+"'";
		Query query= session.createQuery(hql);
		wlmtxt_user user = (wlmtxt_user) query.uniqueResult();
		return user;
	}

	@Override
	public void getUserListByPage(UserVO userVO) {
		Session session = getSession();
		List<wlmtxt_user> userList = new ArrayList<wlmtxt_user>();
		String hql = "from wlmtxt_user where 1=1 ";
		if (userVO.getUser_username()!= null
				&& userVO.getUser_username().trim().length() > 0)
			hql = hql + " and user_username like '%" + userVO.getUser_username() + "%'";
		if (userVO.getUser_mail()!= null
				&& userVO.getUser_mail().trim().length() > 0)
			hql = hql + " and user_mail like '%" + userVO.getUser_mail() + "%'";
		hql = hql + " order by user_gmt_modified desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(userVO.getCurrPage() - 1) * userVO.getPageSize());
		query.setMaxResults(userVO.getPageSize());
		userList = query.list();
		userVO.setWlmtxt_userList(userList);
		session.clear();
		
		
	}

	@Override
	public int getCountUserList(UserVO userVO) {
		Session session = getSession();
		String hql = "select count(*) from wlmtxt_user where 1=1";
		if (userVO.getUser_username()!= null
				&& userVO.getUser_username().trim().length() > 0)
			hql = hql + " and user_username like '%" + userVO.getUser_username() + "%'";
		if (userVO.getUser_mail()!= null
				&& userVO.getUser_mail().trim().length() > 0)
			hql = hql + " and user_mail like '%" + userVO.getUser_mail() + "%'";
			long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void deleteUser(String user_id) {
		Session session = getSession();
		String hql = "delete from wlmtxt_user where user_id='"+user_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public boolean updateUser_authority(wlmtxt_user old_user) {
		try {
			Session session = getSession();
			session.update(old_user);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}

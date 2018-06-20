package com.wlmtxt.User.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.User.dao.UserDao;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;

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

	@Override
	public String saveFollowUser(wlmtxt_follow follow) {
		try {
			getSession().save(follow);
			return "1";
		} catch (Exception e) {
			return "2";
		}
		
	}

	/**
	 * 返回我上传的所有-审核通过-未被删除-的作品
	 * 
	 * 
	 */
	@Override
	public List<wlmtxt_works> listMyWorks(String user_id) {
		String hql = "from wlmtxt_works where works_user_id='"+user_id+"' and works_passed='1' and works_deleted='2'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> listWorks = query.list();
		return listWorks;
	}

	/**
	 * 返回我上传的所有-审核通过-未被删除-的作品涉及的关键词
	 */
	@Override
	public List<wlmtxt_works_keyword> listMyKeyword(List<wlmtxt_works> listWorks) {
//		String hql = "from wlmtxt_works_keyword where works_keyword_works_id='"++"' and works_passed='1' and works_deleted='2'";
//		Query query = getSession().createQuery(hql);
//		List<wlmtxt_works_keyword> listWorksKeyword = query.list();
		return null;
	}

	@Override
	public wlmtxt_second_menu findSecondMenu_single_works_id(wlmtxt_works works) {
		String hql = "from wlmtxt_second_menu where second_menu_id='"+works.getWorks_second_menu_id()+"'";
		Query query = getSession().createQuery(hql);
		wlmtxt_second_menu secondMenu_by_single_id = (wlmtxt_second_menu) query.uniqueResult();
		return secondMenu_by_single_id;
	}

	@Override
	public wlmtxt_first_menu findFirstMenu_single_second_menu_id(wlmtxt_second_menu second_menu) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 通过单个作品id得到对应的作品关键词记录list
	 * @param works_keyword
	 * @return
	 */
	/*@Override
	public List<wlmtxt_works_keyword> listWorksKeyword_by_works_id(wlmtxt_works works) {
		String hql = "from wlmtxt_works_keyword where works_keyword_works_id='"+works.getWorks_id()+"'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works_keyword> listWorksKeyword_by_single_id = query.list();
		return listWorksKeyword_by_single_id;
	}*/

}

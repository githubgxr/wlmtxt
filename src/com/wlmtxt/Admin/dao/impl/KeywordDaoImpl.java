package com.wlmtxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Admin.dao.KeywordDao;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.VO.KeywordVO;

public class KeywordDaoImpl implements KeywordDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public boolean addKeyword(wlmtxt_keyword keyword) {
		try {
			Session session = getSession();
			session.save(keyword);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateKeyword(wlmtxt_keyword keyword) {
		try {
			Session session = getSession();
			session.update(keyword);
			session.flush();
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteAdmin(String keyword_id) {
		Session session = getSession();
		String hql = "delete from wlmtxt_keyword where keyword_id='"+keyword_id+"'";
		Query query =session .createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
		
	}

	@Override
	public int getCountKeywordList(KeywordVO keywordVO) {
		Session session = getSession();
		String hql = "select count(*) from wlmtxt_keyword where 1=1";
		if (keywordVO.getKeyword_name()!= null
				&& keywordVO.getKeyword_name().trim().length() > 0)
			hql = hql + " and keyword_name like '%" + keywordVO.getKeyword_name() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public wlmtxt_keyword getKeywordById(String keyword_id) {
		Session session = getSession();
		String hql = "from wlmtxt_keyword where keyword_id='"+keyword_id+"'";
		Query query= session.createQuery(hql);
		wlmtxt_keyword keyword = (wlmtxt_keyword) query.uniqueResult();
		return keyword;
	}

	@Override
	public void getKeywordListByPage(KeywordVO keywordVO) {
		Session session = getSession();
		List<wlmtxt_keyword> keywordList = new ArrayList<wlmtxt_keyword>();
		String hql = "from wlmtxt_keyword where 1=1 ";
		if (keywordVO.getKeyword_name()!= null
				&& keywordVO.getKeyword_name().trim().length() > 0)
			hql = hql + " and keyword_name like '%" + keywordVO.getKeyword_name() + "%'";
		hql = hql + " order by keyword_gmt_modified desc";
		Query query = session.createQuery(hql);	
		query.setFirstResult(
				(keywordVO.getCurrPage() - 1) * keywordVO.getPageSize());
		query.setMaxResults(keywordVO.getPageSize());
		keywordList = query.list();
		keywordVO.setWlmtxt_keywordList(keywordList);
		session.clear();
		
	}

}

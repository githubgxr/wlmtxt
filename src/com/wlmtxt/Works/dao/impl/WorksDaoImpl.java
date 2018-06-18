package com.wlmtxt.Works.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class WorksDaoImpl implements WorksDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void saveLike(wlmtxt_like like) throws Exception {
		getSession().save(like);
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenu() {
		String hql = " from wlmtxt_second_menu  ";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_second_menu> secondMenuList = query.list();
		return secondMenuList;
	}

	@Override
	public List<wlmtxt_first_menu> listFirstMenu() {
		String hql = " from wlmtxt_first_menu  ";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_first_menu> firstMenuList = query.list();
		return firstMenuList;
	}

	@Override
	public wlmtxt_like findLikeBy_user_id_And_like_works_id(String like_user_id, String like_works_id)
			throws Exception {
		String hql = "select l from wlmtxt_like l where l.like_user_id = '" + like_user_id + "' and l.like_works_id='"
				+ like_works_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_like like = (wlmtxt_like) query.uniqueResult();
		return like;
	}

	@Override
	public void removeLikeBy_user_id_And_like_works_id(String user_id, String like_works_id) throws Exception {
		String hql = "delete l from wlmtxt_like l where l.like_user_id = '" + user_id + "' and l.like_works_id='"
				+ like_works_id + "'";
		Query query = getSession().createQuery(hql);
		int i = query.executeUpdate();
		if (i > 0) {
			System.out.println("取消点赞成功");
		} else {
			System.out.println("取消点赞失败");
		}
	}

	@Override
	public wlmtxt_collect findCollectBy_user_id_And_collect_works_id(String collect_user_id, String collect_works_id)
			throws Exception {
		String hql = "from wlmtxt_collect where collect_user_id = '" + collect_user_id + "' and collect_works_id='"
				+ collect_works_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_collect collect = (wlmtxt_collect) query.uniqueResult();
		return collect;
	}

	@Override
	public void removeCollectBy_user_id_And_collect_works_id(String collect_user_id, String collect_works_id)
			throws Exception {
		String hql = "delete from wlmtxt_collect collect where collect.collect_user_id = '" + collect_user_id
				+ "' and collect.collect_works_id='" + collect_works_id + "'";
		Query query = getSession().createQuery(hql);
		int i = query.executeUpdate();
		if (i > 0) {
			System.out.println("取消收藏成功");
		} else {
			System.out.println("取消收藏失败");
		}
	}

	@Override
	public void saveWorks(wlmtxt_works accept_works) {
		getSession().save(accept_works);

	}

	@Override
	public void saveKeyword(wlmtxt_keyword newkeywords) {
		getSession().save(newkeywords);

	}

	@Override
	public void saveCollect(wlmtxt_collect new_collect) throws Exception {
		getSession().save(new_collect);
	}

	@Override
	public wlmtxt_download_history findDownloadHistoryBy_download_history_user_id_And_download_history_works_id(
			String download_history_user_id, String download_history_works_id) throws Exception {
		String hql = "from wlmtxt_download_history where download_history_user_id = '" + download_history_user_id
				+ "' and download_history_works_id='" + download_history_works_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_download_history download_history = (wlmtxt_download_history) query.uniqueResult();
		return download_history;
	}

	/*
	 * @Override public void
	 * removeDownloadHistoryBy_download_history_user_id_And_download_history_works_id(
	 * String download_history_user_id, String download_history_works_id) throws
	 * Exception { String hql =
	 * "delete from wlmtxt_download_history where download_history_user_id = '"
	 * +download_history_user_id+"' and download_history_works_id='"
	 * +download_history_works_id+"'"; Query query =
	 * getSession().createQuery(hql); int i = query.executeUpdate(); if (i > 0)
	 * { System.out.println("删除下载历史成功"); } else {
	 * System.out.println("删除下载历史失败"); } }
	 */

	@Override
	public void saveDownloadHistory(wlmtxt_download_history new_download_history) throws Exception {
		getSession().save(new_download_history);
	}

	@Override
	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
	}

}

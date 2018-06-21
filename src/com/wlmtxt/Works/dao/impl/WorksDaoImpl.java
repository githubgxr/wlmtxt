package com.wlmtxt.Works.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;
import com.wlmtxt.domain.VO.MyWorksVO;

public class WorksDaoImpl implements WorksDao {

	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addPlayHistoryByFileName(wlmtxt_play_history history) {
		getSession().save(history);
	}

	@Override
	public wlmtxt_keyword getWordByID(String works_keyword_keyword_id) {
		String hql = " from wlmtxt_keyword  where keyword_id='" + works_keyword_keyword_id
				+ "' order by keyword_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_keyword> keywordList = query.list();

		if (keywordList.size() == 0) {
			return null;
		} else {
			return keywordList.get(0);
		}
	}

	@Override
	public List<wlmtxt_works_keyword> listKeyWordByByWorksID(String worksID) {
		String hql = " from wlmtxt_works_keyword  where works_keyword_works_id='" + worksID
				+ "' order by works_keyword_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works_keyword> keywordList = query.list();
		return keywordList;
	}

	@Override
	public List<wlmtxt_play_history> listPlayHistoryByWorksID(String worksID) {
		String hql = " from wlmtxt_play_history  where download_history_works_id='" + worksID
				+ "' order by discuss_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_play_history> historyList = query.list();
		return historyList;
	}

	@Override
	public List<wlmtxt_discuss> getDiscussListByFatherID(String works_id) {
		String hql = " from wlmtxt_discuss  where discuee_father_discuss_id='" + works_id
				+ "' order by discuss_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_discuss> discussList = query.list();
		return discussList;
	}

	@Override
	public wlmtxt_works getWorksByFileName(String fileName) {
		String hql = "from wlmtxt_works where works_name = '" + fileName + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_works works = (wlmtxt_works) query.uniqueResult();
		return works;
	}

	@Override
	public wlmtxt_works getWorksByID(String works_id) {
		String hql = "from wlmtxt_works where works_id = '" + works_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_works works = (wlmtxt_works) query.uniqueResult();
		return works;
	}

	@Override
	public void saveLike(wlmtxt_like like) throws Exception {
		getSession().save(like);
	}

	@Override
	public void deleteMyWorks(String works_id) {

		String hql = "delete from wlmtxt_works  where works_id='" + works_id + "'";

		Query query = getSession().createQuery(hql);

		query.executeUpdate();

	}

	@Override
	public wlmtxt_first_menu getFirstMenuByID(String second_menu_first_menu_id) {
		String hql = "from wlmtxt_first_menu  where first_menu_id ='" + second_menu_first_menu_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_first_menu first_menu = (wlmtxt_first_menu) query.uniqueResult();
		return first_menu;
	}

	@Override
	public wlmtxt_second_menu getSecondMenuByID(String works_second_menu_id) {
		String hql = "from wlmtxt_second_menu  where second_menu_id ='" + works_second_menu_id + "' ";
		Query query = getSession().createQuery(hql);
		wlmtxt_second_menu second_menu = (wlmtxt_second_menu) query.uniqueResult();
		return second_menu;
	}

	@Override
	public int getLikeNum(String works_id) {
		String hql = "select count(*) from wlmtxt_like  where like_works_id='" + works_id + "' ";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public int getPlayNum(String works_id) {
		String hql = "select count(*) from wlmtxt_play_history  where play_history_works_id='" + works_id + "' ";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public int getPlayHistoryNumByFileName(String fileName) {
		String hql = "select count(history) from wlmtxt_works works,wlmtxt_play_history history where works.works_name='"
				+ fileName + "' and  history.play_history_works_id=works.works_id";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public int getCollectNum(String works_id) {
		String hql = "select count(*) from wlmtxt_collect  where collect_works_id='" + works_id + "' ";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public int getMyWorksTotalRecords(String user_id) {
		String hql = "select count(*) from wlmtxt_works  where works_user_id='" + user_id + "' ";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public List<wlmtxt_works> listWorksBySecondMenuID(String second_menu_id) {
		String hql = " from wlmtxt_works  where works_second_menu_id='" + second_menu_id
				+ "' and works_passed='1' order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_works> listWorksAll() {
		String hql = " from wlmtxt_works where works_passed='1'  order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_works> listMyWorksByUserIDAndNum(String user_id, MyWorksVO myWorksVO) {
		String hql = " from wlmtxt_works  where works_user_id='" + user_id
				+ "' and works_passed='1' order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((myWorksVO.getPageIndex() - 1) * myWorksVO.getPageSize());
		query.setMaxResults(myWorksVO.getPageSize());
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenuByFirstMenuID(String first_menu_id) {
		String hql = " from wlmtxt_second_menu  where second_menu_first_menu_id='" + first_menu_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_second_menu> secondMenuList = query.list();
		return secondMenuList;
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenuByFather(String second_menu_first_menu_id) {
		String hql = " from wlmtxt_second_menu  where second_menu_first_menu_id='" + second_menu_first_menu_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_second_menu> secondMenuList = query.list();
		return secondMenuList;
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
	public void removeCollect(String collect_user_id, String collect_works_id) throws Exception {
		String hql = "delete from wlmtxt_collect  where collect_user_id = '" + collect_user_id
				+ "' and collect_works_id='" + collect_works_id + "'";
		Query query = getSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void removeLike(String user_id, String like_works_id) throws Exception {
		String hql = "delete  from wlmtxt_like  where like_user_id = '" + user_id + "' and like_works_id='"
				+ like_works_id + "'";
		Query query = getSession().createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public wlmtxt_collect findCollect(String collect_user_id, String collect_works_id) throws Exception {
		String hql = "from wlmtxt_collect where collect_user_id = '" + collect_user_id + "' and collect_works_id='"
				+ collect_works_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_collect> collect = query.list();

		if (collect.size() == 0) {
			return null;
		} else {
			return collect.get(0);
		}
	}

	@Override
	public wlmtxt_like findLike(String like_user_id, String like_works_id) throws Exception {
		String hql = " from wlmtxt_like  where like_user_id = '" + like_user_id + "' and like_works_id='"
				+ like_works_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_like> like = query.list();

		if (like.size() == 0) {
			return null;
		} else {
			return like.get(0);
		}

	}

	@Override
	public void saveDiscuss(wlmtxt_discuss accpet_discuss) {
		getSession().save(accpet_discuss);

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
	public void saveWord(wlmtxt_works_keyword works_keyword) {
		getSession().save(works_keyword);
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

	@Override
	public int totalPlayNum(String works_id) {
		String hql = "from wlmtxt_play_history where play_history_works_id = '" + works_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_play_history> listPlayHistory = query.list();
		int num = listPlayHistory.size();
		return num;
	}

	@Override
	public int countCollectNum(String works_id) {
		String hql = "from wlmtxt_collect where collect_works_id = '" + works_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_collect> listCollect = query.list();
		int num = listCollect.size();
		return num;
	}

	@Override
	public int countLikeNum(String works_id) {
		String hql = "from wlmtxt_like where like_works_id = '" + works_id + "'";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_like> list = query.list();
		int num = list.size();
		return num;
	}

}

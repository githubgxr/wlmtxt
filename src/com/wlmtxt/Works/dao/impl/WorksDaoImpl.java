package com.wlmtxt.Works.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_notification;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;
import com.wlmtxt.domain.VO.MyAttentionVO;
import com.wlmtxt.domain.VO.MyWorksVO;

import util.TeamUtil;

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
	public List<wlmtxt_play_history> listPlayHistoryListByUserID(String userID) {
		String hql = " from wlmtxt_play_history  where play_history_user_id='" + userID
				+ "' order by play_history_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_play_history> historyList = query.list();
		return historyList;
	}

	@Override
	public List<wlmtxt_play_history> listPlayHistoryByWorksID(String worksID) {
		String hql = " from wlmtxt_play_history  where play_history_works_id='" + worksID
				+ "' order by play_history_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_play_history> historyList = query.list();
		return historyList;
	}

	@Override
	public List<wlmtxt_discuss> getDiscussListByFatherID(String works_id) {
		String hql = " from wlmtxt_discuss  where discuss_father_discuss_id='" + works_id
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
	public wlmtxt_discuss getDiscussByID(String discuss_id) {
		String hql = "from wlmtxt_discuss  where discuss_id ='" + discuss_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_discuss discuss = (wlmtxt_discuss) query.uniqueResult();
		return discuss;
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
	public int getDiscussNum(String works_id) {
		String hql = "select count(*) from wlmtxt_discuss  where discuss_father_discuss_id='" + works_id + "' ";
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
	public List<wlmtxt_collect> listMycollectList(String user_id) {
		String hql = " from wlmtxt_collect  where collect_user_id='" + user_id + "'  order by collect_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_collect> collectList = query.list();
		return collectList;
	}

	@Override
	public List<wlmtxt_like> listLikeByUserID(String user_id) {
		String hql = " from wlmtxt_like  where like_user_id='" + user_id + "'  order by like_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_like> likeList = query.list();
		return likeList;
	}

	@Override
	public List<wlmtxt_notification> listUserNotification(String user_id) {
		String hql = " from wlmtxt_notification  where notification_user_id='" + user_id
				+ "'  order by notification_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_notification> notificationList = query.list();
		return notificationList;
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
	public List<wlmtxt_works> listWorksByDay() {
		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";
		/*
		 * 
		 */
		/*
		 * 
		 */
		start_time = TeamUtil.getStringDay();
		Calendar calendar = new GregorianCalendar();
		java.util.Date date = TeamUtil.getDateDay();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
		calendar.setTime(date);
		calendar.add(calendar.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		stop_time = sdf.format(date);
		/*
		 * 
		 */
		String hql = " from wlmtxt_works where works_passed='1' where works_gmt_create >= '" + start_time
				+ "' and works_gmt_create < '" + stop_time + "'  order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_works> listWorksByMonth() {
		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";
		/*
		 * 
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
		String dstr = TeamUtil.getStringDay();
		java.util.Date date = null;
		try {
			date = sdf.parse(dstr);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		// 把日期往后增加一天.整数往后推,负数往前移动
		calendar.add(calendar.DATE, -1 * (Integer.parseInt(TeamUtil.getStringDay().substring(8)) - 1));
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		start_time = sdf.format(date);
		/*
		 * 
		 */
		Calendar calendar2 = new GregorianCalendar();
		java.util.Date date2 = TeamUtil.getDateDay();
		calendar2.setTime(date2);
		calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
		stop_time = sdf.format(date2);
		/*
		 * 
		 */
		String hql = " from wlmtxt_works where works_passed='1' where works_gmt_create >= '" + start_time
				+ "' and works_gmt_create < '" + stop_time + "'  order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_works> listWorksByWeek() {
		String start_time = "0000-00-00";
		String stop_time = "9999-99-99";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

		String dstr = TeamUtil.getStringDay();

		java.util.Date date = null;
		try {
			date = sdf.parse(dstr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Calendar calendar = new GregorianCalendar();

		calendar.setTime(date);

		String day = TeamUtil.getDay_Of_Week(TeamUtil.getDateDay());

		switch (day) {
		case "星期日":
			day = "1";
			break;
		case "星期一":
			day = "2";
			break;
		case "星期二":
			day = "3";
			break;
		case "星期三":
			day = "4";
			break;
		case "星期四":
			day = "5";
			break;
		case "星期五":
			day = "6";
			break;
		case "星期六":
			day = "7";
			break;
		}

		calendar.add(calendar.DATE, -1 * (Integer.parseInt(day) - 1));// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果

		start_time = sdf.format(date);
		/*
		 * 
		 */
		Calendar calendar2 = new GregorianCalendar();
		java.util.Date date2 = TeamUtil.getDateDay();
		calendar2.setTime(date2);
		calendar2.add(calendar2.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
		date2 = calendar2.getTime(); // 这个时间就是日期往后推一天的结果
		stop_time = sdf.format(date2);

		String hql = " from wlmtxt_works where works_passed='1' where works_gmt_create >= '" + start_time
				+ "' and works_gmt_create < '" + stop_time + "'  order by works_gmt_create desc";
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
	public void deletePlayHistory(String play_history_id) {
		String hql = "delete from wlmtxt_play_history  where play_history_id = '" + play_history_id + "'";
		Query query = getSession().createQuery(hql);
		query.executeUpdate();

	}

	@Override
	public void deleteAllMyHistory(String userID) {
		String hql = "delete from wlmtxt_play_history  where play_history_user_id = '" + userID + "'";
		Query query = getSession().createQuery(hql);
		query.executeUpdate();

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
	public void addNotification(wlmtxt_notification notification) {
		getSession().save(notification);

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

	@Override
	public List<wlmtxt_works> listWorksAllByUserId(String user_id) {
		String hql = "from wlmtxt_works where works_passed='1' and works_deleted='2' and works_user_id='" + user_id
				+ "' order by works_gmt_create desc";
		Query query = getSession().createQuery(hql);
		List<wlmtxt_works> worksList = query.list();
		return worksList;
	}

	@Override
	public List<wlmtxt_follow> listMyWorksByUserId(String user_id, MyAttentionVO myWorksVO) {
		String hql = " from wlmtxt_follow  where follow_active_user_id='" + user_id
				+ "' order by follow_gmt_create desc";
		Query query = getSession().createQuery(hql);
		query.setFirstResult((myWorksVO.getPageIndex() - 1) * myWorksVO.getPageSize());
		query.setMaxResults(myWorksVO.getPageSize());
		List<wlmtxt_follow> list = query.list();
		return list;
	}

	@Override
	public int getMyAttentionTotalRecords(String user_id) {
		String hql = "select count(*) from wlmtxt_follow  where follow_active_user_id='" + user_id + "' ";
		Query query = getSession().createQuery(hql);
		int count = ((Number) query.uniqueResult()).intValue();
		return count;
	}

	@Override
	public wlmtxt_follow findFollowByActiveUserId(String user_id, String follow_passive_user_id) {
		String hql = "from wlmtxt_follow where follow_active_user_id='" + follow_passive_user_id
				+ "' and follow_passie_user_id='" + user_id + "'";
		Query query = getSession().createQuery(hql);
		wlmtxt_follow result = (wlmtxt_follow) query.uniqueResult();
		return result;
	}

}

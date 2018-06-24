package com.wlmtxt.Works.dao;

import java.util.List;

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

public interface WorksDao {

	void saveLike(wlmtxt_like like);

	wlmtxt_like findLike(String like_user_id, String like_works_id);

	void removeLike(String user_id, String like_works_id);

	wlmtxt_collect findCollect(String collect_user_id, String collect_works_id);

	void removeCollect(String collect_user_id, String collect_works_id);

	void deletePlayHistory(String play_history_id);

	void saveCollect(wlmtxt_collect new_collect);

	wlmtxt_download_history findDownloadHistoryBy_download_history_user_id_And_download_history_works_id(
			String download_history_user_id, String download_history_works_id);

	// void
	// removeDownloadHistoryBy_download_history_user_id_And_download_history_works_id(String
	// download_history_user_id,
	// String download_history_works_id) ;

	void saveDownloadHistory(wlmtxt_download_history new_download_history);

	void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works);

	void saveKeyword(wlmtxt_keyword newkeywords);

	void saveWord(wlmtxt_works_keyword works_keyword);

	void saveWorks(wlmtxt_works accept_works);

	List<wlmtxt_first_menu> listFirstMenu();

	List<wlmtxt_second_menu> listSecondMenu();

	List<wlmtxt_second_menu> listSecondMenuByFirstMenuID(String first_menu_id);

	wlmtxt_second_menu getSecondMenuByID(String works_second_menu_id);

	wlmtxt_first_menu getFirstMenuByID(String second_menu_first_menu_id);

	List<wlmtxt_works> listMyWorksByUserIDAndNum(String user_id, MyWorksVO myWorksVO);

	int getMyWorksTotalRecords(String user_id);

	void deleteMyWorks(String works_id);

	void deleteAllMyHistory(String userID);

	wlmtxt_works getWorksByID(String works_id);

	wlmtxt_works getWorksByFileName(String fileName);

	List<wlmtxt_discuss> getDiscussListByFatherID(String works_id);

	void saveDiscuss(wlmtxt_discuss accpet_discuss);

	List<wlmtxt_works> listWorksAll();

	List<wlmtxt_works> listWorksBySecondMenuID(String second_menu_id);

	List<wlmtxt_second_menu> listSecondMenuByFather(String second_menu_first_menu_id);

	int totalPlayNum(String works_id);

	int countCollectNum(String works_id);

	int countLikeNum(String works_id);

	List<wlmtxt_works_keyword> listKeyWordByByWorksID(String worksID);

	wlmtxt_keyword getWordByID(String works_keyword_keyword_id);

	List<wlmtxt_works> listWorksAllByUserId(String user_id);

	int getLikeNum(String works_id);

	int getCollectNum(String works_id);

	List<wlmtxt_follow> listMyWorksByUserId(String user_id, MyAttentionVO myAttentionVO);

	int getMyAttentionTotalRecords(String user_id);

	wlmtxt_follow findFollowByActiveUserId(String user_id, String follow_passive_user_id);

	int getPlayHistoryNumByFileName(String fileName);

	int getPlayNum(String works_id);

	void addPlayHistoryByFileName(wlmtxt_play_history history);

	List<wlmtxt_play_history> listPlayHistoryByWorksID(String worksID);

	List<wlmtxt_play_history> listPlayHistoryListByUserID(String userID);

	/**
	 * 获取评论的数量
	 * 
	 * @param works_id
	 * @return
	 */
	int getDiscussNum(String works_id);

	List<wlmtxt_works> listWorksByDay();

	List<wlmtxt_works> listWorksByMonth();

	List<wlmtxt_works> listWorksByWeek();

	void addNotification(wlmtxt_notification notification);

	int totalFansNum(String user_id);

	int totalFollowingNum(String user_id);

	wlmtxt_discuss getDiscussByID(String discuss_id);

	List<wlmtxt_notification> listUserNotification(String user_id);

	List<wlmtxt_like> listLikeByUserID(String user_id);

	List<wlmtxt_discuss> listDiscussByUserID(String user_id);

	List<wlmtxt_collect> listMycollectList(String user_id);

	void deleteDisscuss(String discuss_id);

	List<wlmtxt_user> listAttentionUser(String user_id);
	// List<wlmtxt_works> listWorks10OrderHot();

	/**
	 * 根据关键词内容获取作品列表
	 * 
	 * @param keyword_name
	 * @return
	 */
	List<wlmtxt_works> listWorksByKeywordName(String keyword_name);

	int countUserPlayWorks(String userID, String worksID);

	List<wlmtxt_user> userListAll();
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */

}

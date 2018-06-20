package com.wlmtxt.Works.dao;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.MyWorksVO;

public interface WorksDao {

	void saveLike(wlmtxt_like like) throws Exception;

	wlmtxt_like findLikeBy_user_id_And_like_works_id(String like_user_id, String like_works_id) throws Exception;

	void removeLikeBy_user_id_And_like_works_id(String user_id, String like_works_id) throws Exception;

	wlmtxt_collect findCollectBy_user_id_And_collect_works_id(String collect_user_id, String collect_works_id)
			throws Exception;

	void removeCollectBy_user_id_And_collect_works_id(String collect_user_id, String collect_works_id) throws Exception;

	void saveCollect(wlmtxt_collect new_collect) throws Exception;

	wlmtxt_download_history findDownloadHistoryBy_download_history_user_id_And_download_history_works_id(
			String download_history_user_id, String download_history_works_id) throws Exception;

	// void
	// removeDownloadHistoryBy_download_history_user_id_And_download_history_works_id(String
	// download_history_user_id,
	// String download_history_works_id) throws Exception;

	void saveDownloadHistory(wlmtxt_download_history new_download_history) throws Exception;

	void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	void saveKeyword(wlmtxt_keyword newkeywords);

	void saveWorks(wlmtxt_works accept_works);

	List<wlmtxt_first_menu> listFirstMenu();

	List<wlmtxt_second_menu> listSecondMenu();

	List<wlmtxt_second_menu> listSecondMenuByFirstMenuID(String first_menu_id);

	wlmtxt_second_menu getSecondMenuByID(String works_second_menu_id);

	wlmtxt_first_menu getFirstMenuByID(String second_menu_first_menu_id);

	List<wlmtxt_works> listMyWorksByUserIDAndNum(String user_id, MyWorksVO myWorksVO);

	int getMyWorksTotalRecords(String user_id);

	void deleteMyWorks(String works_id);

	wlmtxt_works getWorksByID(String works_id);

	List<wlmtxt_discuss> getDiscussListByFatherID(String works_id);

	void saveDiscuss(wlmtxt_discuss accpet_discuss);

	List<wlmtxt_works> listWorksAll();

	List<wlmtxt_works> listWorksBySecondMenuID(String second_menu_id);

	List<wlmtxt_second_menu> listSecondMenuByFather(String second_menu_first_menu_id);

	int totalPlayNum(String works_id);

	int countCollectNum(String works_id);

	int countLikeNum(String works_id);

}

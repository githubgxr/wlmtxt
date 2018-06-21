package com.wlmtxt.User.dao;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;

public interface UserDao {

	wlmtxt_user findUser(wlmtxt_user accpet_user);

	String saveUser(wlmtxt_user accpet_user);

	wlmtxt_user mailRegisted(wlmtxt_user accpet_user);

	void update_userImg(String user_id, String fileName);

	String modifyPersonalData(wlmtxt_user accpet_user);

	String modifyPassword(wlmtxt_user user);

	String saveFollowUser(wlmtxt_follow follow);

	List<wlmtxt_works> listMyWorks(String user_id);

	List<wlmtxt_works_keyword> listMyKeyword(List<wlmtxt_works> listWorks);

	wlmtxt_second_menu findSecondMenu_single_works_id(wlmtxt_works works);

	wlmtxt_first_menu findFirstMenu_single_second_menu_id(wlmtxt_second_menu second_menu);

//	List<wlmtxt_works_keyword> listWorksKeyword_by_works_id(wlmtxt_works works);
	wlmtxt_user get_user_byID(String user_id);

	wlmtxt_follow findFollowBy_user_id(String active_user_id, String passive_user_id);

	int deleteAllMyFollow(wlmtxt_user loginUser);

	List<wlmtxt_user> listMyFans(String user_id);

	void noticeFans(wlmtxt_follow follow) throws Exception;

}

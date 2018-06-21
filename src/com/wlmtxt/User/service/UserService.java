package com.wlmtxt.User.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;

public interface UserService {

	wlmtxt_user login(wlmtxt_user accpet_user);

	String saveUser(wlmtxt_user accpet_user);

	wlmtxt_user mailRegisted(wlmtxt_user accpet_user);

	void update_userImg(String user_id, String fileName);

	String modifyPersonalData(wlmtxt_user accpet_user);

	String modifyPassword(wlmtxt_user user);

	String followUser(String user_id, wlmtxt_user loginUser);

	List<wlmtxt_first_menu> listFirstMenu(String user_id);

//	List<wlmtxt_works_keyword> listSecondOfMyWorks(String user_id);
	wlmtxt_user get_user_byID(String user_id);

	boolean isFollowedUser(String user_id, String user_id2);

	int deleteAllMyFollow(wlmtxt_user loginUser);

	void noticeAllMyFans(wlmtxt_user loginUser) throws Exception;

	void noticeMyFans(wlmtxt_user loginUser, wlmtxt_user accpet_user) throws Exception;

}

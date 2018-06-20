package com.wlmtxt.User.service;

import com.wlmtxt.domain.DO.wlmtxt_user;

public interface UserService {

	wlmtxt_user login(wlmtxt_user accpet_user);

	String saveUser(wlmtxt_user accpet_user);

	wlmtxt_user mailRegisted(wlmtxt_user accpet_user);

	void update_userImg(String user_id, String fileName);

	String modifyPersonalData(wlmtxt_user accpet_user);

	String modifyPassword(wlmtxt_user user);

	wlmtxt_user get_user_byID(String user_id);

}

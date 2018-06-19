package com.wlmtxt.User.dao;

import com.wlmtxt.domain.DO.wlmtxt_user;

public interface UserDao {

	wlmtxt_user findUser(wlmtxt_user accpet_user);

	String saveUser(wlmtxt_user accpet_user);

	wlmtxt_user mailRegisted(wlmtxt_user accpet_user);

	String modifyPersonalData(wlmtxt_user accpet_user);

	String modifyPassword(wlmtxt_user user);

}

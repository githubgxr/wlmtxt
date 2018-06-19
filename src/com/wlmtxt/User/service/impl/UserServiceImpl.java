package com.wlmtxt.User.service.impl;

import com.wlmtxt.User.dao.UserDao;
import com.wlmtxt.User.service.UserService;
import com.wlmtxt.domain.DO.wlmtxt_user;

import util.TeamUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void update_userImg(String user_id, String fileName) {

		userDao.update_userImg(user_id, fileName);

	}

	@Override
	public wlmtxt_user login(wlmtxt_user accpet_user) {
		if (accpet_user.getUser_mail() == null || accpet_user.getUser_password() == null
				|| "".equals(accpet_user.getUser_mail()) || "".equals(accpet_user.getUser_password())) {
			return null;
		} else {
			wlmtxt_user findResult = userDao.findUser(accpet_user);
			return findResult;
		}
	}

	@Override
	public String saveUser(wlmtxt_user accpet_user) {
		accpet_user.setUser_id(TeamUtil.getUuid());
		accpet_user.setUser_upload("有");
		accpet_user.setUser_discuss("有");
		accpet_user.setUser_gmt_create(TeamUtil.getStringSecond());
		accpet_user.setUser_gmt_modified(TeamUtil.getStringSecond());
		String saveResult = userDao.saveUser(accpet_user);
		return saveResult;
	}

	@Override
	public wlmtxt_user mailRegisted(wlmtxt_user accpet_user) {
		wlmtxt_user user = userDao.mailRegisted(accpet_user);
		return user;
	}

	@Override
	public String modifyPersonalData(wlmtxt_user accpet_user) {
		accpet_user.setUser_gmt_modified(TeamUtil.getStringSecond());
		String user = userDao.modifyPersonalData(accpet_user);
		return user;
	}

	@Override
	public String modifyPassword(wlmtxt_user user) {
		user.setUser_gmt_modified(TeamUtil.getStringSecond());
		String result = userDao.modifyPassword(user);
		return result;
	}

}

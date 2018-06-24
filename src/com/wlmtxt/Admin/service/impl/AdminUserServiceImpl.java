package com.wlmtxt.Admin.service.impl;


import com.wlmtxt.Admin.dao.AdminUserDao;
import com.wlmtxt.Admin.service.AdminUserService;

import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.VO.DiscussVO;
import com.wlmtxt.domain.VO.UserVO;

import util.TeamUtil;

public class AdminUserServiceImpl implements AdminUserService {
private AdminUserDao adminUserDao;



public AdminUserDao getAdminUserDao() {
	return adminUserDao;
}

public void setAdminUserDao(AdminUserDao adminUserDao) {
	this.adminUserDao = adminUserDao;
}

@Override
public boolean updateUser_authority(wlmtxt_user user) {
	wlmtxt_user old_user = adminUserDao.getUserById(user.getUser_id());
	String time = TeamUtil.getStringSecond();
	old_user.setUser_gmt_modified(time);
	old_user.setUser_upload(user.getUser_upload());
	old_user.setUser_discuss(user.getUser_discuss());
	if(adminUserDao.updateUser_authority(old_user)){
		return true;
	}else{
		return false;
	}
}

@Override
public boolean deleteUser(String userIDAll) {
	String[] arr = userIDAll.split(",");
	for(String user_id : arr){
		adminUserDao.deleteUser(user_id);
	}
	return true;
}

@Override
public void getUserListBysearchPage(UserVO userVO) {
	int count = adminUserDao.getCountUserList(userVO);
	userVO.setTotalCount(count);
	userVO.setPageSize(10);
	userVO.setTotalPage((int) Math.ceil((double) count / userVO.getPageSize()));
	adminUserDao.getUserListByPage(userVO);
}

@Override
public wlmtxt_user getUserById(String user_id) {
	return adminUserDao.getUserById(user_id);
}

@Override
public void getdiscussListBysearchPage(DiscussVO discussVO) {
	int count = adminUserDao.getCountdiscussList(discussVO);
	discussVO.setTotalCount(count);
	discussVO.setPageSize(10);
	discussVO.setTotalPage((int) Math.ceil((double) count / discussVO.getPageSize()));
	adminUserDao.getdiscussListByPage(discussVO);
	
}

}

package com.wlmtxt.Admin.service;

import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.VO.DiscussVO;
import com.wlmtxt.domain.VO.UserVO;

public interface AdminUserService {

public 	boolean updateUser_authority(wlmtxt_user user);

public boolean deleteUser(String userIDAll);

public void getUserListBysearchPage(UserVO userVO);

public wlmtxt_user getUserById(String user_id);

public void getdiscussListBysearchPage(DiscussVO discussVO);

}

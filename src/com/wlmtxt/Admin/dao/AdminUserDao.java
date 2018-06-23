package com.wlmtxt.Admin.dao;

import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.VO.UserVO;

public interface AdminUserDao {

public	wlmtxt_user getUserById(String user_id);

public void getUserListByPage(UserVO userVO);

public int getCountUserList(UserVO userVO);

public void deleteUser(String user_id);

public boolean updateUser_authority(wlmtxt_user old_user);

}

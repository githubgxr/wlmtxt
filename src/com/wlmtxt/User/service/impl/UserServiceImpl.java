package com.wlmtxt.User.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlmtxt.User.dao.UserDao;
import com.wlmtxt.User.service.UserService;
import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

import util.TeamUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	private WorksDao worksDao;

	public WorksDao getWorksDao() {
		return worksDao;
	}

	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}

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
	public wlmtxt_user get_user_byID(String user_id) {
		return userDao.get_user_byID(user_id);
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
		accpet_user.setUser_avatar("user.jpg");
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

	@Override
	public String followUser(String user_id, wlmtxt_user loginUser) {
		wlmtxt_follow follow = new wlmtxt_follow();
		follow.setFollow_id(TeamUtil.getUuid());
		follow.setFollow_active_user_id(loginUser.getUser_id());
		follow.setFollow_passive_user_id(user_id);
		follow.setFollow_gmt_create(TeamUtil.getStringSecond());
		follow.setFollow_gmt_modified(TeamUtil.getStringSecond());
		return userDao.saveFollowUser(follow);
	}

	@Override
	public List<wlmtxt_first_menu> listFirstMenu(String user_id) {
		// 我上传的所有作品，通过用户id查询
		List<wlmtxt_works> listWorks = userDao.listMyWorks(user_id);
		// 我上传所有作品的所有二级菜单，都是唯一的
		List<wlmtxt_second_menu> listSecondMenuOfAll_works_id = new ArrayList<wlmtxt_second_menu>();
		// 我上传所有作品的一级菜单，都是唯一的
		List<wlmtxt_first_menu> listFirstMenuOfAll = new ArrayList<wlmtxt_first_menu>();
		// 通过作品id，查询出的单个二级菜单
		wlmtxt_second_menu secondMenuOfOne_works_id;
		// 通过二级菜单id，查询出的单个一级菜单
		wlmtxt_first_menu firstMenuOne_second_menu_id;
		for (wlmtxt_works works : listWorks) {
			secondMenuOfOne_works_id = userDao.findSecondMenu_single_works_id(works);
			if (!listSecondMenuOfAll_works_id.contains(secondMenuOfOne_works_id)) {
				listSecondMenuOfAll_works_id.add(secondMenuOfOne_works_id);
			}
		}
		for (wlmtxt_second_menu second_menu : listSecondMenuOfAll_works_id) {
			firstMenuOne_second_menu_id = userDao.findFirstMenu_single_second_menu_id(second_menu);
			if (!listFirstMenuOfAll.contains(firstMenuOne_second_menu_id)) {
				listFirstMenuOfAll.add(firstMenuOne_second_menu_id);
			}
		}
		return listFirstMenuOfAll;
	}

	@Override
	public boolean isFollowedUser(String active_user_id, String passive_user_id) {
		wlmtxt_follow follow = userDao.findFollowBy_user_id(active_user_id, passive_user_id);
		if (follow == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public int deleteAllMyFollow(wlmtxt_user loginUser) throws Exception {
		return userDao.deleteAllMyFollow(loginUser);
	}

	@Override
	public void noticeAllMyFans(wlmtxt_user loginUser) throws Exception {
		List<wlmtxt_follow> followList = userDao.listFollowByLogin_user_id(loginUser.getUser_id());
		List<wlmtxt_user> list = new ArrayList<wlmtxt_user>();
		for (wlmtxt_follow follow : followList) {
			wlmtxt_user follower = userDao.myFansByFollow_passive_user_id(follow.getFollow_active_user_id());
			list.add(follower);
		}
		wlmtxt_follow follow = new wlmtxt_follow();
		for (wlmtxt_user user : list) {
			if (isFollowedUser(loginUser.getUser_id(), user.getUser_id())) {

			} else {
				follow.setFollow_id(TeamUtil.getUuid());
				follow.setFollow_passive_user_id(user.getUser_id());
				follow.setFollow_active_user_id(loginUser.getUser_id());
				follow.setFollow_gmt_create(TeamUtil.getStringSecond());
				follow.setFollow_gmt_modified(TeamUtil.getStringSecond());
				userDao.noticeFans(follow);
			}
		}
	}

	@Override
	public void noticeMyFans(wlmtxt_user loginUser, wlmtxt_user accpet_user) throws Exception {
		wlmtxt_follow follow = new wlmtxt_follow();
		follow.setFollow_id(TeamUtil.getUuid());
		follow.setFollow_passive_user_id(accpet_user.getUser_id());
		follow.setFollow_active_user_id(loginUser.getUser_id());
		follow.setFollow_gmt_create(TeamUtil.getStringSecond());
		follow.setFollow_gmt_modified(TeamUtil.getStringSecond());
		userDao.noticeFans(follow);
	}

	@Override
	public String removeFollow(wlmtxt_user loginUser, wlmtxt_user accpet_user) {
		return userDao.removeFollow(loginUser, accpet_user);
	}

	@Override
	public List<wlmtxt_user> listMyFans(String userID) {
		List<wlmtxt_follow> listFollow = userDao.listFollowByLogin_user_id(userID);
		wlmtxt_user user_follower = new wlmtxt_user();
		List<wlmtxt_user> listFollower = new ArrayList<wlmtxt_user>();
		for (wlmtxt_follow follow : listFollow) {
			user_follower = userDao.myFansByFollow_passive_user_id(follow.getFollow_passive_user_id());
			listFollower.add(user_follower);
		}

		return listFollower;
	}

	/*
	 * @Override public List<wlmtxt_works_keyword> listSecondOfMyWorks(String
	 * user_id) { List<wlmtxt_works> listWorks = userDao.listMyWorks(user_id);
	 * List<wlmtxt_works_keyword> listWorksKeyword = new
	 * ArrayList<wlmtxt_works_keyword>(); for (int i = 0; i < listWorks.size();
	 * i++) { List<wlmtxt_works_keyword> listWorksKeyword_single_works_id =
	 * userDao.listWorksKeyword_by_works_id(listWorks.get(i)); // for (int j =
	 * 0; j < listWorksKeyword_single_works_id.size(); j++) { //
	 * listWorksKeyword.add(listWorksKeyword_single_works_id.get(j)); // }
	 * listWorksKeyword.addAll(listWorksKeyword_single_works_id); } return
	 * listWorksKeyword; }
	 */
}

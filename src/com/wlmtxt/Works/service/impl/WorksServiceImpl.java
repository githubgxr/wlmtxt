package com.wlmtxt.Works.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlmtxt.User.dao.UserDao;
import com.wlmtxt.User.service.UserService;
import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_notification;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;
import com.wlmtxt.domain.DTO.CategoryDTO;
import com.wlmtxt.domain.DTO.DiscussDTO;
import com.wlmtxt.domain.DTO.FollowDTO;
import com.wlmtxt.domain.DTO.KeyWordDTO;
import com.wlmtxt.domain.DTO.PlayHistoryDTO;
import com.wlmtxt.domain.DTO.WorksDTO;
import com.wlmtxt.domain.VO.MyAttentionVO;
import com.wlmtxt.domain.VO.MyWorksVO;
import com.wlmtxt.domain.VO.WorksDetailVO;

import util.TeamUtil;

public class WorksServiceImpl implements WorksService {

	private WorksDao worksDao;
	private UserService userService;
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public WorksDao getWorksDao() {
		return worksDao;
	}

	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}

	@Override
	public int getHotByWorksID(String works_id) {
		/*
		 * 播放1 点赞2 评论3 收藏4
		 */
		int hot = 0;
		// 获取播放数量
		int playNum = getPlayNum(works_id);
		hot = hot + (playNum * 1);
		// 获取点赞数量
		int likeNum = getLikeNum(works_id);
		hot = hot + (likeNum * 2);
		// 获取评论及评论回复的数量
		int discussNum = getDiscussNum(works_id);
		hot = hot + (discussNum * 3);
		// 收藏数量
		int collectNum = getCollectNum(works_id);
		hot = hot + (collectNum * 4);
		//
		return hot;
	}

	@Override
	public List<PlayHistoryDTO> listPlayHistoryDTOListByUserID(String userID) {
		List<PlayHistoryDTO> PlayHistoryDTOList = new ArrayList<PlayHistoryDTO>();
		List<wlmtxt_play_history> playHistoryList = listPlayHistoryListByUserID(userID);
		for (wlmtxt_play_history playHistory : playHistoryList) {
			PlayHistoryDTO playHistoryDTO = new PlayHistoryDTO();
			playHistoryDTO.setPlayHistory(playHistory);

			//
			WorksDTO worksDTO = getWorksDTOByID(playHistory.getPlay_history_works_id());
			playHistoryDTO.setWorksDTO(worksDTO);
			//
			PlayHistoryDTOList.add(playHistoryDTO);
		}

		return PlayHistoryDTOList;
	}

	@Override
	public List<wlmtxt_play_history> listPlayHistoryListByUserID(String userID) {

		return worksDao.listPlayHistoryListByUserID(userID);
	}

	@Override
	public List<wlmtxt_play_history> listPlayHistoryListByWorksID(String worksID) {
		return worksDao.listPlayHistoryByWorksID(worksID);
	};

	@Override
	public int getPlayNum(String works_id) {
		return worksDao.getPlayNum(works_id);
	}

	@Override
	public int getDiscussNum(String works_id) {
		return worksDao.getDiscussNum(works_id);
	}

	@Override
	public int findPlayHistoryNumByFileName(String fileName) {
		return worksDao.getPlayHistoryNumByFileName(fileName);
	}

	@Override
	public wlmtxt_works getWorksByFileName(String fileName) {
		return worksDao.getWorksByFileName(fileName);
	}

	@Override
	public void addNotification(String notification_user_id, String notification_type, String notification_content) {
		wlmtxt_notification notification = new wlmtxt_notification();
		notification.setNotification_id(TeamUtil.getUuid());
		//
		notification.setNotification_user_id(notification_user_id);
		notification.setNotification_type(notification_type);
		notification.setNotification_content(notification_content);
		//
		String time = TeamUtil.getStringSecond();
		notification.setNotification_gmt_create(time);
		notification.setNotification_gmt_modified(time);
		worksDao.addNotification(notification);
	}

	@Override
	public void addPlayHistoryByFileName(String fileName, String userID) {

		wlmtxt_works works = getWorksByFileName(fileName);

		wlmtxt_play_history history = new wlmtxt_play_history();
		history.setPlay_history_id(TeamUtil.getUuid());
		history.setPlay_history_show("1");
		history.setPlay_history_user_id(userID);
		history.setPlay_history_works_id(works.getWorks_id());
		String time = TeamUtil.getStringSecond();
		history.setPlay_history_gmt_create(time);
		history.setPlay_history_gmt_modified(time);

		worksDao.addPlayHistoryByFileName(history);
	};

	@Override
	public void deleteMyWorks(String works_id) {
		worksDao.deleteMyWorks(works_id);

	}

	@Override
	public WorksDTO getWorksDTOByID(String works_id) {
		WorksDTO worksDTO = new WorksDTO();
		//
		wlmtxt_works works = worksDao.getWorksByID(works_id);
		worksDTO.setWorks(works);
		//
		if (null != works.getWorks_second_menu_id() && !works.getWorks_second_menu_id().equals("")) {
			wlmtxt_second_menu secondMenu = worksDao.getSecondMenuByID(works.getWorks_second_menu_id());
			worksDTO.setSecondMenu(secondMenu);
			if (null != secondMenu.getSecond_menu_first_menu_id()
					&& !secondMenu.getSecond_menu_first_menu_id().equals("")) {
				wlmtxt_first_menu firstMenu = worksDao.getFirstMenuByID(secondMenu.getSecond_menu_first_menu_id());
				worksDTO.setFirstMenu(firstMenu);
			}
		}
		//

		// 获取关键词列表
		List<KeyWordDTO> keyWordDTOList = listWorksKeywordByWorksID(works.getWorks_id());
		worksDTO.setKeyWordDTOList(keyWordDTOList);
		// 获取作者信息
		wlmtxt_user user = userService.get_user_byID(works.getWorks_user_id());
		worksDTO.setUser(user);

		// 获取点赞评论收藏播放数
		worksDTO.setPlayNum(getPlayNum(works_id));
		worksDTO.setLikeNum(getLikeNum(works_id));
		worksDTO.setCollectNum(getCollectNum(works_id));
		worksDTO.setDiscussNum(getDiscussNum(works_id));
		// 获取热度
		worksDTO.setHot(getHotByWorksID(works_id));
		//
		return worksDTO;
	}

	@Override
	public List<WorksDTO> listWorks10OrderHotByDay() {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksByDay();
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		for (int i = 0; i < worksDTOList.size() - 1; i++) {
			for (int j = 0; j < worksDTOList.size() - i - 1; j++) {// 比较两个整数
				if (worksDTOList.get(j).getHot() > worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 9) {
			return worksDTOList.subList(0, worksDTOList.size() - 1);
		} else {
			return worksDTOList.subList(0, 9);
		}
	}

	@Override
	public List<WorksDTO> listWorks10OrderHotByMonth() {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksByMonth();
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		for (int i = 0; i < worksDTOList.size() - 1; i++) {
			for (int j = 0; j < worksDTOList.size() - i - 1; j++) {// 比较两个整数
				if (worksDTOList.get(j).getHot() > worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 9) {
			return worksDTOList.subList(0, worksDTOList.size() - 1);
		} else {
			return worksDTOList.subList(0, 9);
		}
	}

	@Override
	public List<WorksDTO> listWorks10OrderHotByWeek() {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksByWeek();
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		for (int i = 0; i < worksDTOList.size() - 1; i++) {
			for (int j = 0; j < worksDTOList.size() - i - 1; j++) {// 比较两个整数
				if (worksDTOList.get(j).getHot() > worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 9) {
			return worksDTOList.subList(0, worksDTOList.size() - 1);
		} else {
			return worksDTOList.subList(0, 9);
		}
	}

	public List<KeyWordDTO> listWorksKeywordByWorksID(String worksID) {
		List<KeyWordDTO> keyWordDTOList = new ArrayList<KeyWordDTO>();
		//
		List<wlmtxt_works_keyword> keyWordList = worksDao.listKeyWordByByWorksID(worksID);
		for (wlmtxt_works_keyword keyWord : keyWordList) {
			KeyWordDTO keyWordDTO = new KeyWordDTO();
			//
			keyWordDTO.setWorks_keyword(keyWord);
			//
			wlmtxt_keyword word = worksDao.getWordByID(keyWord.getWorks_keyword_keyword_id());
			keyWordDTO.setKeyword(word);
			//
			keyWordDTOList.add(keyWordDTO);
		}
		//
		return keyWordDTOList;
	}

	@Override
	public WorksDetailVO getWorksDetailVO(String works_id) {
		WorksDetailVO worksDetailVO = new WorksDetailVO();
		//
		WorksDTO worksDTO = getWorksDTOByID(works_id);
		worksDetailVO.setWorksDTO(worksDTO);
		//
		List<DiscussDTO> discussDTOList = new ArrayList<DiscussDTO>();
		// 评论
		List<wlmtxt_discuss> discussList = worksDao.getDiscussListByFatherID(works_id);
		for (wlmtxt_discuss discuss : discussList) {

			DiscussDTO discussDTO = new DiscussDTO();
			discussDTO.setDiscuss(discuss);
			//
			List<wlmtxt_discuss> replyList = worksDao.getDiscussListByFatherID(discuss.getDiscuss_id());
			discussDTO.setReply(replyList);
			//
			wlmtxt_user user = userService.get_user_byID(discuss.getDiscuss_user_id());
			discussDTO.setUser(user);
			//
			discussDTOList.add(discussDTO);
		}
		worksDetailVO.setDiscussDTOList(discussDTOList);

		//
		return worksDetailVO;
	}

	@Override
	public List<WorksDTO> listWorksByFirstMenuID(String second_menu_id) {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		// 根据一级类别获取所属的二级类别
		List<wlmtxt_second_menu> secondMenuList = worksDao.listSecondMenuByFather(second_menu_id);
		for (wlmtxt_second_menu second_menu : secondMenuList) {
			// 遍历二级类别取出所有相应作品
			List<wlmtxt_works> worksList = worksDao.listWorksBySecondMenuID(second_menu.getSecond_menu_id());
			for (wlmtxt_works works : worksList) {
				WorksDTO worksDTO = new WorksDTO();
				worksDTO = getWorksDTOByID(works.getWorks_id());
				worksDTOList.add(worksDTO);
			}
		}
		return worksDTOList;
	}

	@Override
	public List<WorksDTO> listWorksBySecondMenuID(String second_menu_id) {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksBySecondMenuID(second_menu_id);
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO.setWorks(works);
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		return worksDTOList;
	}

	@Override
	public List<WorksDTO> listWorksAll() {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksAll();
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		return worksDTOList;
	}

	@Override
	public MyWorksVO getMyWorksVO(String user_id, MyWorksVO myWorksVO) {

		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();

		List<wlmtxt_works> workList = worksDao.listMyWorksByUserIDAndNum(user_id, myWorksVO);

		int i = worksDao.getMyWorksTotalRecords(user_id);
		myWorksVO.setTotalRecords(i);
		myWorksVO.setTotalPages(((i - 1) / myWorksVO.getPageSize()) + 1);
		if (myWorksVO.getPageIndex() <= 1) {
			myWorksVO.setHavePrePage(false);
		} else {
			myWorksVO.setHavePrePage(true);
		}
		if (myWorksVO.getPageIndex() >= myWorksVO.getTotalPages()) {
			myWorksVO.setHaveNextPage(false);
		} else {
			myWorksVO.setHaveNextPage(true);
		}

		for (wlmtxt_works works : workList) {
			WorksDTO worksDTO = new WorksDTO();
			//
			worksDTO = getWorksDTOByID(works.getWorks_id());
			//

			//
			worksDTOList.add(worksDTO);
		}
		myWorksVO.setWorksDTOList(worksDTOList);
		return myWorksVO;
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenu_byFirstMenuID(String first_menu_id) {
		return worksDao.listSecondMenuByFirstMenuID(first_menu_id);
	}

	@Override
	public List<wlmtxt_notification> listUserNotification(String user_id) {
		return worksDao.listUserNotification(user_id);
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenu() {
		return worksDao.listSecondMenu();
	}

	@Override
	public List<wlmtxt_first_menu> listFirstMenu() {

		return worksDao.listFirstMenu();
	}

	@Override
	public void saveWorks(wlmtxt_works accept_works, String[] keywords) {
		//
		accept_works.setWorks_id(TeamUtil.getUuid());
		//
		accept_works.setWorks_passed("3");
		//
		accept_works.setWorks_deleted("2");
		//
		String time = TeamUtil.getStringSecond();
		accept_works.setWorks_gmt_create(time);
		accept_works.setWorks_gmt_modified(time);
		//
		worksDao.saveWorks(accept_works);
		/*
		 * 
		 */
		if (null != keywords) {
			wlmtxt_keyword newkeywords;
			for (int i = 0; i < keywords.length; i++) {
				if (!keywords[i].equals("")) {
					newkeywords = new wlmtxt_keyword();
					String uuidkey1 = TeamUtil.getUuid();
					newkeywords.setKeyword_id(uuidkey1);
					newkeywords.setKeyword_name(keywords[i]);
					newkeywords.setKeyword_gmt_modified(time);
					newkeywords.setKeyword_gmt_create(time);
					worksDao.saveKeyword(newkeywords);
					/*
					 * 
					 */
					wlmtxt_works_keyword works_keyword = new wlmtxt_works_keyword();
					works_keyword.setWorks_keyword_id(TeamUtil.getUuid());
					works_keyword.setWorks_keyword_works_id(accept_works.getWorks_id());
					works_keyword.setWorks_keyword_keyword_id(uuidkey1);
					works_keyword.setWorks_keyword_gmt_create(time);
					works_keyword.setWorks_keyword_gmt_modified(time);
					worksDao.saveWord(works_keyword);
				}

			}
		}

		//
		//

		//
		/*
		 * 
		 */

	}

	@Override
	public boolean isCollectWorks(String user_id, String works_id) throws Exception {
		wlmtxt_collect collect = worksDao.findCollect(user_id, works_id);
		if (collect == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isLiked(String userID, String worksID) throws Exception {

		wlmtxt_like like = worksDao.findLike(userID, worksID);
		if (like == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public int getLikeNum(String works_id) {
		return worksDao.getLikeNum(works_id);
	}

	@Override
	public CategoryDTO getCategoryDTOByID(String menu_id) {

		CategoryDTO categoryDTO = new CategoryDTO();

		wlmtxt_first_menu firstMenu = worksDao.getFirstMenuByID(menu_id);

		if (firstMenu == null) {
			// 用的二级
			wlmtxt_second_menu secondMenu = worksDao.getSecondMenuByID(menu_id);
			categoryDTO.setSecondMenu(secondMenu);
			//
			firstMenu = worksDao.getFirstMenuByID(secondMenu.getSecond_menu_first_menu_id());
			categoryDTO.setFirstMenu(firstMenu);
		} else {
			// 用的一级
			categoryDTO.setFirstMenu(firstMenu);
		}

		return categoryDTO;
	}

	@Override
	public int getCollectNum(String works_id) {
		return worksDao.getCollectNum(works_id);
	}

	@Override
	public void likWorks(wlmtxt_user user, wlmtxt_works works) throws Exception {
		// 查询是否有点赞记录
		wlmtxt_like like = worksDao.findLike(user.getUser_id(), works.getWorks_id());
		if (like == null) {
			// 如果没有点赞，就点赞
			wlmtxt_like new_like = new wlmtxt_like();
			new_like.setLike_id(TeamUtil.getUuid());
			new_like.setLike_user_id(user.getUser_id());
			new_like.setLike_works_id(works.getWorks_id());
			new_like.setLike_gmt_create(TeamUtil.getStringSecond());
			new_like.setLike_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveLike(new_like);
			/*
			 * 通知
			 */
			// 查询发起者
			wlmtxt_user putMan = userService.get_user_byID(user.getUser_id());
			// 查询作品
			wlmtxt_works putWorks = worksDao.getWorksByID(works.getWorks_id());
			addNotification(putWorks.getWorks_user_id(), "3",
					putMan.getUser_username() + "喜欢了您的作品" + putWorks.getWorks_name());
			/*
			 * 
			 */
		} else {
			// 点赞了就取消点赞
			worksDao.removeLike(user.getUser_id(), works.getWorks_id());
		}
	}

	@Override
	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		wlmtxt_collect collect = worksDao.findCollect(user.getUser_id(), accept_works.getWorks_id());
		if (collect == null) {
			wlmtxt_collect new_collect = new wlmtxt_collect();
			new_collect.setCollect_id(TeamUtil.getUuid());
			new_collect.setCollect_user_id(user.getUser_id());
			new_collect.setCollect_works_id(accept_works.getWorks_id());
			new_collect.setCollect_gmt_create(TeamUtil.getStringSecond());
			new_collect.setCollect_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveCollect(new_collect);
			/*
			 * 通知
			 */
			// 查询发起者
			wlmtxt_user putMan = userService.get_user_byID(user.getUser_id());
			// 查询作品
			wlmtxt_works putWorks = worksDao.getWorksByID(accept_works.getWorks_id());
			addNotification(putWorks.getWorks_user_id(), "2",
					putMan.getUser_username() + "收藏了您的作品" + putWorks.getWorks_name());
			/*
			 * 
			 */
		} else {
			worksDao.removeCollect(user.getUser_id(), accept_works.getWorks_id());
		}
	}

	@Override
	public void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		String download_history_user_id = user.getUser_id();
		String download_history_works_id = accept_works.getWorks_id();
		wlmtxt_download_history new_download_history = new wlmtxt_download_history();
		new_download_history.setDownload_history_id(TeamUtil.getUuid());
		new_download_history.setDownload_history_user_id(download_history_user_id);
		new_download_history.setDownload_history_works_id(download_history_works_id);
		new_download_history.setDownload_history_show("是");
		new_download_history.setDownload_history_gmt_create(TeamUtil.getStringSecond());
		new_download_history.setDownload_history_gmt_modified(TeamUtil.getStringSecond());
		worksDao.saveDownloadHistory(new_download_history);
	}
	// 删除下载历史记录，即不显示在个人中心，实际的表记录未删除

	@Override
	public void discussWorks(wlmtxt_discuss accpet_discuss) {

		accpet_discuss.setDiscuss_id(TeamUtil.getUuid());

		accpet_discuss.setDiscuss_gmt_create(TeamUtil.getStringSecond());
		accpet_discuss.setDiscuss_gmt_modified(TeamUtil.getStringSecond());
		worksDao.saveDiscuss(accpet_discuss);
		/*
		 * 通知
		 */
		// 查询发起者
		wlmtxt_user putMan = userService.get_user_byID(accpet_discuss.getDiscuss_user_id());
		// 查询作品
		wlmtxt_works putWorks = worksDao.getWorksByID(accpet_discuss.getDiscuss_father_discuss_id());
		if (putWorks != null) {
			// 评论
			addNotification(putWorks.getWorks_user_id(), "4",
					putMan.getUser_username() + "评论了您的作品" + putWorks.getWorks_name());
		} else {
			// 回复
			wlmtxt_discuss reply = worksDao.getDiscussByID(accpet_discuss.getDiscuss_father_discuss_id());
			addNotification(putWorks.getWorks_user_id(), "5",
					putMan.getUser_username() + "回复了您的评论" + reply.getDiscuss_content());
		}

		/*
		 * 
		 */
	}

	@Override
	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		worksDao.removeDownloadHistory(user, accept_works);
	}

	@Override
	public int totalPlayNum(String works_id) {
		int playCount = worksDao.totalPlayNum(works_id);
		return playCount;
	}

	@Override
	public int countCollectNum(String works_id) {
		int collectNum = worksDao.countCollectNum(works_id);
		return collectNum;
	}

	@Override
	public int countLikeNum(String works_id) {
		int num = worksDao.countLikeNum(works_id);
		return num;
	}

	@Override
	public int deleteAllMyWorks(String user_id) {
		List<wlmtxt_works> list = worksDao.listWorksAllByUserId(user_id);
		for (wlmtxt_works works : list) {
			worksDao.deleteMyWorks(works.getWorks_id());
		}
		return 1;
	}

	@Override
	public MyAttentionVO listMyAttentionVO(String user_id, MyAttentionVO myAttentionVO) {
		List<FollowDTO> DTOList = new ArrayList<FollowDTO>();

		List<wlmtxt_follow> list = worksDao.listMyWorksByUserId(user_id, myAttentionVO);

		int i = worksDao.getMyAttentionTotalRecords(user_id);
		myAttentionVO.setTotalRecords(i);
		myAttentionVO.setTotalPages(((i - 1) / myAttentionVO.getPageSize()) + 1);
		if (myAttentionVO.getPageIndex() <= 1) {
			myAttentionVO.setHavePrePage(false);
		} else {
			myAttentionVO.setHavePrePage(true);
		}
		if (myAttentionVO.getPageIndex() >= myAttentionVO.getTotalPages()) {
			myAttentionVO.setHaveNextPage(false);
		} else {
			myAttentionVO.setHaveNextPage(true);
		}

		FollowDTO followDTO = new FollowDTO();
		for (wlmtxt_follow follow : list) {
			wlmtxt_follow mutualFollow = worksDao.findFollowByActiveUserId(user_id, follow.getFollow_passive_user_id());
			if (mutualFollow != null) {
				followDTO.setMutualFollow("1");
			} else {
				followDTO.setMutualFollow("2");
			}
			followDTO.setUser(userDao.get_user_byID(user_id));
			DTOList.add(followDTO);
		}
		myAttentionVO.setFollowDTO(DTOList);
		return myAttentionVO;
	}

}

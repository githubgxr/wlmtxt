package com.wlmtxt.Works.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlmtxt.User.service.UserService;
import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;
import com.wlmtxt.domain.DTO.DiscussDTO;
import com.wlmtxt.domain.DTO.KeyWordDTO;
import com.wlmtxt.domain.DTO.WorksDTO;
import com.wlmtxt.domain.VO.MyWorksVO;
import com.wlmtxt.domain.VO.WorksDetailVO;

import util.TeamUtil;

public class WorksServiceImpl implements WorksService {

	private WorksDao worksDao;
	private UserService userService;

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
			if (secondMenu.getSecond_menu_first_menu_id() != null
					&& !secondMenu.getSecond_menu_first_menu_id().equals("")) {
				wlmtxt_first_menu firstMenu = worksDao.getFirstMenuByID(secondMenu.getSecond_menu_first_menu_id());
				worksDTO.setFirstMenu(firstMenu);
			}
		}
		//

		// 获取关键词列表
		List<KeyWordDTO> keyWordDTOList = listWorksKeywordByWorksID(works.getWorks_id());
		worksDTO.setKeyWordDTOList(keyWordDTOList);
		//
		wlmtxt_user user = userService.get_user_byID(works.getWorks_user_id());
		worksDTO.setUser(user);
		//
		return worksDTO;
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
		System.out.println(secondMenuList.size());
		for (wlmtxt_second_menu second_menu : secondMenuList) {
			// 遍历二级类别取出所有相应作品
			List<wlmtxt_works> worksList = worksDao.listWorksBySecondMenuID(second_menu.getSecond_menu_id());
			System.out.println(worksList.size());
			for (wlmtxt_works works : worksList) {
				WorksDTO worksDTO = new WorksDTO();
				worksDTO.setWorks(works);
				if (null == works.getWorks_second_menu_id() || works.getWorks_second_menu_id().equals("")) {
				} else {
					wlmtxt_second_menu secondMenu = worksDao.getSecondMenuByID(works.getWorks_second_menu_id());
					worksDTO.setSecondMenu(secondMenu);
					if (null == secondMenu.getSecond_menu_first_menu_id()
							|| secondMenu.getSecond_menu_first_menu_id().equals("")) {
					} else {
						wlmtxt_first_menu firstMenu = worksDao
								.getFirstMenuByID(secondMenu.getSecond_menu_first_menu_id());
						worksDTO.setFirstMenu(firstMenu);
					}
				}
				worksDTOList.add(worksDTO);
			}
		}
		System.out.println(worksDTOList.size());
		return worksDTOList;
	}

	@Override
	public List<WorksDTO> listWorksBySecondMenuID(String second_menu_id) {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksList = worksDao.listWorksBySecondMenuID(second_menu_id);
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO.setWorks(works);
			if (null == works.getWorks_second_menu_id() || works.getWorks_second_menu_id().equals("")) {
			} else {
				wlmtxt_second_menu secondMenu = worksDao.getSecondMenuByID(works.getWorks_second_menu_id());
				worksDTO.setSecondMenu(secondMenu);
				if (null == secondMenu.getSecond_menu_first_menu_id()
						|| secondMenu.getSecond_menu_first_menu_id().equals("")) {
				} else {
					wlmtxt_first_menu firstMenu = worksDao.getFirstMenuByID(secondMenu.getSecond_menu_first_menu_id());
					worksDTO.setFirstMenu(firstMenu);
				}
			}
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
		wlmtxt_collect collect = worksDao.findCollectBy_user_id_And_collect_works_id(user_id, user_id);
		if (collect == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isLiked(String userID, String worksID) throws Exception {

		wlmtxt_like like = worksDao.findLikeBy_user_id_And_like_works_id(userID, worksID);
		if (like == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void likWorks(wlmtxt_user user, wlmtxt_works works) throws Exception {
		String like_user_id = user.getUser_id();
		String like_works_id = works.getWorks_id();
		wlmtxt_like like = worksDao.findLikeBy_user_id_And_like_works_id(like_user_id, like_works_id);
		Boolean like_flag;
		if (like == null) {
			like_flag = false;
		} else {
			like_flag = true;
		}
		if (like_flag) {
			worksDao.removeLikeBy_user_id_And_like_works_id(like_user_id, like_works_id);
		} else {
			wlmtxt_like new_like = new wlmtxt_like();
			new_like.setLike_id(TeamUtil.getUuid());
			new_like.setLike_user_id(like_user_id);
			new_like.setLike_works_id(like_works_id);
			new_like.setLike_gmt_create(TeamUtil.getStringSecond());
			new_like.setLike_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveLike(new_like);
		}
	}

	@Override
	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		String collect_user_id = user.getUser_id();
		String collect_works_id = accept_works.getWorks_id();
		wlmtxt_collect collect = worksDao.findCollectBy_user_id_And_collect_works_id(collect_user_id, collect_works_id);
		Boolean collect_flag;
		if (collect == null) {
			collect_flag = false;
		} else {
			collect_flag = true;
		}
		if (collect_flag) {
			worksDao.removeCollectBy_user_id_And_collect_works_id(collect_user_id, collect_works_id);
		} else {
			wlmtxt_collect new_collect = new wlmtxt_collect();
			new_collect.setCollect_id(TeamUtil.getUuid());
			new_collect.setCollect_user_id(collect_user_id);
			new_collect.setCollect_works_id(collect_works_id);
			new_collect.setCollect_gmt_create(TeamUtil.getStringSecond());
			new_collect.setCollect_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveCollect(new_collect);
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
		accpet_discuss.setDiscuss_deleted("2");

		accpet_discuss.setDiscuss_gmt_create(TeamUtil.getStringSecond());
		accpet_discuss.setDiscuss_gmt_modified(TeamUtil.getStringSecond());
		worksDao.saveDiscuss(accpet_discuss);

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

}

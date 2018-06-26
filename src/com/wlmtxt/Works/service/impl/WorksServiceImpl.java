package com.wlmtxt.Works.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
import com.wlmtxt.domain.DTO.CollectDTO;
import com.wlmtxt.domain.DTO.DiscussDTO;
import com.wlmtxt.domain.DTO.DiscussWorkDTO;
import com.wlmtxt.domain.DTO.FollowDTO;
import com.wlmtxt.domain.DTO.KeyWordDTO;
import com.wlmtxt.domain.DTO.LikeDTO;
import com.wlmtxt.domain.DTO.NotificationDTO;
import com.wlmtxt.domain.DTO.PlayHistoryDTO;
import com.wlmtxt.domain.DTO.ReplyDTO;
import com.wlmtxt.domain.DTO.WorksDTO;
import com.wlmtxt.domain.DTO.sf.DevDTO;
import com.wlmtxt.domain.VO.DynamicVO;
import com.wlmtxt.domain.VO.MyWorksVO;
import com.wlmtxt.domain.VO.WorksCategoryVO;
import com.wlmtxt.domain.VO.WorksDetailVO;

import util.TeamUtil;

public class WorksServiceImpl implements WorksService {

	private static Logger LOGGER = LogManager.getLogger(WorksServiceImpl.class.getName());
	private WorksDao worksDao;
	private UserService userService;
	private UserDao userDao;
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public void addNotification(String notification_user_id, String notification_type, String notification_content,
			String notification_work) {
		wlmtxt_notification notification = new wlmtxt_notification();
		notification.setNotification_id(TeamUtil.getUuid());
		//
		notification.setNotification_user_id(notification_user_id);
		notification.setNotification_type(notification_type);
		notification.setNotification_content(notification_content);
		notification.setNotification_works(notification_work);
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
	}

	@Override
	public List<WorksDTO> collaborativeFilteringBySlopeOne(String currentWorksID, String currentUserID) {
		/*
		* 
		*/
		long startTime = System.currentTimeMillis();
		/*
		* 
		*/
		/*
		 * 如果未登录，则无法进行推荐
		 */
		if (currentUserID == null) {
			List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
			List<String> worksTemporaryList;
			List<wlmtxt_works> worksFinallyList = new ArrayList<wlmtxt_works>();
			worksTemporaryList = worksDao.listWorksIDAll();
			int n_n = (worksTemporaryList.size() >= 5 ? 5 : worksTemporaryList.size());

			for (int n = 0; n < n_n; n++) {
				int random = (int) (Math.random() * worksTemporaryList.size());
				worksFinallyList.add(worksDao.getWorksByID(worksTemporaryList.get(random)));
				worksTemporaryList.remove(random);
			}

			for (wlmtxt_works works : worksFinallyList) {
				WorksDTO worksDTO = new WorksDTO();
				worksDTO = getWorksDTOByID(works.getWorks_id());
				worksDTOList.add(worksDTO);
			}
			return worksDTOList;
		}

		/*
		 * 预测评价的map
		 */
		Map<String, Double> worksForecastPointMap = new HashMap<String, Double>();
		List<String> worksAll = worksDao.listWorksIDAll();
		for (String worksID : worksAll) {
			if (worksID.equals(currentWorksID)) {
				continue;
			}

			Double worksForecastPoint = forecastPoint(currentWorksID, currentUserID);
			worksForecastPointMap.put(worksID, worksForecastPoint);
		}
		/*
		 * 对map进行排序
		 */
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(
				worksForecastPointMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 降序排序
			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		System.out.println("预测评价排序" + worksForecastPointMap.size() + "条：" + worksForecastPointMap);
		/*
		 * 
		 */
		List<wlmtxt_works> worksFinallyAllList = new ArrayList<wlmtxt_works>();
		for (Map.Entry<String, Double> worksEntry : worksForecastPointMap.entrySet()) {
			worksFinallyAllList.add(worksDao.getWorksByID(worksEntry.getKey()));
			//
			if (worksFinallyAllList.size() < 5) {
				// 如果小于5条就继续抓
			} else {
				// 大于5条就不抓了
				break;
			}
		}

		/*
		 * 封装DTO
		 */
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		for (wlmtxt_works works : worksFinallyAllList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		/*
		 *
		 */
		long stopTime = System.currentTimeMillis();
		LOGGER.error("collaborativeFilteringBySlopeOne运行时间：" + (stopTime - startTime) + "毫秒");
		/*
		 * 
		*/
		return worksDTOList;
	}

	@Override
	public List<WorksDTO> collaborativeFilteringByUser(String userID) {
		/*
		* 
		*/
		long startTime = System.currentTimeMillis();
		/*
		* 
		*/
		/*
		 * 如果未登录，则无法进行推荐
		 */
		if (userID == null) {
			List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
			List<wlmtxt_works> worksTemporaryList = new ArrayList<wlmtxt_works>();
			List<wlmtxt_works> worksFinallyList = new ArrayList<wlmtxt_works>();
			worksTemporaryList = worksDao.listWorksAll();
			int n_n = (worksTemporaryList.size() >= 5 ? 5 : worksTemporaryList.size());
			for (int n = 0; n < n_n; n++) {
				int random = (int) (Math.random() * worksTemporaryList.size());
				worksFinallyList.add(worksTemporaryList.get(random));
				worksTemporaryList.remove(random);
			}

			for (wlmtxt_works works : worksFinallyList) {
				WorksDTO worksDTO = new WorksDTO();
				worksDTO = getWorksDTOByID(works.getWorks_id());
				worksDTOList.add(worksDTO);
			}
			return worksDTOList;
		}
		// 取出用户信息和作品信息
		wlmtxt_user curUser = userService.get_user_byID(userID);
		List<wlmtxt_works> worksAll = worksDao.listWorksAll();
		/*
		 * 计算当前用户对所有作品的评分，保存为一个map的list
		 */
		Map<String, Integer> myPointMap = new HashMap<String, Integer>();
		Integer point = 0;
		for (wlmtxt_works works : worksAll) {
			point = userPointWork(curUser.getUser_id(), works.getWorks_id());
			myPointMap.put(works.getWorks_id(), point);
		}
		/*
		 * 计算其他用户对所有作品的评分，保存为一个list
		 */
		List<String> allUserList = worksDao.listUserIDAll();
		// 二维列表
		Map<String, Map<String, Integer>> allUserPointMap = new HashMap<String, Map<String, Integer>>();
		// 遍历所有用户
		for (String otherUserID : allUserList) {
			// 排除当前用户
			if (!otherUserID.equals(curUser.getUser_id())) {
				Map<String, Integer> otherUserPointMap = new HashMap<String, Integer>();
				for (wlmtxt_works works : worksAll) {
					point = userPointWork(otherUserID, works.getWorks_id());
					otherUserPointMap.put(works.getWorks_id(), point);
				}
				allUserPointMap.put(otherUserID, otherUserPointMap);
			}

		}
		/*
		 * 欧几里得距离求相似度
		 */
		Map<String, Double> similarityDegreeMap = new HashMap<String, Double>();
		Double similarityDegree = 0.0;
		for (Map.Entry<String, Map<String, Integer>> otherUser : allUserPointMap.entrySet()) {

			int oneValue = 0;
			for (Map.Entry<String, Integer> entry : otherUser.getValue().entrySet()) {
				// 登录用户对遍历的这个作品的喜爱值
				int curUserLikeValue = myPointMap.get(entry.getKey());
				// 遍历的用户对遍历的这个作品的喜爱值
				int otherUserLikeValue = entry.getValue();
				// 计算单个作品
				oneValue = oneValue + (int) Math.pow(curUserLikeValue - otherUserLikeValue, 2);

			}
			// 算出登录用户和当前遍历用户的相似度similarityDegree
			similarityDegree = Math.pow(oneValue, 0.5);
			similarityDegreeMap.put(otherUser.getKey(), similarityDegree);

		}

		/*
		 * 相似度排序
		 */
		List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(similarityDegreeMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
			// 降序排序
			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		System.out.println("用户相似度排序：" + similarityDegreeMap);

		/*
		 * 抓取前二十条作品数据
		 */
		List<wlmtxt_works> worksFinallyAllList = new ArrayList<wlmtxt_works>();
		for (Map.Entry<String, Double> userEntry : similarityDegreeMap.entrySet()) {
			// 计算单个作品
			List<wlmtxt_works> worksTemporaryList = worksDao.listWorksAllByUserId(userEntry.getKey());
			// System.out.println("单个用户的作品：" + worksTemporaryList);
			//
			worksFinallyAllList.addAll(worksTemporaryList);
			//
			if (worksTemporaryList.size() < 20) {
				// 如果小于二十条就继续抓
			} else {
				// 大于二十条就不抓了
				break;
			}
		}
		// System.out.println(worksFinallyAllList);
		/*
		 * 随机五条
		 */
		List<wlmtxt_works> worksFinallyList = new ArrayList<wlmtxt_works>();
		int n_n = (worksFinallyAllList.size() >= 5 ? 5 : worksFinallyAllList.size());
		for (int n = 0; n < n_n; n++) {
			int random = (int) (Math.random() * worksFinallyAllList.size());
			worksFinallyList.add(worksFinallyAllList.get(random));
			worksFinallyAllList.remove(random);
		}

		/*
		 * 
		 */
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		for (wlmtxt_works works : worksFinallyList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}

		/*
		 * 
		 */

		return worksDTOList;
	}

	@Override
	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) {
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
					putMan.getUser_username() + "收藏了您的作品" + putWorks.getWorks_title(), putWorks.getWorks_id());
			/*
			 * 
			 */
		} else {
			worksDao.removeCollect(user.getUser_id(), accept_works.getWorks_id());
		}
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
	public void deleteAllMyHistory(String userID) {
		worksDao.deleteAllMyHistory(userID);

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
	public void deleteDisscuss(String discuss_id) {
		worksDao.deleteDisscuss(discuss_id);

	}

	@Override
	public void deleteMyWorks(String works_id) {
		worksDao.deleteMyWorks(works_id);

	}

	@Override
	public void deletePlayHistory(String play_history_id) {
		worksDao.deletePlayHistory(play_history_id);

	}

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
					putMan.getUser_username() + "评论了您的作品" + putWorks.getWorks_title(), putWorks.getWorks_id());
		} else {
			// 回复
			wlmtxt_discuss discuss = worksDao.getDiscussByID(accpet_discuss.getDiscuss_father_discuss_id());
			addNotification(discuss.getDiscuss_user_id(), "5",
					putMan.getUser_username() + "回复了您的评论" + discuss.getDiscuss_content(), null);
		}

		/*
		 * 
		 */
	}

	@Override
	public void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works) {
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
	public int findPlayHistoryNumByFileName(String fileName) {
		return worksDao.getPlayHistoryNumByFileName(fileName);
	}

	@Override
	public Double forecastPoint(String currentWorksID, String currentUserID) {

		/*
		 * 
		 */
		long startTime = System.currentTimeMillis();
		/*
		 * 
		 */
		// 取出用户信息和作品信息
		List<String> worksIDAll = worksDao.listWorksIDAll();
		/*
		 * 计算此作品与其他作品的差异值，保存为一个map
		 */
		// Map<String, Double> thisWorksDevMap = new HashMap<String, Double>();
		Double dev = 0.0;
		Double SO_FZ = 0.0;
		int validUserDevNumAll = 0;
		for (String worksID : worksIDAll) {
			// 跳过此作品
			if (worksID.equals(currentWorksID)) {
				continue;
			}
			// WorksDev()计算差异值
			DevDTO devDTO = devWorks(currentWorksID, worksID, currentUserID);
			dev = devDTO.dev;
			// thisWorksDevMap.put(works.getWorks_id(), dev);
			/*
			 * 遍历其他作品，用喜爱值加上差异值
			 */
			// 当前用户对这个遍历的作品的评分
			int currentUserPointOtherWorks = userPointWork(currentUserID, worksID);
			int validUserDevNum = devDTO.validUserDevNum;
			SO_FZ = SO_FZ + (dev + currentUserPointOtherWorks) * validUserDevNum;
			/*
			 * 
			 */
			validUserDevNumAll = validUserDevNumAll + validUserDevNum;

		}

		Double forecastPoint = 0.0;
		if (validUserDevNumAll == 0) {
			forecastPoint = 0.0;
		} else {
			forecastPoint = SO_FZ / validUserDevNumAll;
		}
		/*
		 * 
		 */
		/*
		 *
		 */
		long stopTime = System.currentTimeMillis();
		// LOGGER.error("结束时间：" + dateformat.format(stopTime));
		// LOGGER.error("forecastPoint：" + forecastPoint + "；运行时间：" + (stopTime
		// - startTime) + "毫秒");
		/*
		 * 
		 */
		return forecastPoint;
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
	public int getDiscussNum(String works_id) {
		return worksDao.getDiscussNum(works_id);
	}

	@Override
	public DynamicVO getDynamicVO(String user_id, DynamicVO dynamicVO) {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		//
		List<wlmtxt_user> attentionUserList = worksDao.listAttentionUser(user_id);
		List<wlmtxt_works> workList = new ArrayList<wlmtxt_works>();
		for (wlmtxt_user user : attentionUserList) {
			// 好友动态应该排除自己
			if (!user.getUser_id().endsWith(user_id)) {
				workList.addAll(worksDao.listWorksAllByUserId(user.getUser_id()));
			}
		}
		/*
		 * service层的分页
		 */
		// 总记录数
		if ((dynamicVO.getPageIndex() - 1) * dynamicVO.getPageSize() < workList.size()) {

			int firstNum = (dynamicVO.getPageIndex() - 1) * dynamicVO.getPageSize();
			int endNum = 0;
			if ((dynamicVO.getPageIndex()) * dynamicVO.getPageSize() < workList.size()) {
				endNum = (dynamicVO.getPageIndex()) * dynamicVO.getPageSize();
			} else {
				endNum = ((dynamicVO.getPageIndex() - 1) * dynamicVO.getPageSize())
						+ (workList.size() - ((dynamicVO.getPageIndex() - 1) * dynamicVO.getPageSize()));
			}
			workList = workList.subList(firstNum, endNum);
			/*
			 * 
			 */
			for (wlmtxt_works works : workList) {
				WorksDTO worksDTO = new WorksDTO();
				worksDTO = getWorksDTOByID(works.getWorks_id());
				worksDTOList.add(worksDTO);
			}
			dynamicVO.setWorksDTOList(worksDTOList);
		} else {
			dynamicVO.setWorksDTOList(worksDTOList);
		}
		//
		return dynamicVO;

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
	public int getLikeNum(String works_id) {
		return worksDao.getLikeNum(works_id);
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
	};

	@Override
	public int getPlayNum(String works_id) {
		return worksDao.getPlayNum(works_id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public UserService getUserService() {
		return userService;
	}

	/**
	 */
	@Override
	public WorksCategoryVO getWorksByCategoryPage(WorksCategoryVO WorksCategoryVO) {
		List<wlmtxt_works> worksList = null;
		if ("all".equals(WorksCategoryVO.getScreen_category())) {
			// 所有类别
			worksList = worksDao.getWorksByPage(WorksCategoryVO.getPageIndex(), WorksCategoryVO.getPageSize());
		} else {
			List<wlmtxt_second_menu> secondMenuList = worksDao
					.listSecondMenuByFather(WorksCategoryVO.getScreen_category());
			if (secondMenuList == null) {
				// 说明所传是二级类别
				worksList = worksDao.getWorksBySecondMenuAndPage(WorksCategoryVO.getPageIndex(),
						WorksCategoryVO.getPageSize(), WorksCategoryVO.getScreen_category());
			} else {
				// 所传是一级类别，
				worksList = worksDao.getWorksByFirstMenuAndPage(WorksCategoryVO.getPageIndex(),
						WorksCategoryVO.getPageSize(), WorksCategoryVO.getScreen_category());
			}
		}

		/*
		 * 
		 */
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
		}
		WorksCategoryVO.setWorksDTOList(worksDTOList);
		return WorksCategoryVO;
	}

	@Override
	public wlmtxt_works getWorksByFileName(String fileName) {
		return worksDao.getWorksByFileName(fileName);
	}

	public WorksDao getWorksDao() {
		return worksDao;
	};

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
			List<ReplyDTO> replyDTOList = new ArrayList<ReplyDTO>();
			for (wlmtxt_discuss reply : replyList) {
				ReplyDTO replyDTO = new ReplyDTO();
				//
				wlmtxt_user user = userService.get_user_byID(reply.getDiscuss_user_id());
				replyDTO.setUser(user);
				//
				replyDTO.setReply(reply);
				//
				replyDTOList.add(replyDTO);
			}

			discussDTO.setReplyDTO(replyDTOList);
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
	public List<WorksDTO> hotRecommend() {
		List<WorksDTO> worksDTOTemporaryList = new ArrayList<WorksDTO>();
		List<wlmtxt_works> worksListAll = worksDao.listWorksAll();

		// 获得DTO
		for (wlmtxt_works works : worksListAll) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOTemporaryList.add(worksDTO);
		}
		// 热度排序
		for (int i = 0; i < worksDTOTemporaryList.size() - 1; i++) {
			for (int j = 0; j < worksDTOTemporaryList.size() - i - 1; j++) {// 比较两个整数
				if (worksDTOTemporaryList.get(j).getHot() < worksDTOTemporaryList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOTemporaryList.get(j);
					worksDTOTemporaryList.set(j, worksDTOTemporaryList.get(j + 1));
					worksDTOTemporaryList.set(j + 1, temp);
				}
			}
		}
		// 取热度最高的前10个
		if (worksDTOTemporaryList.size() >= 10) {
			worksDTOTemporaryList = worksDTOTemporaryList.subList(0, 10);
		}

		// 再随机取六个
		List<WorksDTO> worksFinallyList = new ArrayList<WorksDTO>();
		int n_n = (worksDTOTemporaryList.size() >= 6 ? 6 : worksDTOTemporaryList.size());
		for (int n = 0; n < n_n; n++) {
			int random = (int) (Math.random() * worksDTOTemporaryList.size());
			worksFinallyList.add(worksDTOTemporaryList.get(random));
			worksDTOTemporaryList.remove(random);
		}

		return worksFinallyList;
	}

	@Override
	public boolean isCollectWorks(String user_id, String works_id) {
		wlmtxt_collect collect = worksDao.findCollect(user_id, works_id);
		if (collect == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isLiked(String userID, String worksID) {

		wlmtxt_like like = worksDao.findLike(userID, worksID);
		if (like == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void likWorks(wlmtxt_user user, wlmtxt_works works) {
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
					putMan.getUser_username() + "喜欢了您的作品" + putWorks.getWorks_title(), putWorks.getWorks_id());
			/*
			 * 
			 */
		} else {
			// 点赞了就取消点赞
			worksDao.removeLike(user.getUser_id(), works.getWorks_id());
		}
	}

	private List<wlmtxt_discuss> listDiscussByUserID(String user_id) {
		return worksDao.listDiscussByUserID(user_id);
	}

	@Override
	public List<wlmtxt_first_menu> listFirstMenu() {

		return worksDao.listFirstMenu();
	}

	@Override
	public List<wlmtxt_like> listLikeByUserID(String user_id) {
		return worksDao.listLikeByUserID(user_id);
	}

	@Override
	public List<FollowDTO> listMyAttentionDTO(String user_id) {
		List<FollowDTO> followDTOList = new ArrayList<FollowDTO>();

		List<wlmtxt_follow> followList = worksDao.listFollowByActiveID(user_id);

		for (wlmtxt_follow follow : followList) {
			FollowDTO followDTO = new FollowDTO();
			wlmtxt_follow mutualFollow = worksDao.findFollowByActiveUserId(user_id, follow.getFollow_passive_user_id());
			if (mutualFollow != null) {
				followDTO.setMutualFollow("1");
			} else {
				followDTO.setMutualFollow("2");
			}
			followDTO.setUser(userDao.get_user_byID(follow.getFollow_passive_user_id()));
			followDTOList.add(followDTO);
		}
		return followDTOList;
	}

	@Override
	public List<CollectDTO> listMycollectDTOList(String user_id) {
		List<CollectDTO> collectDTOList = new ArrayList<CollectDTO>();
		List<wlmtxt_collect> collecteList = listMycollectList(user_id);
		for (wlmtxt_collect collect : collecteList) {
			CollectDTO collectDTO = new CollectDTO();
			//
			collectDTO.setCollect(collect);
			//
			WorksDTO worksDTO = getWorksDTOByID(collect.getCollect_works_id());
			collectDTO.setWorksDTO(worksDTO);
			//
			collectDTOList.add(collectDTO);
		}

		return collectDTOList;
	}

	@Override
	public List<wlmtxt_collect> listMycollectList(String user_id) {
		return worksDao.listMycollectList(user_id);
	}

	@Override
	public List<DiscussWorkDTO> listMyDiscussWorkList(String user_id) {
		List<DiscussWorkDTO> listMyDiscussWorkList = new ArrayList<DiscussWorkDTO>();
		List<wlmtxt_discuss> discussList = listDiscussByUserID(user_id);
		for (wlmtxt_discuss discuss : discussList) {
			DiscussWorkDTO discussDTO = new DiscussWorkDTO();
			discussDTO.setDiscuss(discuss);
			//
			// 如果是回复，就不加入
			if (worksDao.getWorksByID(discuss.getDiscuss_father_discuss_id()) != null) {
				WorksDTO worksDTO = getWorksDTOByID(discuss.getDiscuss_father_discuss_id());
				discussDTO.setWorksDTO(worksDTO);
				//
				listMyDiscussWorkList.add(discussDTO);
			}
		}

		return listMyDiscussWorkList;
	}

	@Override
	public List<LikeDTO> listMyLikeList(String user_id) {
		List<LikeDTO> likeDTOList = new ArrayList<LikeDTO>();
		List<wlmtxt_like> likeList = listLikeByUserID(user_id);
		for (wlmtxt_like like : likeList) {
			LikeDTO likeDTO = new LikeDTO();
			likeDTO.setLike(like);
			//
			WorksDTO worksDTO = getWorksDTOByID(like.getLike_works_id());
			likeDTO.setWorksDTO(worksDTO);
			//
			likeDTOList.add(likeDTO);
		}

		return likeDTOList;
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
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenu() {
		return worksDao.listSecondMenu();
	}

	@Override
	public List<wlmtxt_second_menu> listSecondMenu_byFirstMenuID(String first_menu_id) {
		return worksDao.listSecondMenuByFirstMenuID(first_menu_id);
	}

	@Override
	public List<wlmtxt_notification> listUserNotification(String user_id) {
		List<wlmtxt_notification> notificationList = worksDao.listUserNotification(user_id);

		return notificationList;
	}

	@Override
	public List<NotificationDTO> listUserNotificationDTO(String user_id) {
		List<NotificationDTO> notificationDTOList = new ArrayList<NotificationDTO>();
		List<wlmtxt_notification> notificationList = listUserNotification(user_id);
		for (wlmtxt_notification notification : notificationList) {
			NotificationDTO notificationDTO = new NotificationDTO();
			//
			notificationDTO.setNotification(notification);
			//
			WorksDTO worksDTO = getWorksDTOByID(notification.getNotification_works());
			notificationDTO.setWorksDTO(worksDTO);
			//
			wlmtxt_user user = userService.get_user_byID(notification.getNotification_user_id());
			notificationDTO.setUser(user);
			//
			notificationDTOList.add(notificationDTO);
		}

		return notificationDTOList;
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
				if (worksDTOList.get(j).getHot() < worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 10) {
			if (worksDTOList.size() == 0) {
				return worksDTOList;
			}
			return worksDTOList.subList(0, worksDTOList.size());
		} else {
			return worksDTOList.subList(0, 10);
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
				if (worksDTOList.get(j).getHot() < worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 10) {
			if (worksDTOList.size() == 0) {
				return worksDTOList;
			}
			return worksDTOList.subList(0, worksDTOList.size());
		} else {
			return worksDTOList.subList(0, 10);
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
				if (worksDTOList.get(j).getHot() < worksDTOList.get(j + 1).getHot()) {
					WorksDTO temp = worksDTOList.get(j);
					worksDTOList.set(j, worksDTOList.get(j + 1));
					worksDTOList.set(j + 1, temp);
				}
			}
		}
		if (worksDTOList.size() < 10) {
			if (worksDTOList.size() == 0) {
				return worksDTOList;
			}
			return worksDTOList.subList(0, worksDTOList.size());
		} else {
			return worksDTOList.subList(0, 10);
		}
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
	public List<WorksDTO> listWorksByKeywordAndMenu(String worksID) {
		List<WorksDTO> worksDTOList = new ArrayList<WorksDTO>();
		//
		// List<KeyWordDTO> keyWordDTOList = new ArrayList<KeyWordDTO>();
		List<wlmtxt_works_keyword> keyWordList = worksDao.listKeyWordByByWorksID(worksID);
		List<wlmtxt_works> worksList = new ArrayList<wlmtxt_works>();
		/*
		 * 关键词推荐
		 */
		for (wlmtxt_works_keyword keyWord : keyWordList) {
			KeyWordDTO keyWordDTO = new KeyWordDTO();
			//
			keyWordDTO.setWorks_keyword(keyWord);
			// 取出了这个作品的所有关键词列表
			wlmtxt_keyword word = worksDao.getWordByID(keyWord.getWorks_keyword_keyword_id());
			// 遍历这个列表查询相同的关键词
			worksList.addAll(worksDao.listWorksByKeywordName(word.getKeyword_name()));
			// keyWordDTO.setKeyword(word);
			// keyWordDTOList.add(keyWordDTO);
		}
		//
		// TODO 按分类补充没写，数量控制没写
		/*
		 * 
		 */

		/*
		 * 
		 */
		for (wlmtxt_works works : worksList) {
			WorksDTO worksDTO = new WorksDTO();
			worksDTO = getWorksDTOByID(works.getWorks_id());
			worksDTOList.add(worksDTO);
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
	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) {
		worksDao.removeDownloadHistory(user, accept_works);
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

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}

	@Override
	public int totalFansNum(wlmtxt_user user) {
		return worksDao.totalFansNum(user.getUser_id());
	}

	@Override
	public int totalFollowingNum(wlmtxt_user user) {
		return worksDao.totalFollowingNum(user.getUser_id());
	}

	@Override
	public int totalPlayNum(String works_id) {
		int playCount = worksDao.totalPlayNum(works_id);
		return playCount;
	}

	@Override
	public int userPointWork(String userID, String worksID) {
		/*
		 * 
		 */
		// long startTime = System.currentTimeMillis();
		/*
		 * 
		 */
		int point = 0;
		// 播放加1分，查询有几条历史记录关于此作品
		int PlayHistoryListCount = worksDao.countUserPlayWorks(userID, worksID);
		point = point + PlayHistoryListCount * 1;
		if (PlayHistoryListCount == 0) {
			// 提前出去
			return 0;
		}
		// 点赞加3分
		if (isLiked(userID, worksID)) {
			point = point + 3;
		}
		// 评论加2分
		int discussCount = worksDao.getDiscussCountByUserIDAndWorkID(userID, worksID);
		point = point + 2 * discussCount;
		// 收藏加4分
		if (isCollectWorks(userID, worksID)) {
			point = point + 4;
		}
		// System.out.println("计算用户对作品的喜爱值" + point);
		/*
		 *
		 */
		// long stopTime = System.currentTimeMillis();
		// LOGGER.error("userPointWork：" + point + "；运行时间：" + (stopTime -
		// startTime) + "毫秒");
		/*
		 * 
		*/
		return point;
	}

	@Override
	public DevDTO devWorks(String wroksFirstID, String wroksSecondID, String currentUserID) {
		/*
		 * 
		 */
		// long startTime = System.currentTimeMillis();
		// LOGGER.error("开始时间：" + dateformat.format(startTime));
		/*
		 * 
		 */
		// 取出用户信息和作品信息

		List<String> userIDListAll = worksDao.listUserIDAll();
		//
		DevDTO devDTO = new DevDTO();
		// 差异值
		Double dev = 0.0;
		// 有效的用户数
		int validUserDevNum = 0;

		for (String otherUserID : userIDListAll) {
			// 跳过当前用户的喜爱值
			if (otherUserID.equals(currentUserID)) {
				continue;
			}
			// 对当前作品的评价
			int pointFirstWork = userPointWork(otherUserID, wroksFirstID);
			// System.out.println("pointFirstWork:" + pointFirstWork);
			if (pointFirstWork != 0) {
				// 对便利的作品的评价
				int pointSecondWork = userPointWork(otherUserID, wroksSecondID);
				// System.out.println("pointSecondWork:" + pointSecondWork);
				// 需要同时对两个作品有评价
				if (pointSecondWork != 0) {
					// 单个差异值为两个作品的评价相减
					dev = dev + (pointFirstWork - pointSecondWork);
					validUserDevNum++;
				} else {
					continue;
				}
			}

		}
		// 最终差异值要除以有效用户数
		dev = 0.0;
		if (validUserDevNum == 0) {
			dev = 0.0;
		} else {
			dev = dev / validUserDevNum;
		}

		/*
		 * 
		 */
		// long stopTime = System.currentTimeMillis();
		// LOGGER.error("结束时间：" + dateformat.format(stopTime));
		// LOGGER.error("WorksDev运行时间：" + (stopTime - startTime) + "毫秒");
		/*
		 * 
		 */
		devDTO.dev = dev;
		devDTO.validUserDevNum = validUserDevNum;
		return devDTO;
	}

}

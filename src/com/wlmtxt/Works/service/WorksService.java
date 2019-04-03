package com.wlmtxt.Works.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_notification;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DTO.CategoryDTO;
import com.wlmtxt.domain.DTO.CollectDTO;
import com.wlmtxt.domain.DTO.DiscussWorkDTO;
import com.wlmtxt.domain.DTO.FollowDTO;
import com.wlmtxt.domain.DTO.LikeDTO;
import com.wlmtxt.domain.DTO.NotificationDTO;
import com.wlmtxt.domain.DTO.PlayHistoryDTO;
import com.wlmtxt.domain.DTO.UserChartsDTO;
import com.wlmtxt.domain.DTO.WorksDTO;
import com.wlmtxt.domain.DTO.sf.DevDTO;
import com.wlmtxt.domain.VO.DynamicVO;
import com.wlmtxt.domain.VO.MyWorksVO;
import com.wlmtxt.domain.VO.WorksCategoryVO;
import com.wlmtxt.domain.VO.WorksDetailVO;

public interface WorksService {

	/**
	 * 添加通知
	 * 
	 * @param notification_user_id
	 * @param notification_type
	 * @param notification_content
	 */
	public void addNotification(String notification_user_id, String notification_type, String notification_content,
			String notification_work);

	public void addPlayHistoryByFileName(String fileName, String userID);

	/**
	 * 基于物品的协同过滤（Slope One）
	 * 
	 * @param userID
	 * @return
	 */
	public List<WorksDTO> collaborativeFilteringBySlopeOne(String WorksID, String userID);

	/**
	 * 基于用户的协同过滤 <br>
	 * 推荐相似用户的喜好
	 * 
	 * @param userID
	 * @return
	 */
	public List<WorksDTO> collaborativeFilteringByUser(String userID);

	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works);

	public int countCollectNum(String works_id);

	public int countLikeNum(String works_id);

	public void deleteAllMyHistory(String userID);

	public int deleteAllMyWorks(String user_id);

	public void deleteDisscuss(String discuss_id);

	public void deleteMyWorks(String works_id);

	public void deletePlayHistory(String play_history_id);

	/**
	 * 计算两个物品之间的差值 <br>
	 * 
	 * 
	 * @param wroksFirstID
	 * @param wroksSecondID
	 * @return
	 */
	public DevDTO devWorks(String wroksFirstID, String wroksSecondID, String currentUserID);

	public void discussWorks(wlmtxt_discuss accpet_discuss);

	public void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works);

	public int findPlayHistoryNumByFileName(String fileName);

	/**
	 * 预测
	 * 
	 * @param currentWorksID
	 * @param currentUserID
	 * @return
	 */
	Double forecastPoint(String currentWorksID, String currentUserID);

	public CategoryDTO getCategoryDTOByID(String menu_id);

	public int getCollectNum(String works_id);

	public int getDiscussNum(String works_id);

	public DynamicVO getDynamicVO(String user_id, DynamicVO dynamicVO);

	/**
	 * 获取单个作品的热度 <br>
	 * 播放1 点赞2 评论3 收藏4
	 * 
	 * @param works_id
	 * @return
	 */
	public int getHotByWorksID(String works_id);

	public int getLikeNum(String works_id);

	public MyWorksVO getMyWorksVO(String user_id, MyWorksVO myWorksVO);

	public int getPlayNum(String works_id);

	public WorksCategoryVO getWorksByCategoryPage(WorksCategoryVO worksCategoryVO);

	public wlmtxt_works getWorksByFileName(String fileName);

	public WorksDetailVO getWorksDetailVO(String works_id);

	public WorksDTO getWorksDTOByID(String works_id);

	/**
	 * 按热度排序前20条后，随机取6条。
	 * 
	 * @return
	 */
	public List<WorksDTO> hotRecommend();

	public boolean isCollectWorks(String user_id, String works_id);

	public boolean isLiked(String userID, String worksID);

	public void likWorks(wlmtxt_user user, wlmtxt_works works);

	public List<wlmtxt_first_menu> listFirstMenu();

	List<wlmtxt_like> listLikeByUserID(String user_id);

	public List<FollowDTO> listMyAttentionDTO(String user_id);

	public List<CollectDTO> listMycollectDTOList(String user_id);

	public List<wlmtxt_collect> listMycollectList(String user_id);

	public List<DiscussWorkDTO> listMyDiscussWorkList(String user_id);

	public List<LikeDTO> listMyLikeList(String user_id);

	List<PlayHistoryDTO> listPlayHistoryDTOListByUserID(String userID);

	public List<wlmtxt_play_history> listPlayHistoryListByUserID(String userID);

	public List<wlmtxt_play_history> listPlayHistoryListByWorksID(String worksID);

	public List<wlmtxt_second_menu> listSecondMenu();

	public List<wlmtxt_second_menu> listSecondMenu_byFirstMenuID(String first_menu_id);

	public List<wlmtxt_notification> listUserNotification(String user_id);

	public List<NotificationDTO> listUserNotificationDTO(String user_id);

	public List<WorksDTO> listWorks10OrderHotByDay();

	public List<WorksDTO> listWorks10OrderHotByMonth();

	public List<WorksDTO> listWorks10OrderHotByWeek();

	public List<WorksDTO> listWorksAll();

	public List<WorksDTO> listWorksByFirstMenuID(String second_menu_id);

	/**
	 * 
	 * @param worksID
	 * @return
	 */
	public List<WorksDTO> listWorksByKeywordAndMenu(String worksID);

	public List<WorksDTO> listWorksBySecondMenuID(String second_menu_id);

	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works);

	public void saveWorks(wlmtxt_works accept_works, String[] keywords);

	public int totalFansNum(wlmtxt_user loginUser);

	public int totalFollowingNum(wlmtxt_user loginUser);

	public int totalPlayNum(String works_id);

	/**
	 * 计算用户对某个作品的喜爱值 <br>
	 * 播放1 点赞3 评论2 收藏4
	 * 
	 * @param userID
	 * @param worksID
	 * @return
	 */
	public int userPointWork(String userID, String worksID);

	public List<UserChartsDTO> getUserChartsByUser(wlmtxt_user user);

}

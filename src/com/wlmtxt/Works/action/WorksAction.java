package com.wlmtxt.Works.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_notification;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.DTO.CategoryDTO;
import com.wlmtxt.domain.DTO.CollectDTO;
import com.wlmtxt.domain.DTO.LikeDTO;
import com.wlmtxt.domain.DTO.PlayHistoryDTO;
import com.wlmtxt.domain.DTO.WorksDTO;
import com.wlmtxt.domain.VO.DynamicVO;
import com.wlmtxt.domain.VO.MyAttentionVO;
import com.wlmtxt.domain.VO.MyWorksVO;
import com.wlmtxt.domain.VO.WorksDetailVO;

@SuppressWarnings("serial")
public class WorksAction extends ActionSupport {
	//
	WorksService worksService;
	//
	wlmtxt_user accept_user;
	wlmtxt_works accept_works;
	wlmtxt_discuss accpet_discuss;
	wlmtxt_first_menu first_menu;
	wlmtxt_second_menu second_menu;
	wlmtxt_play_history play_history;

	// 作品播放
	private String worksName;
	private String imgName;
	private InputStream inputStream;

	// 作品
	private File worksfile;
	private String worksfileFileName;
	private String worksfileContentType;

	// 封面
	private File imgfile;
	private String imgfileFileName;
	private String imgfileContentType;

	//
	private String keyword;
	//
	private MyWorksVO myWorksVO;
	// 我的关注页面列表
	private MyAttentionVO myAttentionVO;

	public MyAttentionVO getMyAttentionVO() {
		return myAttentionVO;
	}

	public void setMyAttentionVO(MyAttentionVO myAttentionVO) {
		this.myAttentionVO = myAttentionVO;
	}

	/*
	 * 跳转到播放页，作品对象存入值栈
	 */
	public String videoDetailsPage() {
		ActionContext.getContext().getValueStack().set("accept_works", accept_works);
		return "videoDetailsPage";
	}

	/*
	 * 
	 */

	public String getImg() throws FileNotFoundException {
		if (imgName.equals("") || imgName == null) {
			imgName = "";
		}
		File file = new File("C://wlmtxt/img/" + imgName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// file = new File("C://wlmtxt/video/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		return "getFile";
	}

	public String getVideo() throws FileNotFoundException {
		if (worksName.equals("") || worksName == null) {
			worksName = "";
		}
		File file = new File("C://wlmtxt/video/" + worksName);
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// file = new File("C://wlmtxt/video/NotFound.jpg");
			inputStream = new FileInputStream(file);
		}
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		worksService.addPlayHistoryByFileName(worksName, user.getUser_id());

		return "getFile";
	}

	/**
	 * 查询是否已点赞<br>
	 * 接收accept_works.works_id
	 * 
	 * 1-已点赞 2-未点赞
	 * 
	 * @throws Exception
	 */
	public void isLiked() throws Exception {

		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if (worksService.isLiked(user.getUser_id(), accept_works.getWorks_id())) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("2");
		}

	}

	/**
	 * 点赞及取消<br>
	 * 接收accept_works.works_id
	 * 
	 * @throws Exception
	 */
	public void likeWorks() throws Exception {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		worksService.likWorks(user, accept_works);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 获取该作品点赞数
	 * 
	 * @throws IOException
	 */
	public void getLikeNum() throws IOException {
		int num = worksService.getLikeNum(accept_works.getWorks_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(num + "");
	}

	public void getHotByWorksID() throws IOException {
		int num = worksService.getHotByWorksID(accept_works.getWorks_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(num + "");
	}

	/**
	 * 根据热度排序，取本日最多前十个作品
	 * 
	 * @throws IOException
	 */
	public void listWorks10OrderHotByDay() throws IOException {
		List<WorksDTO> worksDTOList = worksService.listWorks10OrderHotByDay();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 根据热度排序，取本周最多前十个作品
	 * 
	 * @throws IOException
	 */
	public void listWorks10OrderHotByWeek() throws IOException {
		List<WorksDTO> worksDTOList = worksService.listWorks10OrderHotByWeek();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 根据热度排序，取本月最多前十个作品
	 * 
	 * @throws IOException
	 */
	public void listWorks10OrderHotByMonth() throws IOException {
		List<WorksDTO> worksDTOList = worksService.listWorks10OrderHotByMonth();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 获取该作品收藏数
	 * 
	 * @throws IOException
	 */
	public void getCollectNum() throws IOException {
		int num = worksService.getCollectNum(accept_works.getWorks_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(num + "");
	}

	/**
	 * 获取该作品播放量
	 * 
	 * @throws IOException
	 */
	public void getPlayNum() throws IOException {
		int num = worksService.getPlayNum(accept_works.getWorks_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(num + "");
	}

	public void getCategoryDTOByID() throws IOException {
		CategoryDTO categoryDTO;
		if (first_menu != null) {
			categoryDTO = worksService.getCategoryDTOByID(first_menu.getFirst_menu_id());
		} else {
			categoryDTO = worksService.getCategoryDTOByID(second_menu.getSecond_menu_id());
		}

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(categoryDTO));
	}

	/**
	 * 我点赞的列表
	 */
	public void listLke() {
		// TODO
	}

	/**
	 * 查询是否已收藏<br>
	 * 接收accept_works.works_id
	 * 
	 * 1-已收藏 2-未收藏
	 * 
	 * @throws Exception
	 */
	public void isCollectWorks() throws Exception {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if (worksService.isCollectWorks(user.getUser_id(), accept_works.getWorks_id())) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("2");
		}
	}

	/**
	 * 收藏及取消，接收accept_works.works_id
	 */
	public void collectWorks() {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		try {
			worksService.collectWorks(user, accept_works);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("1");
		} catch (Exception e) {
			System.out.println("收藏失败");
			e.printStackTrace();
		}
	}

	/**
	 * 我收藏的列表
	 */
	public void listCollect() {
		// TODO
	}

	/**
	 * 删除下载历史,wlmtxt_download_history.download_history_id、
	 * wlmtxt_download_history.download_history_gmt_create
	 */
	public void removeDownloadHistory() {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		try {
			worksService.removeDownloadHistory(user, accept_works);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 我的下载历史列表 TODO
	 */
	public void listDownloadWorks() {

	}

	/**
	 * 评论，接收discuss.discuee_father_discuss_id父评论id：顶级评论则接收作品id，评论的回复评论则为上级评论id）
	 * TODO
	 * 
	 * @throws IOException
	 */
	public void discussWorks() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		accpet_discuss.setDiscuss_user_id(user.getUser_id());
		worksService.discussWorks(accpet_discuss);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	public void deletePlayHistory() throws IOException {
		worksService.deletePlayHistory(play_history.getPlay_history_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	public void deleteDisscuss() throws IOException {
		worksService.deleteDisscuss(accpet_discuss.getDiscuss_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	public void deleteAllMyHistory() throws IOException {

		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		worksService.deleteAllMyHistory(user.getUser_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 删除单个我的上传作品
	 * 
	 * 接收，works_id
	 * 
	 * 返回，1
	 * 
	 * @author zb
	 * 
	 * @throws IOException
	 */
	public void deleteMyWorks() throws IOException {
		worksService.deleteMyWorks(accept_works.getWorks_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 删除所有作品
	 * 
	 * 返回，1
	 * 
	 * @author gxr
	 * 
	 * @throws IOException
	 */
	public void deleteAllMyWorks() throws IOException {
		wlmtxt_user loginuser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		worksService.deleteAllMyWorks(loginuser.getUser_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 获取9条关注者的动态
	 * 
	 * @throws IOException
	 */
	public void getDynamicVO() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		DynamicVO dynamicVO = worksService.getDynamicVO(user.getUser_id());
		/*
		 * 
		 */
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(dynamicVO));
	}

	public void getWorksDetailVO() throws IOException {
		WorksDetailVO worksDetailVO = worksService.getWorksDetailVO(accept_works.getWorks_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDetailVO));
	}

	/**
	 * 获取所有的作品
	 * 
	 * @throws IOException
	 */
	public void listWorksAll() throws IOException {
		List<WorksDTO> worksDTOList = worksService.listWorksAll();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 根据登陆的的用户，获取他的所有通知
	 * 
	 * @throws IOException
	 */
	public void listUserNotification() throws IOException {
		List<wlmtxt_notification> notificationList = new ArrayList<wlmtxt_notification>();
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		notificationList = worksService.listUserNotification(user.getUser_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(notificationList));
	}

	/**
	 * 根据一级类别，获取二级类别
	 * 
	 * @throws IOException
	 */
	public void listSecondMenu_byFirstMenuID() throws IOException {
		List<wlmtxt_second_menu> secondMenuList = new ArrayList<wlmtxt_second_menu>();
		secondMenuList = worksService.listSecondMenu_byFirstMenuID(first_menu.getFirst_menu_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(secondMenuList));
	}

	public void listSecondMenu() throws IOException {
		List<wlmtxt_second_menu> secondMenuList = new ArrayList<wlmtxt_second_menu>();
		secondMenuList = worksService.listSecondMenu();

		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(secondMenuList));
	}

	public void listFirstMenu() throws IOException {
		List<wlmtxt_first_menu> firstMenuList = new ArrayList<wlmtxt_first_menu>();

		firstMenuList = worksService.listFirstMenu();
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(firstMenuList));
	}

	/**
	 * 根据一级类别获取相应的作品
	 * 
	 * @throws IOException
	 */
	public void listWorksByFirstMenuID() throws IOException {
		List<WorksDTO> worksDTOList = worksService.listWorksByFirstMenuID(first_menu.getFirst_menu_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 根据二级类别获取相应的作品
	 * 
	 * @throws IOException
	 */
	public void listWorksBySecondMenuID() throws IOException {
		System.out.println(second_menu.getSecond_menu_id());
		List<WorksDTO> worksDTOList = worksService.listWorksBySecondMenuID(second_menu.getSecond_menu_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(worksDTOList));
	}

	/**
	 * 我的动态
	 * 
	 * @author zb
	 * 
	 * @throws IOException
	 */
	public void getMyWorksListVO() throws IOException {

		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		myWorksVO = worksService.getMyWorksVO(user.getUser_id(), myWorksVO);
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(myWorksVO));
	}

	/**
	 * 上传作品
	 * 
	 * @throws IOException
	 */
	public void uploadWorks() throws IOException {

		// 处理封面
		if (imgfile != null) {

			String filePath;

			String fileName = UUID.randomUUID().toString()
					+ imgfileFileName.substring(imgfileFileName.lastIndexOf("."));

			filePath = "C://wlmtxt/img/" + fileName;

			File newFile = new File(filePath);

			try {
				FileUtils.copyFile(imgfile, newFile);
				accept_works.setWorks_cover(fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("封面：" + fileName);

		} else {
			System.out.println("未上传封面");
		}

		// 处理视频
		if (worksfile != null) {

			String filePath;

			String fileName = UUID.randomUUID().toString()
					+ worksfileFileName.substring(worksfileFileName.lastIndexOf("."));

			filePath = "C://wlmtxt/video/" + fileName;

			File newFile = new File(filePath);

			try {
				FileUtils.copyFile(worksfile, newFile);
				accept_works.setWorks_name(fileName);

			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("作品：" + fileName);

		} else {
			System.out.println("未上传视频");
		}

		// 作者
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		accept_works.setWorks_user_id(user.getUser_id());
		// 关键词
		if (!keyword.equals("") && null != keyword) {
			String[] keywords = keyword.split(";");

			worksService.saveWorks(accept_works, keywords);
			System.out.println(keywords);
		} else {
			worksService.saveWorks(accept_works, null);
		}
		// worksService.saveWorks(accept_works, null);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");
	}

	/**
	 * 播放页，统计作品播放次数
	 * 
	 * @date 2018年6月20日 下午6:20:23
	 * 
	 * @author gxr
	 * @throws IOException
	 *
	 */
	public void totalPlayNum() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int playCountNum = worksService.totalPlayNum(accept_works.getWorks_id());
		pw.write(playCountNum);
	}

	/**
	 * 播放页，统计收藏次数
	 * 
	 * @date 2018年6月20日 下午6:55:51
	 * 
	 * @author gxr
	 * @throws IOException
	 *
	 */
	public void countCollectNum() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int collectNum = worksService.countCollectNum(accept_works.getWorks_id());
		pw.write(collectNum);
	}

	/**
	 * 播放页，统计点赞量
	 * 
	 * @date 2018年6月20日 下午7:01:05
	 * 
	 * @author gxr
	 * @throws IOException
	 *
	 */
	public void countLikeNum() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int num = worksService.countLikeNum(accept_works.getWorks_id());
		pw.write(num);
	}
	
	/**
	 * 统计用户粉丝数
	 * 
	 * 接收，accpet_user.user_id
	 * 
	 * 返回，数量
	 * 
	 * @date 2018年6月22日	下午4:41:12
	 * 
	 * @author gxr
	 * 
	 * @throws IOException 
	 */
	public void totalFansNum() throws IOException {
//		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int num = worksService.totalFansNum(accept_user);
		pw.write(String.valueOf(num));
	}
	
	/**
	 * 统计我关注的用户数
	  * 
	 * 接收，accpet_user.user_id
	 * 
	 * 返回，数量
	 *  
	 * @date 2018年6月22日	下午4:43:31
	 * 
	 * @author gxr
	 * 
	 * @throws IOException 
	 */
	public void totalFollowingNum() throws IOException {
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int num = worksService.totalFollowingNum(accept_user);
		pw.write(String.valueOf(num));
	}

	/**
	 * 个人中心的搜索： 搜索我的动态（作品标题、二级分类）: 接收，option=dynamic, searchword; 返回分类列表
	 * 我的关注（用户昵称、邮箱）：接收，option=attention， searchword; 返回分类列表
	 * 我的粉丝（用户昵称、邮箱）：接收，option=fans， searchword; 返回分类列表
	 * 观看历史（作品标题、二级分类）：接收，option=playhistory， searchword; 返回分类列表
	 * 与我相关（作品标题、二级分类）：接收，option=relation， searchword; 返回分类列表
	 * 
	 * @date 2018年6月21日 下午4:43:04
	 * 
	 * @author gxr
	 * 
	 *         TODO
	 */
	public void search() {

	}

	/**
	 * 我的关注
	 * 
	 * 接收，页数
	 * 
	 * 返回，vo中1为已关注，2为未关注
	 * 
	 * @date 2018年6月21日 下午4:57:51
	 * 
	 * @author gxr
	 * 
	 *         XXX 待测试
	 * @throws IOException
	 */
	public void listMyAttentionVO() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		System.out.println("worksaction:" + myAttentionVO.toString());
		myAttentionVO = worksService.listMyAttentionVO(user.getUser_id(), myAttentionVO);
		System.out.println(myAttentionVO.toString());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(myAttentionVO));
	}

	/**
	 * 根据当前登录用户查看播放历史DTO
	 * 
	 * @throws IOException
	 */
	public void listPlayHistoryListByUserID() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		List<PlayHistoryDTO> playHistoryDTOList = worksService.listPlayHistoryDTOListByUserID(user.getUser_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(playHistoryDTOList));
	}

	/**
	 * 根据当前登录用户获取点赞列表的DTO
	 * 
	 * @throws IOException
	 */
	public void listMyLikeList() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		List<LikeDTO> likeDTOList = worksService.listMyLikeList(user.getUser_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(likeDTOList));
	}

	/**
	 * 根据当前登录用户获取收藏的列表DTO
	 * 
	 * @throws IOException
	 */
	public void listMyCollectList() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		List<CollectDTO> collectDTOList = worksService.listMycollectDTOList(user.getUser_id());
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();// 格式化json数据
		Gson gson = gsonBuilder.create();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(gson.toJson(collectDTOList));
	}

	public WorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

	public wlmtxt_user getAccept_user() {
		return accept_user;
	}

	public void setAccept_user(wlmtxt_user accept_user) {
		this.accept_user = accept_user;
	}

	public wlmtxt_works getAccept_works() {
		return accept_works;
	}

	public void setAccept_works(wlmtxt_works accept_works) {
		this.accept_works = accept_works;
	}

	public wlmtxt_discuss getAccpet_discuss() {
		return accpet_discuss;
	}

	public void setAccpet_discuss(wlmtxt_discuss accpet_discuss) {
		this.accpet_discuss = accpet_discuss;
	}

	public wlmtxt_first_menu getFirst_menu() {
		return first_menu;
	}

	public void setFirst_menu(wlmtxt_first_menu first_menu) {
		this.first_menu = first_menu;
	}

	public wlmtxt_second_menu getSecond_menu() {
		return second_menu;
	}

	public void setSecond_menu(wlmtxt_second_menu second_menu) {
		this.second_menu = second_menu;
	}

	public wlmtxt_play_history getPlay_history() {
		return play_history;
	}

	public void setPlay_history(wlmtxt_play_history play_history) {
		this.play_history = play_history;
	}

	public String getWorksName() {
		return worksName;
	}

	public void setWorksName(String worksName) {
		this.worksName = worksName;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getWorksfile() {
		return worksfile;
	}

	public void setWorksfile(File worksfile) {
		this.worksfile = worksfile;
	}

	public String getWorksfileFileName() {
		return worksfileFileName;
	}

	public void setWorksfileFileName(String worksfileFileName) {
		this.worksfileFileName = worksfileFileName;
	}

	public String getWorksfileContentType() {
		return worksfileContentType;
	}

	public void setWorksfileContentType(String worksfileContentType) {
		this.worksfileContentType = worksfileContentType;
	}

	public File getImgfile() {
		return imgfile;
	}

	public void setImgfile(File imgfile) {
		this.imgfile = imgfile;
	}

	public String getImgfileFileName() {
		return imgfileFileName;
	}

	public void setImgfileFileName(String imgfileFileName) {
		this.imgfileFileName = imgfileFileName;
	}

	public String getImgfileContentType() {
		return imgfileContentType;
	}

	public void setImgfileContentType(String imgfileContentType) {
		this.imgfileContentType = imgfileContentType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public void setMyWorksVO(MyWorksVO myWorksVO) {
		this.myWorksVO = myWorksVO;
	}

	public MyWorksVO getMyWorksVO() {
		return myWorksVO;
	}

}

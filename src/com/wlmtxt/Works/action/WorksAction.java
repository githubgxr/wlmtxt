package com.wlmtxt.Works.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_play_history;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

@SuppressWarnings("serial")
public class WorksAction extends ActionSupport {

	wlmtxt_user accept_user;
	wlmtxt_works accept_works;
	wlmtxt_discuss accpet_discuss;
	wlmtxt_first_menu first_menu;
	wlmtxt_second_menu second_menu;
	wlmtxt_play_history play_history;

	// 作品
	private File worksfile;
	private String worksfileFileName;
	private String worksfileContentType;

	// 封面
	private File imgfile;
	private String imgfileFileName;
	private String imgfileContentType;

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

	WorksService worksService;

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

	public WorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

	/**
	 * 查询是否已点赞<br>
	 * 接收accept_works.works_id
	 * 
	 * @throws Exception
	 */
	public void isLiked() throws Exception {

		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");

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
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");

		worksService.likWorks(user, accept_works);

		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("1");

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
	 * @throws Exception
	 */
	public void isCollectWorks() throws Exception {
		// TODO
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");
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
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");
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
	 * 下载，接收wlmtxt_download_history.download_history_id TODO
	 */
	public void downloadWorks() {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");
		try {
			worksService.downloadWorks(user, accept_works);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除下载历史,wlmtxt_download_history.download_history_id、
	 * wlmtxt_download_history.download_history_gmt_create
	 */
	public void removeDownloadHistory() {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");
		try {
			worksService.removeDownloadHistory(user, accept_works);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 我的下载历史列表
	 */
	public void listDownloadWorks() {

	}

	/**
	 * 评论，接收discuss.discuee_father_discuss_id父评论id：顶级评论则接收作品id，评论的回复评论则为上级评论id）
	 * TODO
	 */
	public void discussWorks() {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("wlmtxt_user");
		// worksService.discussWorks(user, accpet_discuss);
	}

	/**
	 * 上传作品
	 */
	public void uploadWorks() {
		// 处理其他数据
		System.out.println(accept_works);
		// 处理封面
		if (imgfile != null) {

			String filePath;

			String fileName = UUID.randomUUID().toString()
					+ imgfileFileName.substring(imgfileFileName.lastIndexOf("."));

			filePath = "c://wlmtxt/img/" + fileName;

			File newFile = new File(filePath);

			try {
				FileUtils.copyFile(imgfile, newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(fileName);

			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("1");
			} catch (Exception e) {
				System.out.println("2");
				e.printStackTrace();
			}

		} else {
			System.out.println("未上传封面");
		}

		// 处理视频
		if (worksfile != null) {

			String filePath;

			String fileName = UUID.randomUUID().toString()
					+ worksfileFileName.substring(worksfileFileName.lastIndexOf("."));

			filePath = "c://wlmtxt/img/" + fileName;

			File newFile = new File(filePath);

			try {
				FileUtils.copyFile(worksfile, newFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(fileName);

			try {
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("1");
			} catch (Exception e) {
				System.out.println("2");
				e.printStackTrace();
			}

		} else {
			System.out.println("未上传封面");
		}

	}

	/**
	 * 播放<br>
	 * TODO
	 */
	public void playWorks() {
		// TODO
	}

	/**
	 * 发布作品<br>
	 * TODO
	 */
	public void publishWords() {

	}

	/**
	 * 一级分类列表<br>
	 * TODO
	 */
	public void listWorksOfFirstMenu() {

	}

	/**
	 * 二级分类列表<br>
	 * TODO
	 */
	public void listWorksOfSecondMenu() {

	}

}

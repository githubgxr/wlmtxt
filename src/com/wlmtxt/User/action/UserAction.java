package com.wlmtxt.User.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.User.service.UserService;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;

import util.JavaMail;
import util.JsonUtils;
import util.ReflectUtil;
import util.TeamUtil;
import util.md5;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	private UserService userService;

	private wlmtxt_user accpet_user;
	// 上传头像
	private File touxiangfile;
	private String touxiangfileFileName;
	private String touxiangfileContentType;

	// 修改密码，新密码
	private String new_password;

	//

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	public void uploadTouXiang() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");

		// 处理封面
		if (touxiangfile != null) {

			String filePath;

			String fileName = UUID.randomUUID().toString()
					+ touxiangfileFileName.substring(touxiangfileFileName.lastIndexOf("."));

			filePath = "D://wlmtxt/img/" + fileName;

			File newFile = new File(filePath);

			try {
				FileUtils.copyFile(touxiangfile, newFile);

				wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
				user = userService.get_user_byID(user.getUser_id());
				userService.update_userImg(user.getUser_id(), fileName);

				response.getWriter().write("1");
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("头像：" + fileName);

		} else {
			System.out.println("未上传头像");
			response.getWriter().write("2");

		}
	}

	/**
	 * 登录<br />
	 * 1-成功<br />
	 * 2-失败
	 * 
	 * @throws IOException
	 */
	public void loign() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_user loginResult = userService.login(accpet_user);
		if (loginResult != null) {
			ActionContext.getContext().getSession().put("loginResult", loginResult);
			pw.write("1");
		} else {
			pw.write("2");
		}
	}

	/**
	 * 退出登录,清空session<br>
	 * 1-成功<br>
	 * 2-失败<br>
	 * 
	 * @throws IOException
	 */
	public String logout() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		ActionContext.getContext().getSession().remove("loginResult");
		pw.write("1");
		return "skipToIndexPage";
	}

	/**
	 * 1-验证邮件发送成功<br />
	 * 2-验证邮件发送失败
	 * 
	 * @throws IOException
	 */
	public void sendRegisterMail() throws IOException {
		// 加载邮件配置文件
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("javamail.properties"));
		String host = properties.getProperty("projecthost");
		String port = properties.getProperty("projectport");
		String content = properties.getProperty("mailcontent");
		String utf8_content = new String(content.getBytes("ISO-8859-1"), "utf-8");
		//昵称
		String nickname = new String(accpet_user.getUser_username().getBytes("ISO-8859-1"), "utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String href = "http://" + host + ":" + port + "/wlmtxt/User/User_skipActivatePage?accpet_user.user_mail="
				+ accpet_user.getUser_mail() + "&accpet_user.user_password="
				+ md5.GetMD5Code(accpet_user.getUser_password()) + "&accpet_user.user_username="
				+ nickname;
		// String href =
		// "http://localhost:8080/wlmtxt/User/User_skipActivatePage";
		// 邮件内容
		String mailcontent = "<p><a href=" + href + ">" + utf8_content + "</a></p>";
//		String utf8_mailcontent =  new String(mailcontent.getBytes("ISO-8859-1"), "utf-8");
		PrintWriter pw = response.getWriter();
		try {
			JavaMail.sendMail(mailcontent, accpet_user.getUser_mail());
			pw.write("1");
		} catch (Exception e) {
			pw.write("2");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return 跳转到激活页面
	 */
	public String skipActivatePage() {
		return "skipActivatePage";
	}

	/**
	 * 确认激活按钮
	 * <li>1-邮件激活成功
	 * <li>2-邮件激活失败
	 * 
	 * @throws IOException
	 */
	public void registerUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String registerResult = userService.saveUser(accpet_user);
		PrintWriter pw = response.getWriter();
		if ("1".equals(registerResult)) {
			pw.write("1");
		} else {
			// 页面显示激活链接失效,重新注册
			pw.write("2");
		}
	}

	/**
	 * 
	 * 验证邮箱是否已注册<br>
	 * 1-未注册过<br />
	 * 2-注册过<br />
	 * 
	 * @throws IOException
	 */
	public void mailRegisted() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		wlmtxt_user registedUser = userService.mailRegisted(accpet_user);
		PrintWriter pw = response.getWriter();
		if (registedUser == null) {
			pw.write("1");
		} else {
			pw.write("2");
		}
	}

	/**
	 * 判断是否已经登录<br>
	 * 
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public void isLogin() throws IOException, IllegalArgumentException, IllegalAccessException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");

		PrintWriter pw = response.getWriter();

		if (user != null) {
			user = userService.get_user_byID(user.getUser_id());
			// 对象属性值为null替换为""
			ReflectUtil.getAllField(user);
			pw.write(JsonUtils.toJson(user));
		} else {
			pw.write("2");
		}
	}

	/**
	 * 修改个人资料<br>
	 * 
	 * 接收用户显式输入框的所有参数<br>
	 * 
	 * 1-修改失败<br>
	 * 2-修改成功
	 * 
	 * @throws IOException
	 * 
	 */
	public void modifyPersonalData() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		loginUser = userService.get_user_byID(loginUser.getUser_id());
		PrintWriter pw = response.getWriter();
		loginUser.setUser_username(accpet_user.getUser_username());
		loginUser.setUser_mail(accpet_user.getUser_mail());
		loginUser.setUser_sex(accpet_user.getUser_sex());
		loginUser.setUser_bio(accpet_user.getUser_bio());
		String modifyResult = userService.modifyPersonalData(loginUser);
		if ("1".equals(modifyResult)) {
			pw.write("1");
		} else {
			pw.write("2");
		}

	}

	/**
	 * 登录后修改密码<br>
	 * 
	 * 接收参数，新密码:new_password<br>
	 * 
	 * 1-修改成功<br>
	 * 2-修改失败<br>
	 * 3-原密码错误，修改失败<br>
	 * 
	 * @throws IOException
	 */
	public void modifyPassword() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		loginUser = userService.get_user_byID(loginUser.getUser_id());
		if ((md5.GetMD5Code(accpet_user.getUser_password())).equals(loginUser.getUser_password())) {
			loginUser.setUser_password(md5.GetMD5Code(new_password));
			String result = userService.modifyPassword(loginUser);
			if (result != null) {
				pw.write("1");
			} else {
				pw.write("2");
			}
		} else {
			pw.write("3");
		}
	}

	/**
	 * 发送忘记密码的验证邮件
	 * 
	 * 1-发送成功
	 * 2-发送失败
	 * 
	 * @date 2018年6月21日	下午2:39:32
	 * 
	 * @author gxr
	 * 
	 * TODO
	 * @throws IOException 
	 */
	public void sendMailOfForgotPassword() throws IOException {
		//加载邮件配置文件
		Properties properties = new Properties();
		properties.load(this.getClass().getClassLoader().getResourceAsStream("javamail.properties"));
		String host = properties.getProperty("projecthost");
		String port = properties.getProperty("projectport");
		String content = properties.getProperty("mailcontent");
		String utf8_content = new String(content.getBytes("ISO-8859-1"), "utf-8");
		//昵称
//		String nickname = new String(accpet_user.getUser_username().getBytes("ISO-8859-1"), "utf-8");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String href = "http://"+host+":"+port+"/wlmtxt/User/User_skipToModifyPasswordPage?accpet_user.user_mail=" + accpet_user.getUser_mail();
		// 邮件内容
		String mailcontent = "<p><a href=" + href + ">"+utf8_content+"</a></p>";
		PrintWriter pw = response.getWriter();
		try {
			JavaMail.sendMail(mailcontent, accpet_user.getUser_mail());
			pw.write("1");
		} catch (Exception e) {
			pw.write("2");
			e.printStackTrace();
		}
	}
	/**
	 * 跳转到忘记密码后，输入新密码页面
	 * 
	 * @return
	 */
	public String skipToModifyPasswordPage() {
		return "skipToModifyPasswordPage";
	}
	
	/**
	 * 输入新密码后，确认修改密码
	 * 
	 * 接收，user_mail, user_password
	 * 
	 * 返回，1-修改成功， 2-修改失败
	 * 
	 * @date 2018年6月21日	下午2:38:30
	 * 
	 * @author gxr
	 * 
	 * TODO
	 * @throws IOException 
	 */
	public void modifiedPasswordBehindForgetted() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//获取此邮箱的用户信息
		wlmtxt_user user = userService.mailRegisted(accpet_user);
		user.setUser_password(md5.GetMD5Code(accpet_user.getUser_password()));
		user.setUser_gmt_modified(TeamUtil.getStringSecond());
		String registerResult = userService.modifyPassword(user);
		PrintWriter pw = response.getWriter();
		if ("1".equals(registerResult)) {
			pw.write("1");
		} else {
			pw.write("2");
		}
	}
	
	
	/**
	 * 得到用户头像
	 * 
	 * @throws IOException
	 */
	/*
	 * public void getUserAvatar() throws IOException { HttpServletResponse
	 * response = ServletActionContext.getResponse(); wlmtxt_user user =
	 * (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
	 * // 头像后缀名 String suffix =
	 * user.getUser_avatar().substring((user.getUser_avatar().indexOf(".") +
	 * 1)); // 头像位置 String filename = "c:/wlmtxt/avatar/" +
	 * user.getUser_avatar(); if ("png".equals(suffix)) {
	 * response.setContentType("image/png"); } else if ("jpg".equals(suffix)) {
	 * response.setContentType("image/jpeg"); } else if ("jpeg".equals(suffix))
	 * { response.setContentType("image/jpeg"); } else if ("gif".equals(suffix))
	 * { response.setContentType("image/gif"); } else if ("bmp".equals(suffix))
	 * { response.setContentType("image/bmp"); } else if ("tiff".equals(suffix))
	 * { response.setContentType("image/tiff"); } else {
	 * response.setContentType("image/jpeg"); }
	 * response.setHeader("Content-Disposition", "attachment;filename=" +
	 * filename); OutputStream os = response.getOutputStream(); InputStream is =
	 * new FileInputStream(filename); byte[] buffer = new byte[1024]; int i =
	 * -1; while ((i = is.read(buffer)) != -1) { os.write(buffer, 0, i); }
	 * os.flush(); os.close(); is.close(); }
	 */

	/**
	 * 查询用户是否已关注
	 * 
	 * 1-已关注 2-未关注
	 *
	 * @date 2018年6月20日 下午6:09:21
	 * 
	 * @author gxr
	 * @throws IOException
	 *
	 * XXX 
	 */
	public void isFollowedUser() throws IOException {
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		if (userService.isFollowedUser(user.getUser_id(), accpet_user.getUser_id())) {
			response.getWriter().write("1");
		} else {
			response.getWriter().write("2");
		}
	}

	/**
	 * 关注用户及取消关注
	 * 
	 * 1-成功 2-失败 3-未登录
	 * 
	 * @throws IOException
	 * 
	 * @author gxr
	 * 
	 * XXX
	 */
	public void followUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		if (null != loginUser) {
			if (userService.isFollowedUser(loginUser.getUser_id(), accpet_user.getUser_id())) {
				// 取关
				String result = userService.removeFollow(loginUser, accpet_user);
				if ("1".equals(result)) {
					pw.write("1");
				} else {
					pw.write("2");
				}
			} else {
				// 关注
				String followResult = userService.followUser(accpet_user.getUser_id(), loginUser);
				if ("1".equals(followResult)) {
					pw.write("1");
				} else {
					pw.write("2");
				}
			}
		} else {
			pw.write("3");
		}
	}
	
	/**
	 * 取消全部关注的用户
	 * 
	 * 返回，1-取关成功，2-取关失败
	 * 
	 * @date 2018年6月21日	下午7:47:25
	 * 
	 * @author gxr
	 * @throws IOException 
	 * 
	 * XXX
	 */
	public void deleteAllMyFollow() throws IOException {
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		int result = userService.deleteAllMyFollow(loginUser);
		if (result > 0) {
			pw.write("1");
		} else {
			pw.write("2");
		}
	}
	
	/**
	 * 关注所有粉丝
	 * 
	 * 返回，1-成功，2-失败
	 * 
	 * @date 2018年6月21日	下午8:14:30
	 * 
	 * @author gxr
	 * 
	 * @throws IOException 
	 * 
	 * XXX
	 */
	public void noticeAllMyFans() throws IOException {
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		 try {
			userService.noticeAllMyFans(loginUser);
			pw.write("1");
		} catch (Exception e) {
			pw.write("2");
			e.printStackTrace();
		}
	}
	
	/**
	 * 我的粉丝列表
	 * 
	 * @date 2018年6月22日	上午10:52:53
	 * 
	 * @author gxr
	 * 
	 * TODO
	 * @throws IOException 
	 */
	public void listMyFansVO() throws IOException {
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
//		List<wlmtxt_user> list = userService.listMyFansVO(loginUser);
	}
	
	/**
	 * XXX此方法被重复，不要用
	 * 
	 * 关注单个粉丝，
	 * 
	 * 返回，1-成功，2-失败
	 * 
	 * @date 2018年6月21日	下午8:42:33
	 * 
	 * @author gxr
	 * 
	 * @throws IOException 
	 * 
	 * XXX
	 */
	public void noticeMyFans() throws IOException {
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			userService.noticeMyFans(loginUser, accpet_user);
			pw.write("1");
		} catch (Exception e) {
			pw.write("2");
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 我的动态
	 * 
	 * @throws IOException
	 */
	public void MyDynamic() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		if (loginUser == null) {
			// userService.MyDynamic(loginUser);
		} else {
			pw.write("3");
		}
		loginUser = userService.get_user_byID(loginUser.getUser_id());

	}

	public String skipToIndexPage() {
		return "skipToIndexPage";
	}

	/**
	 * 跳转到分类页
	 * 
	 * @return
	 */
	public String skipToCategoryPage() {
		return "skipToCategoryPage";
	}

	/**
	 * 跳转到排行榜页面
	 * 
	 * @return
	 */
	public String skipToRankPage() {
		return "skipToRankPage";
	}

	/**
	 * 跳转到发布作品页面
	 * 
	 * @return
	 */
	public String skipToPublishWorksPage() {
		return "skipToPublishWorksPage";
	}

	/**
	 * 跳转到个人中心页面
	 * 
	 * @return
	 *//*
		 * public String skipToPersonalCenterPage() { return
		 * "skipToMyDynamicPage"; }
		 */
	/**
	 * 跳转到我的动态页面
	 * 
	 * @return
	 */
	public String skipToMyDynamicPage() {
		return "skipToMyDynamicPage";
	}

	/**
	 * 跳转到个人资料页
	 * 
	 * @return
	 */
	public String skipToPersonalDataPage() {
		return "skipToPersonalDataPage";
	}

	/**
	 * 跳转到我的关注页面
	 * 
	 * @return
	 */
	public String skipToMyAttentionPage() {
		return "skipToMyAttentionPage";
	}

	/**
	 * 跳转到我的粉丝页面
	 * 
	 * @return
	 */
	public String skipToMyFansPage() {
		return "skipToMyFansPage";
	}

	/**
	 * 跳转到播放历史页面
	 * 
	 * @return
	 */
	public String skipToWatchHistoryPage() {
		return "skipToWatchHistoryPage";
	}

	/**
	 * 跳转到与我相关之我的收藏页面
	 * 
	 * @return
	 */
	public String skipToRelationCollectionPage() {
		return "skipToRelationCollectionPage";
	}

	/**
	 * 跳转到与我相关之我的点赞页面
	 * 
	 * @return
	 */
	public String skipToRelationAppreciatesPage() {
		return "skipToRelationAppreciatesPage";
	}

	/**
	 * 跳转到与我相关之我的评论页面
	 * 
	 * @return
	 */
	public String skipToRelationCommentsPage() {
		return "skipToRelationCommentsPage";
	}

	/**
	 * 跳转到消息中心之点赞通知页
	 * 
	 * @return
	 */
	public String skipToAppreciatesNoticePage() {
		return "skipToAppreciatesNoticePage";
	}

	/**
	 * 跳转到消息中心之收藏通知页
	 * 
	 * @return
	 */
	public String skipToCollectionNoticePage() {
		return "skipToCollectionNoticePage";
	}

	/**
	 * 跳转到消息中心之评论通知页
	 * 
	 * @return
	 */
	public String skipToCommentsNoticePage() {
		return "skipToCommentsNoticePage";
	}

	/**
	 * 跳转到消息中心之审核通知页
	 * 
	 * @return
	 */
	public String skipToAuditNoticePage() {
		return "skipToAuditNoticePage";
	}

	/**
	 * 跳转到播放页
	 * 
	 * @return
	 */
	public String skipToPlayPage() {
		return "skipToPlayPage";
	}

	/**
	 * 
	 * 返回所有的上传作品一级分类 如果未空，返回2
	 * 
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * 
	 */
	public void listSecondOfMyWorks() throws IOException, IllegalArgumentException, IllegalAccessException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_user loginUser = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		// List<wlmtxt_works_keyword> listWorksKeyword =
		// userService.listSecondOfMyWorks(loginUser.getUser_id());
		List<wlmtxt_first_menu> listFirstMenu = userService.listFirstMenu(loginUser.getUser_id());
		if (listFirstMenu != null) {
			ReflectUtil.getAllField(listFirstMenu);
			pw.write(JsonUtils.toJson(listFirstMenu));
		} else {
			pw.write("2");
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public wlmtxt_user getAccpet_user() {
		return accpet_user;
	}

	public void setAccpet_user(wlmtxt_user accpet_user) {
		this.accpet_user = accpet_user;
	}

	public File getTouxiangfile() {
		return touxiangfile;
	}

	public void setTouxiangfile(File touxiangfile) {
		this.touxiangfile = touxiangfile;
	}

	public String getTouxiangfileFileName() {
		return touxiangfileFileName;
	}

	public void setTouxiangfileFileName(String touxiangfileFileName) {
		this.touxiangfileFileName = touxiangfileFileName;
	}

	public String getTouxiangfileContentType() {
		return touxiangfileContentType;
	}

	public void setTouxiangfileContentType(String touxiangfileContentType) {
		this.touxiangfileContentType = touxiangfileContentType;
	}
}

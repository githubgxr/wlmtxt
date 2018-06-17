package com.wlmtxt.User.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.User.service.UserService;
import com.wlmtxt.domain.DO.wlmtxt_user;

import util.AvatarFile;
import util.JavaMail;
import util.JsonUtils;

public class UserAction extends ActionSupport {

	private UserService userService;
	private wlmtxt_user accpet_user;

	public wlmtxt_user getAccpet_user() {
		return accpet_user;
	}

	public void setAccpet_user(wlmtxt_user accpet_user) {
		this.accpet_user = accpet_user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	/**
	 * 登录<br />
	 * 1-成功<br />
	 * 2-失败
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
	 * @throws IOException 
	 */
	public void logout() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		try {
			ActionContext.getContext().getSession().remove("loginResult");
			pw.write("1");
		} catch (Exception e) {
			pw.write("2");
		}
	}
	/**
	 * 1-验证邮件发送成功<br />
	 * 2-验证邮件发送失败
	 * @throws IOException 
	 */
	public void sendRegisterMail() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		//此返回值无作用
//		String str = userService.saveUser(accpet_user);
		String href = "http://localhost:8080/wlmtxt/User_skipActivatePage?accpet_user.user_mail=1074545235@qq.com&accpet_user.user_password=111111&accpet_user.user_username=小官";
//		String href = "http://localhost:8080/wlmtxt/User_registerUser?accpet_user.user_mail="+accpet_user.getUser_mail()+"&accpet_user.user_password="+accpet_user.getUser_password()+"&accpet_user.user_username"+accpet_user.getUser_username();
//		String href = "http://localhost:8080/wlmtxt/User_skipActivatePage";
		//邮件内容
		String mailcontent = "<p><a href="+href+">register</a></p>";
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
		return "activatePage";
	}
	/**
	 * 确认激活按钮
	 * <li>1-邮件激活成功
	 * <li>2-邮件激活失败
	 * @throws IOException 
	 */
	public void registerUser() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		String registerResult = userService.saveUser(accpet_user);
		PrintWriter pw =  response.getWriter();
		if ("1".equals(registerResult)) {
			pw.write("1");
		} else {
			//页面显示激活链接失效,重新注册
			pw.write("2");
		}
	}
	/**
	 * 验证邮箱是否已注册<br>
	 * 1-未注册过<br />
	 * 2-注册过<br />
	 * @throws IOException 
	 */
	public void mailRegisted() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		wlmtxt_user registedUser= userService.mailRegisted(accpet_user);
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
	 */
	public void isLogin() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		PrintWriter pw = response.getWriter();
		if (user != null) {
			pw.write(JsonUtils.toJson(user));
		} else {
			pw.write("2");
		}
	}
	/**
	 * 得到用户头像
	 * @throws IOException 
	 * TODO 未测试
	 */
	public void getUserAvatar() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		wlmtxt_user user = (wlmtxt_user) ActionContext.getContext().getSession().get("loginResult");
		//头像后缀名
		String suffix = user.getUser_avatar().substring((user.getUser_avatar().indexOf(".")+1));
		//头像位置
		String filename = "c:/wlmtxt/avatar/" + user.getUser_avatar();
		if ("png".equals(suffix)) {
			response.setContentType("image/png");
		} else if ("jpg".equals(suffix)) {
			response.setContentType("image/jpeg");
		} else if ("jpeg".equals(suffix)) {
			response.setContentType("image/jpeg");
		} else if ("gif".equals(suffix)) {
			response.setContentType("image/gif");
		} else if ("bmp".equals(suffix)) {
			response.setContentType("image/bmp");
		} else if ("tiff".equals(suffix)) {
			response.setContentType("image/tiff");
		} else {
			response.setContentType("image/jpeg");
		}
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		OutputStream os = response.getOutputStream();
		InputStream is = new FileInputStream(filename);
		byte[] buffer = new byte[1024];
		int i = -1;
		while ((i = is.read(buffer)) != -1) {
		    os.write(buffer, 0, i);
		}
		os.flush();
		os.close();
		is.close();
	}
	/**
	 * 关注用户
	 * TODO
	 */
	public void 	followUser() {
		
	}
	/**
	 * 修改密码
	 * TODO
	 */
	public void modifyPassword() {
		
	}
	
}

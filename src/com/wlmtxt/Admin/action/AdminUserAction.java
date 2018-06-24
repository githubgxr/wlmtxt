package com.wlmtxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Admin.service.AdminUserService;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.VO.DiscussVO;
import com.wlmtxt.domain.VO.UserVO;

public class AdminUserAction extends ActionSupport {
private AdminUserService adminuserService;
private wlmtxt_user user;
private String userIDAll;
private UserVO userVO;
private DiscussVO discussVO;
public UserVO getUserVO() {
	return userVO;
}

public void setUserVO(UserVO userVO) {
	this.userVO = userVO;
}

public wlmtxt_user getUser() {
	return user;
}

public void setUser(wlmtxt_user user) {
	this.user = user;
}

public String getUserIDAll() {
	return userIDAll;
}

public void setUserIDAll(String userIDAll) {
	this.userIDAll = userIDAll;
}


public DiscussVO getDiscussVO() {
	return discussVO;
}

public void setDiscussVO(DiscussVO discussVO) {
	this.discussVO = discussVO;
}

public AdminUserService getAdminuserService() {
	return adminuserService;
}

public void setAdminuserService(AdminUserService adminuserService) {
	this.adminuserService = adminuserService;
}

/*
 * 用户权限的修改
 */
public void updateUser_authority() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(adminuserService.updateUser_authority(user)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 用户的删除
 */
public void deleteUser() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(adminuserService.deleteUser(userIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 用户的查询/分页列表
 */
public void getUserListBysearchPage() throws IOException{
	adminuserService.getUserListBysearchPage(userVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(userVO));
}
/*
 * 根据id得到单条记录
 */
public void getUserById() throws IOException{
	user = adminuserService.getUserById(user.getUser_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(user));
}
/*
 * 得到评论列表
 */
public void getdiscussListBysearchPage() throws IOException{
	adminuserService.getdiscussListBysearchPage(discussVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(discussVO));
}
/*
 * 跳转信息管理
 */
public String list_user(){
	return "list_user";
}
/*
 * 跳转评论管理
 */
public String page_list_discuss(){
	return "page_list_discuss";
}
}


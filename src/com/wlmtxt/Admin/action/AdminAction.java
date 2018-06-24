package com.wlmtxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Admin.service.AdminService;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DTO.CategoryListDTO;
import com.wlmtxt.domain.VO.AdminVO;


public class AdminAction extends ActionSupport {

	private AdminService adminService;
	private wlmtxt_admin admin;
	private wlmtxt_first_menu first_menu;
	private List<wlmtxt_first_menu> First_menuList ;
	private wlmtxt_second_menu second_menu;
	private String adminIDAll;
	private AdminVO adminVO;
	public wlmtxt_first_menu getFirst_menu() {
		return first_menu;
	}
	public void setFirst_menu(wlmtxt_first_menu first_menu) {
		this.first_menu = first_menu;
	}
	
	public String getAdminIDAll() {
		return adminIDAll;
	}
	public void setAdminIDAll(String adminIDAll) {
		this.adminIDAll = adminIDAll;
	}
	public AdminVO getAdminVO() {
		return adminVO;
	}
	public void setAdminVO(AdminVO adminVO) {
		this.adminVO = adminVO;
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public wlmtxt_admin getAdmin() {
		return admin;
	}
	public void setAdmin(wlmtxt_admin admin) {
		this.admin = admin;
	}
	
	public List<wlmtxt_first_menu> getFirst_menuList() {
		return First_menuList;
	}
	public void setFirst_menuList(List<wlmtxt_first_menu> first_menuList) {
		First_menuList = first_menuList;
	}

	public wlmtxt_second_menu getSecond_menu() {
		return second_menu;
	}
	public void setSecond_menu(wlmtxt_second_menu second_menu) {
		this.second_menu = second_menu;
	}
	/*
	 * 管理员登录
	 */
	public  void admin_login() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		wlmtxt_admin loginResult = adminService.adminLogin(admin);
		if (loginResult != null) {
			ActionContext.getContext().getSession().put("adminLoginResult", loginResult);
			pw.write("1");
		} else {
			pw.write("2");
		}
		
	}
	/*
	 * 一级分类的添加
	 */
	public void addFirst_menu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.addFirst_menu(first_menu)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 二级分类的添加
	 */
	public void addSecond_menu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.addSecond_menu(second_menu)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 一级分类的删除
	 */
	public void deleteFirst_munu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.deleteFirst_munu(first_menu.getFirst_menu_id())){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 二级菜单的删除
	 */
	public void deleteSecond_menu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.deleteSecond_menu(second_menu.getSecond_menu_id())){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 一级菜单的修改
	 */
	public void updateFirst_menu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.updateFirst_menu(first_menu)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 二级菜单的修改
	 */
	public void updateSecond_menu() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.updateSecond_menu(second_menu)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 根据一级菜单id得到单个一级菜单的记录
	 */
	public void  getFirst_menuById() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		 GsonBuilder gsonBuilder = new GsonBuilder();
	 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
	 	 Gson gson = gsonBuilder.create();
	 		first_menu = adminService.getFirst_menuById(first_menu.getFirst_menu_id());
		if(first_menu!=null){
			pw.write(gson.toJson(first_menu));	
		}else{
			pw.write("2");
		}
	}
	/*
	 * 根据二级菜单id得到二级菜单
	 */
	public void getSecondById() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		 GsonBuilder gsonBuilder = new GsonBuilder();
	 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
	 	 Gson gson = gsonBuilder.create();
	 	second_menu = adminService.getSecondById(second_menu.getSecond_menu_id());
		if(second_menu!=null){
			pw.write(gson.toJson(second_menu));	
		}else{
			pw.write("2");
		}
	}
	/*
	 * 菜单列表
	 */
	public String page_list_category() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		List<CategoryListDTO> categoryListDTO = adminService.listCategoryOneAndSon();
		ActionContext.getContext().getValueStack().set("categoryListDTO", categoryListDTO);
		return "page_list_category";
	}
	/*
	 * 	 管理员的添加
	 */
	public void addAdmin() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.addAdmin(admin)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	
	/*
	 * 管理员的修改
	 */
	public void updateAdmin() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		System.out.println(admin+"aaaaaaa");
		if(adminService.updateAdmin(admin)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 管理员的删除
	 */
	public void deleteAdmin() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(adminService.deleteAdmin(adminIDAll)){
			pw.write("1");
		}else{
			pw.write("2");
		}
	}
	/*
	 * 管理员的查询/分页列表
	 */
	public void getAdminListBysearchPage() throws IOException{
		adminService.getAdminListBysearchPage(adminVO);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		 GsonBuilder gsonBuilder = new GsonBuilder();
	 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
	 	 Gson gson = gsonBuilder.create();
	 	 pw.write(gson.toJson(adminVO));
	}
	/*
	 * 根据id得到管理员信息
	 */
	public void getAdminById() throws IOException{
		admin = adminService.getAdminById(admin.getAdmin_id());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		GsonBuilder gsonBuilder = new GsonBuilder();
	 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
	 	 Gson gson = gsonBuilder.create();
	 	 pw.write(gson.toJson(admin));
	}
	/**
	 * 跳转登录成功页
	 * @return
	 */
	public String login() {
		System.out.println("dd");
		return "index";
	}
	
	public String logout() {
		return "logout";
	}
	/**
	 * 跳转到轮播图列表页
	 * @return
	 */
	public String list_carousel_page() {
		return "list_carousel_page";
	}
	/**
	 * 跳转到轮播图添加页
	 * @return
	 */
	public String add_carousel_page() {
		return "add_carousel_page";
	}
	/**
	 * 跳转到作品列表页去管理作品
	 * @return
	 */
	public String list_works_page() {
		return "list_works_page";
	}
	/**
	 * 跳转到用户列表页管理权限
	 * @return
	 */
	public String list_user_page() {
		return "list_user_page";
	}
	/**
	 * 跳转到评论列表页管理评论
	 * @return
	 */
	public String list_discuss_page() {
		return "list_discuss_page";
	}
	/**
	 * 跳转到管理员列表页
	 * @return
	 */
	public String list_admin_page() {
		return "list_admin_page";
	}
	/**
	 * 跳转到修改管理员密码页面
	 * @return
	 */
	public String modified_adminPassword_page() {
		return "modified_adminPassword_page";
	}
	
	public String count_page() {
		return "count_page";
	}
	/*
	 * 跳转管理员
	 */
	public String list_admin(){
		return "list_admin";
	}
	
}

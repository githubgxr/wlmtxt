package com.wlmtxt.Admin.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Admin.service.AdminService;

public class AdminAction extends ActionSupport {

	private AdminService adminService;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	/**
	 * 跳转登录成功页
	 * @return
	 */
	public String login() {
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
}

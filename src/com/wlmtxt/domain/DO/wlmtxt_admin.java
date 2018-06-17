package com.wlmtxt.domain.DO;

public class wlmtxt_admin {
	//id
	private String admin_id;
	//用户名
	private String admin_username;
	//密码
	private String admin_password;
	//是否超级管理员
	private String admin_admin;
	//创建时间
	private String admin_gmt_create;
	//修改时间
	private String admin_gmt_modified;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}
	public String getAdmin_admin() {
		return admin_admin;
	}
	public void setAdmin_admin(String admin_admin) {
		this.admin_admin = admin_admin;
	}
	public String getAdmin_gmt_create() {
		return admin_gmt_create;
	}
	public void setAdmin_gmt_create(String admin_gmt_create) {
		this.admin_gmt_create = admin_gmt_create;
	}
	public String getAdmin_gmt_modified() {
		return admin_gmt_modified;
	}
	public void setAdmin_gmt_modified(String admin_gmt_modified) {
		this.admin_gmt_modified = admin_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_admin [admin_id=" + admin_id + ", admin_username=" + admin_username + ", admin_password="
				+ admin_password + ", admin_admin=" + admin_admin + ", admin_gmt_create=" + admin_gmt_create
				+ ", admin_gmt_modified=" + admin_gmt_modified + "]";
	}
	
}

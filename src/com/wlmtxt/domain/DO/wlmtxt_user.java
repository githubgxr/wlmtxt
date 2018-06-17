package com.wlmtxt.domain.DO;

public class wlmtxt_user {
	//id
	private String user_id;
	//用户名（昵称）
	private String user_username;
	//密码
	private String user_password;
	//邮箱（账号）
	private String user_mail;
	//头像
	private String user_avatar;
	//性别
	private String user_sex;
	//个人简介
	private String user_bio;
	//上传权限
	private String user_upload;
	//评论权限
	private String user_discuss;
	//创建时间
	private String user_gmt_create;
	//修改时间
	private String user_gmt_modified;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_username() {
		return user_username;
	}
	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_mail() {
		return user_mail;
	}
	public void setUser_mail(String user_mail) {
		this.user_mail = user_mail;
	}
	public String getUser_avatar() {
		return user_avatar;
	}
	public void setUser_avatar(String user_avatar) {
		this.user_avatar = user_avatar;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_bio() {
		return user_bio;
	}
	public void setUser_bio(String user_bio) {
		this.user_bio = user_bio;
	}
	public String getUser_upload() {
		return user_upload;
	}
	public void setUser_upload(String user_upload) {
		this.user_upload = user_upload;
	}
	public String getUser_discuss() {
		return user_discuss;
	}
	public void setUser_discuss(String user_discuss) {
		this.user_discuss = user_discuss;
	}
	public String getUser_gmt_create() {
		return user_gmt_create;
	}
	public void setUser_gmt_create(String user_gmt_create) {
		this.user_gmt_create = user_gmt_create;
	}
	public String getUser_gmt_modified() {
		return user_gmt_modified;
	}
	public void setUser_gmt_modified(String user_gmt_modified) {
		this.user_gmt_modified = user_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_user [user_id=" + user_id + ", user_username=" + user_username + ", user_password="
				+ user_password + ", user_mail=" + user_mail + ", user_avatar=" + user_avatar + ", user_sex=" + user_sex
				+ ", user_bio=" + user_bio + ", user_upload=" + user_upload + ", user_discuss=" + user_discuss
				+ ", user_gmt_create=" + user_gmt_create + ", user_gmt_modified=" + user_gmt_modified + "]";
	}
	
}

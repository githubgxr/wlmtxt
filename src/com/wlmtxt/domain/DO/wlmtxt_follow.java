package com.wlmtxt.domain.DO;

public class wlmtxt_follow {
	//id
	private String follow_id;
	//被关注用户id
	private String follow_passive_user_id;
	//发起关注用户id
	private String follow_active_user_id;
	//创建时间
	private String follow_gmt_create;
	//修改时间
	private String follow_gmt_modified;
	public String getFollow_id() {
		return follow_id;
	}
	public void setFollow_id(String follow_id) {
		this.follow_id = follow_id;
	}
	public String getFollow_passive_user_id() {
		return follow_passive_user_id;
	}
	public void setFollow_passive_user_id(String follow_passive_user_id) {
		this.follow_passive_user_id = follow_passive_user_id;
	}
	public String getFollow_active_user_id() {
		return follow_active_user_id;
	}
	public void setFollow_active_user_id(String follow_active_user_id) {
		this.follow_active_user_id = follow_active_user_id;
	}
	public String getFollow_gmt_create() {
		return follow_gmt_create;
	}
	public void setFollow_gmt_create(String follow_gmt_create) {
		this.follow_gmt_create = follow_gmt_create;
	}
	public String getFollow_gmt_modified() {
		return follow_gmt_modified;
	}
	public void setFollow_gmt_modified(String follow_gmt_modified) {
		this.follow_gmt_modified = follow_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_follow [follow_id=" + follow_id + ", follow_passive_user_id=" + follow_passive_user_id
				+ ", follow_active_user_id=" + follow_active_user_id + ", follow_gmt_create=" + follow_gmt_create
				+ ", follow_gmt_modified=" + follow_gmt_modified + "]";
	}
	
}

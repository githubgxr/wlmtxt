package com.wlmtxt.domain.DO;

public class wlmtxt_collect {
	//id
	private String collect_id;
	//作品id
	private String collect_works_id;
	//用户id
	private String collect_user_id;
	//创建时间
	private String collect_gmt_create;
	//修改时间
	private String collect_gmt_modified;
	public String getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(String collect_id) {
		this.collect_id = collect_id;
	}
	public String getCollect_works_id() {
		return collect_works_id;
	}
	public void setCollect_works_id(String collect_works_id) {
		this.collect_works_id = collect_works_id;
	}
	public String getCollect_user_id() {
		return collect_user_id;
	}
	public void setCollect_user_id(String collect_user_id) {
		this.collect_user_id = collect_user_id;
	}
	public String getCollect_gmt_create() {
		return collect_gmt_create;
	}
	public void setCollect_gmt_create(String collect_gmt_create) {
		this.collect_gmt_create = collect_gmt_create;
	}
	public String getCollect_gmt_modified() {
		return collect_gmt_modified;
	}
	public void setCollect_gmt_modified(String collect_gmt_modified) {
		this.collect_gmt_modified = collect_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_collect [collect_id=" + collect_id + ", collect_works_id=" + collect_works_id
				+ ", collect_user_id=" + collect_user_id + ", collect_gmt_create=" + collect_gmt_create
				+ ", collect_gmt_modified=" + collect_gmt_modified + "]";
	}
	
}

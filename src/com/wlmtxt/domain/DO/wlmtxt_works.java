package com.wlmtxt.domain.DO;

public class wlmtxt_works {
	//id
	private String works_id;
	//上传者id
	private String works_user_id;
	//作品名
	private String works_name;
	//封面
	private String works_cover;
	//二级菜单id
	private String works_second_menu_id;
	//标题
	private String works_title;
	//稿件推荐语
	private String works_reason;
	//是否通过审核
	private String works_passed;
	//是否删除
	private String works_deleted;
	//创建时间
	private String works_gmt_create;
	//修改时间
	private String works_gmt_modified;
	public String getWorks_id() {
		return works_id;
	}
	public void setWorks_id(String works_id) {
		this.works_id = works_id;
	}
	public String getWorks_user_id() {
		return works_user_id;
	}
	public void setWorks_user_id(String works_user_id) {
		this.works_user_id = works_user_id;
	}
	public String getWorks_name() {
		return works_name;
	}
	public void setWorks_name(String works_name) {
		this.works_name = works_name;
	}
	public String getWorks_cover() {
		return works_cover;
	}
	public void setWorks_cover(String works_cover) {
		this.works_cover = works_cover;
	}
	public String getWorks_second_menu_id() {
		return works_second_menu_id;
	}
	public void setWorks_second_menu_id(String works_second_menu_id) {
		this.works_second_menu_id = works_second_menu_id;
	}
	public String getWorks_title() {
		return works_title;
	}
	public void setWorks_title(String works_title) {
		this.works_title = works_title;
	}
	public String getWorks_reason() {
		return works_reason;
	}
	public void setWorks_reason(String works_reason) {
		this.works_reason = works_reason;
	}
	public String getWorks_passed() {
		return works_passed;
	}
	public void setWorks_passed(String works_passed) {
		this.works_passed = works_passed;
	}
	public String getWorks_deleted() {
		return works_deleted;
	}
	public void setWorks_deleted(String works_deleted) {
		this.works_deleted = works_deleted;
	}
	public String getWorks_gmt_create() {
		return works_gmt_create;
	}
	public void setWorks_gmt_create(String works_gmt_create) {
		this.works_gmt_create = works_gmt_create;
	}
	public String getWorks_gmt_modified() {
		return works_gmt_modified;
	}
	public void setWorks_gmt_modified(String works_gmt_modified) {
		this.works_gmt_modified = works_gmt_modified;
		
	}
	@Override
	public String toString() {
		return "wlmtxt_works [works_id=" + works_id + ", works_user_id=" + works_user_id + ", works_name=" + works_name
				+ ", works_cover=" + works_cover + ", works_second_menu_id=" + works_second_menu_id + ", works_title="
				+ works_title + ", works_reason=" + works_reason + ", works_deleted=" + works_deleted
				+ ", works_gmt_create=" + works_gmt_create + ", works_gmt_modified=" + works_gmt_modified + "]";
	}
}

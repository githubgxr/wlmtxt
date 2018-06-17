package com.wlmtxt.domain.DO;

public class wlmtxt_first_menu {
	//id
	private String first_menu_id;
	//一级菜单名
	private String first_menu_name;
	//创建时间
	private String first_menu_gmt_create;
	//修改时间
	private String first_menu_gmt_modified;
	public String getFirst_menu_id() {
		return first_menu_id;
	}
	public void setFirst_menu_id(String first_menu_id) {
		this.first_menu_id = first_menu_id;
	}
	public String getFirst_menu_name() {
		return first_menu_name;
	}
	public void setFirst_menu_name(String first_menu_name) {
		this.first_menu_name = first_menu_name;
	}
	public String getFirst_menu_gmt_create() {
		return first_menu_gmt_create;
	}
	public void setFirst_menu_gmt_create(String first_menu_gmt_create) {
		this.first_menu_gmt_create = first_menu_gmt_create;
	}
	public String getFirst_menu_gmt_modified() {
		return first_menu_gmt_modified;
	}
	public void setFirst_menu_gmt_modified(String first_menu_gmt_modified) {
		this.first_menu_gmt_modified = first_menu_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_first_menu [first_menu_id=" + first_menu_id + ", first_menu_name=" + first_menu_name
				+ ", first_menu_gmt_create=" + first_menu_gmt_create + ", first_menu_gmt_modified="
				+ first_menu_gmt_modified + "]";
	}
	
}

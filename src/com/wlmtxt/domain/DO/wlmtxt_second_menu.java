package com.wlmtxt.domain.DO;

public class wlmtxt_second_menu {
	//id
	private String second_menu_id;
	//一级菜单id
	private String second_menu_first_menu_id;
	//二级菜单名
	private String second_menu_name;
	//创建时间
	private String second_menu_gmt_create;
	//修改时间
	private String second_menu_gmt_modified;
	
	public String getSecond_menu_id() {
		return second_menu_id;
	}
	public void setSecond_menu_id(String second_menu_id) {
		this.second_menu_id = second_menu_id;
	}
	public String getSecond_menu_name() {
		return second_menu_name;
	}
	public String getSecond_menu_first_menu_id() {
		return second_menu_first_menu_id;
	}
	public void setSecond_menu_first_menu_id(String second_menu_first_menu_id) {
		this.second_menu_first_menu_id = second_menu_first_menu_id;
	}
	public String getSecond_menu_gmt_create() {
		return second_menu_gmt_create;
	}
	public void setSecond_menu_gmt_create(String second_menu_gmt_create) {
		this.second_menu_gmt_create = second_menu_gmt_create;
	}
	public String getSecond_menu_gmt_modified() {
		return second_menu_gmt_modified;
	}
	public void setSecond_menu_gmt_modified(String second_menu_gmt_modified) {
		this.second_menu_gmt_modified = second_menu_gmt_modified;
	}
	public void setSecond_menu_name(String second_menu_name) {
		this.second_menu_name = second_menu_name;
	}
	
	@Override
	public String toString() {
		return "wlmtxt_second_menu [second_menu_id=" + second_menu_id + ",  second_menu_name="
				+ second_menu_name +"]";
	}
}

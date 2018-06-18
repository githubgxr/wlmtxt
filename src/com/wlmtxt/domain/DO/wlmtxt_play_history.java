package com.wlmtxt.domain.DO;

public class wlmtxt_play_history {
	//id
	private String play_history_id;
	//作品id
	private String play_history_works_id;
	//用户id
	private String play_history_user_id;
	//是否在个人中心显示
	private String play_history_show;
	public String getPlay_history_show() {
		return play_history_show;
	}
	public void setPlay_history_show(String play_history_show) {
		this.play_history_show = play_history_show;
	}
	//创建时间
	private String play_history_gmt_create;
	//修改时间
	private String play_history_gmt_modified;
	public String getPlay_history_id() {
		return play_history_id;
	}
	public void setPlay_history_id(String play_history_id) {
		this.play_history_id = play_history_id;
	}
	public String getPlay_history_works_id() {
		return play_history_works_id;
	}
	public void setPlay_history_works_id(String play_history_works_id) {
		this.play_history_works_id = play_history_works_id;
	}
	public String getPlay_history_user_id() {
		return play_history_user_id;
	}
	public void setPlay_history_user_id(String play_history_user_id) {
		this.play_history_user_id = play_history_user_id;
	}
	public String getPlay_history_gmt_create() {
		return play_history_gmt_create;
	}
	public void setPlay_history_gmt_create(String play_history_gmt_create) {
		this.play_history_gmt_create = play_history_gmt_create;
	}
	public String getPlay_history_gmt_modified() {
		return play_history_gmt_modified;
	}
	public void setPlay_history_gmt_modified(String play_history_gmt_modified) {
		this.play_history_gmt_modified = play_history_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_play_history [play_history_id=" + play_history_id + ", play_history_works_id="
				+ play_history_works_id + ", play_history_user_id=" + play_history_user_id
				+ ", play_history_gmt_create=" + play_history_gmt_create + ", play_history_gmt_modified="
				+ play_history_gmt_modified + "]";
	}
	
}

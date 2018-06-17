package com.wlmtxt.domain.DO;

public class wlmtxt_keyword {
	//id
	private String keyword_id;
	//关键词名
	private String keyword_name;
	//创建时间
	private String keyword_gmt_create;
	//修改时间
	private String keyword_gmt_modified;
	
	public String getKeyword_id() {
		return keyword_id;
	}
	public void setKeyword_id(String keyword_id) {
		this.keyword_id = keyword_id;
	}
	public String getKeyword_name() {
		return keyword_name;
	}
	public void setKeyword_name(String keyword_name) {
		this.keyword_name = keyword_name;
	}
	public String getKeyword_gmt_create() {
		return keyword_gmt_create;
	}
	public void setKeyword_gmt_create(String keyword_gmt_create) {
		this.keyword_gmt_create = keyword_gmt_create;
	}
	public String getKeyword_gmt_modified() {
		return keyword_gmt_modified;
	}
	public void setKeyword_gmt_modified(String keyword_gmt_modified) {
		this.keyword_gmt_modified = keyword_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_keyword [keyword_id=" + keyword_id + ", keyword_name="
				+ keyword_name + ", keyword_gmt_create=" + keyword_gmt_create + ", keyword_gmt_modified="
				+ keyword_gmt_modified + "]";
	}
	
	
}

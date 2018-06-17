package com.wlmtxt.domain.DO;

public class wlmtxt_recommend {
	//id
	private String recommend_id;
	//作品id
	private String recommend_works_id;
	//展示顺序
	private String recommend_sort;
	//创建时间
	private String recommend_gmt_create;
	//修改时间
	private String recommend_gmt_modified;
	public String getRecommend_id() {
		return recommend_id;
	}
	public void setRecommend_id(String recommend_id) {
		this.recommend_id = recommend_id;
	}
	public String getRecommend_works_id() {
		return recommend_works_id;
	}
	public void setRecommend_works_id(String recommend_works_id) {
		this.recommend_works_id = recommend_works_id;
	}
	public String getRecommend_sort() {
		return recommend_sort;
	}
	public void setRecommend_sort(String recommend_sort) {
		this.recommend_sort = recommend_sort;
	}
	public String getRecommend_gmt_create() {
		return recommend_gmt_create;
	}
	public void setRecommend_gmt_create(String recommend_gmt_create) {
		this.recommend_gmt_create = recommend_gmt_create;
	}
	public String getRecommend_gmt_modified() {
		return recommend_gmt_modified;
	}
	public void setRecommend_gmt_modified(String recommend_gmt_modified) {
		this.recommend_gmt_modified = recommend_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_recommend [recommend_id=" + recommend_id + ", recommend_works_id=" + recommend_works_id
				+ ", recommend_sort=" + recommend_sort + ", recommend_gmt_create=" + recommend_gmt_create
				+ ", recommend_gmt_modified=" + recommend_gmt_modified + "]";
	}
	
}

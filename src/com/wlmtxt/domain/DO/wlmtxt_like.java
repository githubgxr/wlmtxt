package com.wlmtxt.domain.DO;

public class wlmtxt_like {
	//id
	private String like_id;
	//作品id
	private String like_works_id;
	//用户id
	private String like_user_id;
	//创建时间
	private String like_gmt_create;
	//修改时间
	private String like_gmt_modified;
	public String getLike_id() {
		return like_id;
	}
	public void setLike_id(String like_id) {
		this.like_id = like_id;
	}
	public String getLike_works_id() {
		return like_works_id;
	}
	public void setLike_works_id(String like_works_id) {
		this.like_works_id = like_works_id;
	}
	public String getLike_user_id() {
		return like_user_id;
	}
	public void setLike_user_id(String like_user_id) {
		this.like_user_id = like_user_id;
	}
	public String getLike_gmt_create() {
		return like_gmt_create;
	}
	public void setLike_gmt_create(String like_gmt_create) {
		this.like_gmt_create = like_gmt_create;
	}
	public String getLike_gmt_modified() {
		return like_gmt_modified;
	}
	public void setLike_gmt_modified(String like_gmt_modified) {
		this.like_gmt_modified = like_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_like [like_id=" + like_id + ", like_works_id=" + like_works_id + ", like_user_id=" + like_user_id
				+ ", like_gmt_create=" + like_gmt_create + ", like_gmt_modified=" + like_gmt_modified + "]";
	}
	
}

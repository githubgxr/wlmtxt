package com.wlmtxt.domain.DO;

public class wlmtxt_discuss {
	// id
	private String discuss_id;
	// 父评论id
	private String discuss_father_discuss_id;
	// 评论者id
	private String discuss_user_id;
	// 评论内容
	private String discuss_content;

	// 创建时间
	private String discuss_gmt_create;
	// 修改时间
	private String discuss_gmt_modified;

	public String getDiscuss_id() {
		return discuss_id;
	}

	public void setDiscuss_id(String discuss_id) {
		this.discuss_id = discuss_id;
	}

	public String getDiscuss_user_id() {
		return discuss_user_id;
	}

	public void setDiscuss_user_id(String discuss_user_id) {
		this.discuss_user_id = discuss_user_id;
	}

	public String getDiscuss_content() {
		return discuss_content;
	}

	public void setDiscuss_content(String discuss_content) {
		this.discuss_content = discuss_content;
	}

	public String getDiscuss_gmt_create() {
		return discuss_gmt_create;
	}

	public void setDiscuss_gmt_create(String discuss_gmt_create) {
		this.discuss_gmt_create = discuss_gmt_create;
	}

	public String getDiscuss_gmt_modified() {
		return discuss_gmt_modified;
	}

	public void setDiscuss_gmt_modified(String discuss_gmt_modified) {
		this.discuss_gmt_modified = discuss_gmt_modified;
	}

	public String getDiscuss_father_discuss_id() {
		return discuss_father_discuss_id;
	}

	public void setDiscuss_father_discuss_id(String discuss_father_discuss_id) {
		this.discuss_father_discuss_id = discuss_father_discuss_id;
	}

	@Override
	public String toString() {
		return "wlmtxt_discuss [discuss_id=" + discuss_id + ", discuss_father_discuss_id=" + discuss_father_discuss_id
				+ ", discuss_user_id=" + discuss_user_id + ", discuss_content=" + discuss_content
				+ ", discuss_gmt_create=" + discuss_gmt_create + ", discuss_gmt_modified=" + discuss_gmt_modified + "]";
	}

}

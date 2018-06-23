package com.wlmtxt.domain.DO;

public class wlmtxt_notification {
	// id
	private String notification_id;
	// 被通知用户
	private String notification_user_id;
	// 通知类型
	private String notification_type;
	// 通知内容
	private String notification_content;
	// 所属作品
	private String notification_works;

	// 创建时间
	private String notification_gmt_create;
	// 修改时间
	private String notification_gmt_modified;

	public String getNotification_works() {
		return notification_works;
	}

	public void setNotification_works(String notification_works) {
		this.notification_works = notification_works;
	}

	public String getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}

	public String getNotification_user_id() {
		return notification_user_id;
	}

	public void setNotification_user_id(String notification_user_id) {
		this.notification_user_id = notification_user_id;
	}

	public String getNotification_type() {
		return notification_type;
	}

	public void setNotification_type(String notification_type) {
		this.notification_type = notification_type;
	}

	public String getNotification_content() {
		return notification_content;
	}

	public void setNotification_content(String notification_content) {
		this.notification_content = notification_content;
	}

	public String getNotification_gmt_create() {
		return notification_gmt_create;
	}

	public void setNotification_gmt_create(String notification_gmt_create) {
		this.notification_gmt_create = notification_gmt_create;
	}

	public String getNotification_gmt_modified() {
		return notification_gmt_modified;
	}

	public void setNotification_gmt_modified(String notification_gmt_modified) {
		this.notification_gmt_modified = notification_gmt_modified;
	}

	@Override
	public String toString() {
		return "wlmtxt_notification [notification_id=" + notification_id + ", notification_user_id="
				+ notification_user_id + ", notification_type=" + notification_type + ", notification_content="
				+ notification_content + ", notification_works=" + notification_works + ", notification_gmt_create="
				+ notification_gmt_create + ", notification_gmt_modified=" + notification_gmt_modified + "]";
	}

}

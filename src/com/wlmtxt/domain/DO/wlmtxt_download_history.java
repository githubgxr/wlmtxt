package com.wlmtxt.domain.DO;

public class wlmtxt_download_history {
	//id
	private String download_history_id;
	//作品id
	private String download_history_works_id;
	//用户id
	private String download_history_user_id;
	//创建时间
	private String download_history_gmt_create;
	//修改时间
	private String download_history_gmt_modified;
	public String getDownload_history_id() {
		return download_history_id;
	}
	public void setDownload_history_id(String download_history_id) {
		this.download_history_id = download_history_id;
	}
	public String getDownload_history_works_id() {
		return download_history_works_id;
	}
	public void setDownload_history_works_id(String download_history_works_id) {
		this.download_history_works_id = download_history_works_id;
	}
	public String getDownload_history_user_id() {
		return download_history_user_id;
	}
	public void setDownload_history_user_id(String download_history_user_id) {
		this.download_history_user_id = download_history_user_id;
	}
	public String getDownload_history_gmt_create() {
		return download_history_gmt_create;
	}
	public void setDownload_history_gmt_create(String download_history_gmt_create) {
		this.download_history_gmt_create = download_history_gmt_create;
	}
	public String getDownload_history_gmt_modified() {
		return download_history_gmt_modified;
	}
	public void setDownload_history_gmt_modified(String download_history_gmt_modified) {
		this.download_history_gmt_modified = download_history_gmt_modified;
	}
	@Override
	public String toString() {
		return "wlmtxt_download_history [download_history_id=" + download_history_id + ", download_history_works_id="
				+ download_history_works_id + ", download_history_user_id=" + download_history_user_id
				+ ", download_history_gmt_create=" + download_history_gmt_create + ", download_history_gmt_modified="
				+ download_history_gmt_modified + "]";
	}
	
}

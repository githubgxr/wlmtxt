package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DTO.AdmindiscussDTO;

public class DiscussVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String discuss_content_user_mail_user_username;//
	
	private List<AdmindiscussDTO> admindiscussDTOList;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getDiscuss_content_user_mail_user_username() {
		return discuss_content_user_mail_user_username;
	}
	public void setDiscuss_content_user_mail_user_username(String discuss_content_user_mail_user_username) {
		this.discuss_content_user_mail_user_username = discuss_content_user_mail_user_username;
	}
	public List<AdmindiscussDTO> getAdmindiscussDTOList() {
		return admindiscussDTOList;
	}
	public void setAdmindiscussDTOList(List<AdmindiscussDTO> admindiscussDTOList) {
		this.admindiscussDTOList = admindiscussDTOList;
	}
	@Override
	public String toString() {
		return "DiscussVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", discuss_content_user_mail_user_username="
				+ discuss_content_user_mail_user_username + ", admindiscussDTOList=" + admindiscussDTOList + "]";
	}
	
}

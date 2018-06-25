package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class UserVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String user_username_user_mail;//昵称	
	
	private List<wlmtxt_user> wlmtxt_userList;
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
	
	public String getUser_username_user_mail() {
		return user_username_user_mail;
	}
	public void setUser_username_user_mail(String user_username_user_mail) {
		this.user_username_user_mail = user_username_user_mail;
	}
	public List<wlmtxt_user> getWlmtxt_userList() {
		return wlmtxt_userList;
	}
	public void setWlmtxt_userList(List<wlmtxt_user> wlmtxt_userList) {
		this.wlmtxt_userList = wlmtxt_userList;
	}
	@Override
	public String toString() {
		return "UserVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", user_username_user_mail=" + user_username_user_mail
				+ ", wlmtxt_userList=" + wlmtxt_userList + "]";
	}
	
	

	
}

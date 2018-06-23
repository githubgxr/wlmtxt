package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class AdminVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String admin_username;//管理员账号
	private List<wlmtxt_admin> wlmtxt_adminList;
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
	public String getAdmin_username() {
		return admin_username;
	}
	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public List<wlmtxt_admin> getWlmtxt_adminList() {
		return wlmtxt_adminList;
	}
	public void setWlmtxt_adminList(List<wlmtxt_admin> wlmtxt_adminList) {
		this.wlmtxt_adminList = wlmtxt_adminList;
	}
	@Override
	public String toString() {
		return "AdminVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", admin_username=" + admin_username + ", wlmtxt_adminList="
				+ wlmtxt_adminList + "]";
	}
	
}

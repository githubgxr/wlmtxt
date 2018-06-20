package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_works;

public class WorksVO {
	private int currPage;
	private int totalPage;
	private int totalCount;
	private int pageSize;
	private String works_title;//标题
	private String works_passed;//是否审核
	private String works_deleted;//是否删除
	private List<wlmtxt_works> wlmtxt_worksList;
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
	public String getWorks_title() {
		return works_title;
	}
	public void setWorks_title(String works_title) {
		this.works_title = works_title;
	}
	public List<wlmtxt_works> getWlmtxt_worksList() {
		return wlmtxt_worksList;
	}
	public void setWlmtxt_worksList(List<wlmtxt_works> wlmtxt_worksList) {
		this.wlmtxt_worksList = wlmtxt_worksList;
	}
	
	public String getWorks_passed() {
		return works_passed;
	}
	public void setWorks_passed(String works_passed) {
		this.works_passed = works_passed;
	}
	public String getWorks_deleted() {
		return works_deleted;
	}
	public void setWorks_deleted(String works_deleted) {
		this.works_deleted = works_deleted;
	}
	@Override
	public String toString() {
		return "WorksVO [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", works_title=" + works_title + ", works_passed=" + works_passed
				+ ", works_deleted=" + works_deleted + ", wlmtxt_worksList=" + wlmtxt_worksList + "]";
	}
	
	
}

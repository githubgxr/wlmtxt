package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class KeywordVO {
	private int currPage=1;//当前页
	private int totalPage;//总页数
	private int totalCount;//总记录数
	private int pageSize;//每页条数
	private String keyword_name;//关键词名	
	private List<wlmtxt_keyword> wlmtxt_keywordList;
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
	public String getKeyword_name() {
		return keyword_name;
	}
	public void setKeyword_name(String keyword_name) {
		this.keyword_name = keyword_name;
	}
	public List<wlmtxt_keyword> getWlmtxt_keywordList() {
		return wlmtxt_keywordList;
	}
	public void setWlmtxt_keywordList(List<wlmtxt_keyword> wlmtxt_keywordList) {
		this.wlmtxt_keywordList = wlmtxt_keywordList;
	}
	@Override
	public String toString() {
		return "AdminVO2 [currPage=" + currPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", pageSize=" + pageSize + ", keyword_name=" + keyword_name + ", wlmtxt_keywordList="
				+ wlmtxt_keywordList + "]";
	}
	
	
}

package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DTO.WorksDTO;

public class WorksCategoryVO {

	// 当前页
	private int pageIndex = 1;

	// 每页显示记录数
	private int pageSize = 12;

	//
	private List<WorksDTO> worksDTOList;

	//
	private String screen_category = "all";

	@Override
	public String toString() {
		return "WorksCategoryVO [pageIndex=" + pageIndex + ", pageSize=" + pageSize + ", worksDTOList=" + worksDTOList
				+ ", screen_category=" + screen_category + "]";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<WorksDTO> getWorksDTOList() {
		return worksDTOList;
	}

	public void setWorksDTOList(List<WorksDTO> worksDTOList) {
		this.worksDTOList = worksDTOList;
	}

	public String getScreen_category() {
		return screen_category;
	}

	public void setScreen_category(String screen_category) {
		this.screen_category = screen_category;
	}

}

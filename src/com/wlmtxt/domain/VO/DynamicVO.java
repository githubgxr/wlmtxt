package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DTO.WorksDTO;

public class DynamicVO {
	/*
	 * 关注的人的作品
	 */
	List<WorksDTO> worksDTOList;

	// 当前页
	private int pageIndex = 1;

	// 每页显示记录数
	private int pageSize = 5;

	@Override
	public String toString() {
		return "DynamicVO [worksDTOList=" + worksDTOList + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize + "]";
	}

	public List<WorksDTO> getWorksDTOList() {
		return worksDTOList;
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

	public void setWorksDTOList(List<WorksDTO> worksDTOList) {
		this.worksDTOList = worksDTOList;
	}

}

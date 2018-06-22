package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DTO.WorksDTO;

public class DynamicVO {
	/*
	 * 关注的人的作品
	 */
	List<WorksDTO> worksDTOList;

	public List<WorksDTO> getWorksDTOList() {
		return worksDTOList;
	}

	public void setWorksDTOList(List<WorksDTO> worksDTOList) {
		this.worksDTOList = worksDTOList;
	}

}

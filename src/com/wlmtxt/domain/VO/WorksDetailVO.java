package com.wlmtxt.domain.VO;

import java.util.List;

import com.wlmtxt.domain.DTO.DiscussDTO;
import com.wlmtxt.domain.DTO.WorksDTO;

public class WorksDetailVO {
	WorksDTO worksDTO;
	List<DiscussDTO> discussDTOList;

	@Override
	public String toString() {
		return "WorksDetailVO [worksDTO=" + worksDTO + ", discussDTOList=" + discussDTOList + "]";
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}

	public List<DiscussDTO> getDiscussDTOList() {
		return discussDTOList;
	}

	public void setDiscussDTOList(List<DiscussDTO> discussDTOList) {
		this.discussDTOList = discussDTOList;
	}

}

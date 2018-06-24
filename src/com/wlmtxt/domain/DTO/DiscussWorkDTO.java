package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_discuss;

public class DiscussWorkDTO {
	private wlmtxt_discuss discuss;
	private WorksDTO worksDTO;

	@Override
	public String toString() {
		return "DiscussWorkDTO [discuss=" + discuss + ", worksDTO=" + worksDTO + "]";
	}

	public wlmtxt_discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(wlmtxt_discuss discuss) {
		this.discuss = discuss;
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}
}

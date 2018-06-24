package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_like;

public class LikeDTO {
	private wlmtxt_like like;

	private WorksDTO worksDTO;

	@Override
	public String toString() {
		return "LikeDTO [like=" + like + ", worksDTO=" + worksDTO + "]";
	}

	public wlmtxt_like getLike() {
		return like;
	}

	public void setLike(wlmtxt_like like) {
		this.like = like;
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}

}

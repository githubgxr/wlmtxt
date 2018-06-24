package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_collect;

public class CollectDTO {
	private wlmtxt_collect collect;

	private WorksDTO worksDTO;

	@Override
	public String toString() {
		return "CollectDTO [collect=" + collect + ", worksDTO=" + worksDTO + "]";
	}

	public wlmtxt_collect getCollect() {
		return collect;
	}

	public void setCollect(wlmtxt_collect collect) {
		this.collect = collect;
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}

}

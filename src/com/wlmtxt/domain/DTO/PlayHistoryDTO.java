package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_play_history;

public class PlayHistoryDTO {
	private wlmtxt_play_history playHistory;

	private WorksDTO worksDTO;

	@Override
	public String toString() {
		return "PlayHistoryDTO [playHistory=" + playHistory + ", worksDTO=" + worksDTO + "]";
	}

	public wlmtxt_play_history getPlayHistory() {
		return playHistory;
	}

	public void setPlayHistory(wlmtxt_play_history playHistory) {
		this.playHistory = playHistory;
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}

}

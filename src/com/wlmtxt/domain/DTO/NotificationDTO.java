package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_notification;

public class NotificationDTO {
	wlmtxt_notification notification;
	WorksDTO worksDTO;

	@Override
	public String toString() {
		return "NotificationDTO [notification=" + notification + ", worksDTO=" + worksDTO + "]";
	}

	public wlmtxt_notification getNotification() {
		return notification;
	}

	public void setNotification(wlmtxt_notification notification) {
		this.notification = notification;
	}

	public WorksDTO getWorksDTO() {
		return worksDTO;
	}

	public void setWorksDTO(WorksDTO worksDTO) {
		this.worksDTO = worksDTO;
	}

}

package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_notification;
import com.wlmtxt.domain.DO.wlmtxt_user;

public class NotificationDTO {
	wlmtxt_notification notification;
	WorksDTO worksDTO;
	wlmtxt_user user;

	@Override
	public String toString() {
		return "NotificationDTO [notification=" + notification + ", worksDTO=" + worksDTO + ", user=" + user + "]";
	}

	public wlmtxt_notification getNotification() {
		return notification;
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
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

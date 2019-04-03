package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_user;

public class UserChartsDTO {
	private wlmtxt_user user;
	private Double point;

	@Override
	public String toString() {
		return "UserChartsDTO [user=" + user + ", point=" + point + "]";
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
	}

	public Double getPoint() {
		return point;
	}

	public void setPoint(Double point) {
		this.point = point;
	}

}

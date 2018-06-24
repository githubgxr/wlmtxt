package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_user;

public class ReplyDTO {

	private wlmtxt_discuss reply;

	private wlmtxt_user user;

	@Override
	public String toString() {
		return "ReplyDTO [reply=" + reply + ", user=" + user + "]";
	}

	public wlmtxt_discuss getReply() {
		return reply;
	}

	public void setReply(wlmtxt_discuss reply) {
		this.reply = reply;
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
	}

}

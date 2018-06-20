package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_discuss;

public class DiscussDTO {

	wlmtxt_discuss discuss;

	List<wlmtxt_discuss> reply;

	@Override
	public String toString() {
		return "DiscussDTO [discuss=" + discuss + ", reply=" + reply + "]";
	}

	public wlmtxt_discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(wlmtxt_discuss discuss) {
		this.discuss = discuss;
	}

	public List<wlmtxt_discuss> getReply() {
		return reply;
	}

	public void setReply(List<wlmtxt_discuss> reply) {
		this.reply = reply;
	}

}

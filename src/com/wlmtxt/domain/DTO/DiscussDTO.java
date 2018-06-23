package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_user;

public class DiscussDTO {

	wlmtxt_discuss discuss;

	List<ReplyDTO> replyDTO;

	wlmtxt_user user;

	@Override
	public String toString() {
		return "DiscussDTO [discuss=" + discuss + ", replyDTO=" + replyDTO + ", user=" + user + "]";
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
	}

	public wlmtxt_discuss getDiscuss() {
		return discuss;
	}

	public void setDiscuss(wlmtxt_discuss discuss) {
		this.discuss = discuss;
	}

	public List<ReplyDTO> getReplyDTO() {
		return replyDTO;
	}

	public void setReplyDTO(List<ReplyDTO> replyDTO) {
		this.replyDTO = replyDTO;
	}

}

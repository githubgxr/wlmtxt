package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_follow;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class FollowDTO {

	//是否互相关注
	private String mutualFollow;
	//我关注的
	private wlmtxt_user user;
	public String getMutualFollow() {
		return mutualFollow;
	}
	public void setMutualFollow(String mutualFollow) {
		this.mutualFollow = mutualFollow;
	}
	public wlmtxt_user getUser() {
		return user;
	}
	public void setUser(wlmtxt_user user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "FollowDTO [mutualFollow=" + mutualFollow + ", user=" + user + "]";
	}


}

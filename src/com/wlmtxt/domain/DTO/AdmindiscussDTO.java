package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class AdmindiscussDTO {
private wlmtxt_discuss discuss;
private wlmtxt_works works;
private wlmtxt_user user;
public wlmtxt_discuss getDiscuss() {
	return discuss;
}
public void setDiscuss(wlmtxt_discuss discuss) {
	this.discuss = discuss;
}
public wlmtxt_works getWorks() {
	return works;
}
public void setWorks(wlmtxt_works works) {
	this.works = works;
}
public wlmtxt_user getUser() {
	return user;
}
public void setUser(wlmtxt_user user) {
	this.user = user;
}
@Override
public String toString() {
	return "AdmindiscussDTO [discuss=" + discuss + ", works=" + works + ", user=" + user + "]";
}


}

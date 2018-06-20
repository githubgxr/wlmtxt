package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class WorksDTO {

	private wlmtxt_works works;

	private wlmtxt_second_menu secondMenu;

	private wlmtxt_first_menu firstMenu;
	// 关键词列表
	private List<KeyWordDTO> keyWordDTOList;
	// 作者
	private wlmtxt_user user;

	@Override
	public String toString() {
		return "WorksDTO [works=" + works + ", secondMenu=" + secondMenu + ", firstMenu=" + firstMenu
				+ ", keyWordDTOList=" + keyWordDTOList + ", user=" + user + "]";
	}

	public wlmtxt_user getUser() {
		return user;
	}

	public void setUser(wlmtxt_user user) {
		this.user = user;
	}

	public wlmtxt_works getWorks() {
		return works;
	}

	public void setWorks(wlmtxt_works works) {
		this.works = works;
	}

	public wlmtxt_second_menu getSecondMenu() {
		return secondMenu;
	}

	public void setSecondMenu(wlmtxt_second_menu secondMenu) {
		this.secondMenu = secondMenu;
	}

	public wlmtxt_first_menu getFirstMenu() {
		return firstMenu;
	}

	public void setFirstMenu(wlmtxt_first_menu firstMenu) {
		this.firstMenu = firstMenu;
	}

	public List<KeyWordDTO> getKeyWordDTOList() {
		return keyWordDTOList;
	}

	public void setKeyWordDTOList(List<KeyWordDTO> keyWordDTOList) {
		this.keyWordDTOList = keyWordDTOList;
	}

}

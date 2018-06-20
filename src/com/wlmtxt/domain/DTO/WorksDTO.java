package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class WorksDTO {

	wlmtxt_works works;

	wlmtxt_second_menu secondMenu;

	wlmtxt_first_menu firstMenu;

	List<KeyWordDTO> keyWordDTOList;

	@Override
	public String toString() {
		return "WorksDTO [works=" + works + ", secondMenu=" + secondMenu + ", firstMenu=" + firstMenu
				+ ", keyWordDTOList=" + keyWordDTOList + "]";
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

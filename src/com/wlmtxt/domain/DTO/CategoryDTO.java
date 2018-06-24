package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;

public class CategoryDTO {
	private wlmtxt_first_menu firstMenu;
	private wlmtxt_second_menu secondMenu;

	@Override
	public String toString() {
		return "CategoryDTO [firstMenu=" + firstMenu + ", secondMenu=" + secondMenu + "]";
	}

	public wlmtxt_first_menu getFirstMenu() {
		return firstMenu;
	}

	public void setFirstMenu(wlmtxt_first_menu firstMenu) {
		this.firstMenu = firstMenu;
	}

	public wlmtxt_second_menu getSecondMenu() {
		return secondMenu;
	}

	public void setSecondMenu(wlmtxt_second_menu secondMenu) {
		this.secondMenu = secondMenu;
	}

}

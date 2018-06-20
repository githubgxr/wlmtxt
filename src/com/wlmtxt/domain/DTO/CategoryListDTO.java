package com.wlmtxt.domain.DTO;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;

public class CategoryListDTO {

	private wlmtxt_first_menu category;

	private List<wlmtxt_second_menu> sonCategoryList;

	public wlmtxt_first_menu getCategory() {
		return category;
	}

	public void setCategory(wlmtxt_first_menu category) {
		this.category = category;
	}

	public List<wlmtxt_second_menu> getSonCategoryList() {
		return sonCategoryList;
	}

	public void setSonCategoryList(List<wlmtxt_second_menu> sonCategoryList) {
		this.sonCategoryList = sonCategoryList;
	}

	public CategoryListDTO(wlmtxt_first_menu category, List<wlmtxt_second_menu> sonCategoryList) {
		
		this.category = category;
		this.sonCategoryList = sonCategoryList;
	}

	

}

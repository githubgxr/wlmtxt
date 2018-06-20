package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_works_keyword;

public class KeyWordDTO {

	wlmtxt_works_keyword works_keyword;

	wlmtxt_keyword keyword;

	@Override
	public String toString() {
		return "KeyWordDTO [works_keyword=" + works_keyword + ", keyword=" + keyword + "]";
	}

	public wlmtxt_works_keyword getWorks_keyword() {
		return works_keyword;
	}

	public void setWorks_keyword(wlmtxt_works_keyword works_keyword) {
		this.works_keyword = works_keyword;
	}

	public wlmtxt_keyword getKeyword() {
		return keyword;
	}

	public void setKeyword(wlmtxt_keyword keyword) {
		this.keyword = keyword;
	}

}

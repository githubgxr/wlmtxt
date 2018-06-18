package com.wlmtxt.Works.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public interface WorksService {

	public void likWorks(wlmtxt_user user, wlmtxt_works works) throws Exception;

	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	public void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	public void discussWorks(wlmtxt_user user, wlmtxt_discuss accpet_discuss) throws Exception;

	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	public boolean isLiked(String userID, String worksID) throws Exception;

	public boolean isCollectWorks(String user_id, String works_id) throws Exception;

	public void saveWorks(wlmtxt_works accept_works);

	public void saveKeyword(wlmtxt_keyword newkeywords);

	public List<wlmtxt_first_menu> listFirstMenu();

}

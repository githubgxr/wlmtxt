package com.wlmtxt.Works.service;

import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

public interface WorksService {

	void likWorks(wlmtxt_user user, wlmtxt_works works) throws Exception;

	void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

	void discussWorks(wlmtxt_user user, wlmtxt_discuss accpet_discuss) throws Exception;

	void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception;

}

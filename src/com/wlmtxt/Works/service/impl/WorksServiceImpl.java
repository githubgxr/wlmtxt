package com.wlmtxt.Works.service.impl;

import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_collect;
import com.wlmtxt.domain.DO.wlmtxt_discuss;
import com.wlmtxt.domain.DO.wlmtxt_download_history;
import com.wlmtxt.domain.DO.wlmtxt_like;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

import util.TeamUtil;

public class WorksServiceImpl implements WorksService {
	
	private WorksDao worksDao;
	
	public WorksDao getWorksDao() {
		return worksDao;
	}

	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}

	@Override
	public void likWorks(wlmtxt_user user, wlmtxt_works works) throws Exception {
		String like_user_id = user.getUser_id();
		String like_works_id = works.getWorks_id();
		wlmtxt_like like = worksDao.findLikeBy_user_id_And_like_works_id(like_user_id, like_works_id);
		Boolean like_flag;
		if (like == null) {
			like_flag = false;
		} else {
			like_flag = true;
		}
		if (like_flag) {
			worksDao.removeLikeBy_user_id_And_like_works_id(like_user_id, like_works_id);
		} else {
			wlmtxt_like new_like = new wlmtxt_like();
			new_like.setLike_id(TeamUtil.getUuid());
			new_like.setLike_user_id(like_user_id);
			new_like.setLike_works_id(like_works_id);
			new_like.setLike_gmt_create(TeamUtil.getStringSecond());
			new_like.setLike_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveLike(new_like);
		}
	}

	@Override
	public void collectWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		String collect_user_id = user.getUser_id();
		String collect_works_id = accept_works.getWorks_id();
		wlmtxt_collect collect = worksDao.findCollectBy_user_id_And_collect_works_id(collect_user_id, collect_works_id);
		Boolean collect_flag;
		if (collect == null) {
			collect_flag = false;
		} else {
			collect_flag = true;
		}
		if (collect_flag) {
			worksDao.removeCollectBy_user_id_And_collect_works_id(collect_user_id, collect_works_id);
		} else {
			wlmtxt_collect new_collect = new wlmtxt_collect();
			new_collect.setCollect_id(TeamUtil.getUuid());
			new_collect.setCollect_user_id(collect_user_id);
			new_collect.setCollect_works_id(collect_works_id);
			new_collect.setCollect_gmt_create(TeamUtil.getStringSecond());
			new_collect.setCollect_gmt_modified(TeamUtil.getStringSecond());
			worksDao.saveCollect(new_collect);
		}
	}

	@Override
	public void downloadWorks(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		String download_history_user_id = user.getUser_id();
		String download_history_works_id = accept_works.getWorks_id();
		wlmtxt_download_history new_download_history = new wlmtxt_download_history();
		new_download_history.setDownload_history_id(TeamUtil.getUuid());
		new_download_history.setDownload_history_user_id(download_history_user_id);
		new_download_history.setDownload_history_works_id(download_history_works_id);
		new_download_history.setDownload_history_show("是");
		new_download_history.setDownload_history_gmt_create(TeamUtil.getStringSecond());
		new_download_history.setDownload_history_gmt_modified(TeamUtil.getStringSecond());
		worksDao.saveDownloadHistory(new_download_history);
	}
	//删除下载历史记录，即不显示在个人中心，实际的表记录未删除

	@Override
	public void discussWorks(wlmtxt_user user, wlmtxt_discuss accpet_discuss) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDownloadHistory(wlmtxt_user user, wlmtxt_works accept_works) throws Exception {
		worksDao.removeDownloadHistory(user, accept_works);
	}

}

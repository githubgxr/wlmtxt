package com.wlmtxt.Admin.service.impl;

import com.wlmtxt.Admin.dao.WorksExamineDao;
import com.wlmtxt.Admin.service.WorksExamineService;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

import util.TeamUtil;

public class WorksExamineServiceImpl implements WorksExamineService {
private WorksExamineDao worksExamineDao;

public WorksExamineDao getWorksExamineDao() {
	return worksExamineDao;
}

public void setWorksExamineDao(WorksExamineDao worksExamineDao) {
	this.worksExamineDao = worksExamineDao;
}

@Override
public void getworksListThreeByPage(WorksVO worksVO) {
	
	int count = worksExamineDao.getCountworksListThree(worksVO);
	worksVO.setTotalCount(count);
	worksVO.setPageSize(10);
	worksVO.setTotalPage((int) Math.ceil((double) count / worksVO.getPageSize()));
	worksExamineDao.getworksListThreeByPage(worksVO);
}

@Override
public boolean delete(String works_id) {
	wlmtxt_works wlmtxt_work = worksExamineDao.getWorksById(works_id);
	wlmtxt_work.setWorks_deleted("1");
	String time = TeamUtil.getStringSecond();
	wlmtxt_work.setWorks_gmt_modified(time);
	if(worksExamineDao.delete(wlmtxt_work)){
		return true;
	}else{
		return false;
	}
	
}

@Override
public boolean passed(String works_id, String passed) {
	wlmtxt_works wlmtxt_work = worksExamineDao.getWorksById(works_id);
	String time = TeamUtil.getStringSecond();
	wlmtxt_work.setWorks_gmt_modified(time);
	if(passed.equals("1")){
		System.out.println("11111111"+passed);
		wlmtxt_work.setWorks_passed("1");
	}else{
		System.out.println("2222222222"+passed);
		
		wlmtxt_work.setWorks_passed("2");
	}
	if(worksExamineDao.passed(wlmtxt_work)){
		return true;
	}else{
		return false;
	}
}

}



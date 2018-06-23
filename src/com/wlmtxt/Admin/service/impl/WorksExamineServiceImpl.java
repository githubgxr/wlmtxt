package com.wlmtxt.Admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wlmtxt.Admin.dao.WorksExamineDao;
import com.wlmtxt.Admin.service.WorksExamineService;
import com.wlmtxt.domain.DO.wlmtxt_recommend;
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

@Override
public List<wlmtxt_recommend> listrecommend() {
	
	return worksExamineDao.listrecommend();
}

@Override
public boolean addRecommend(wlmtxt_recommend recommend) {
	int  maxSort = worksExamineDao.getMaxSort()+1;
	if(maxSort<=3){
	recommend.setRecommend_id(TeamUtil.getUuid());
	String str =""+maxSort;
	recommend.setRecommend_sort(str);
	String time = TeamUtil.getStringSecond();
	recommend.setRecommend_gmt_create(time);
	recommend.setRecommend_gmt_modified(time);
	if(worksExamineDao.addRecommend(recommend)){
		return true;
	}else{
		return false;
	}
	}else{
		return false;
	}
}

@Override
public boolean deleteRecommend(String recommendIdAll) {
	String[] arr = recommendIdAll.split(",");
	for(String recommend_id : arr){
		worksExamineDao.deleteAdmin(recommend_id);
	}
	return true;
}

@Override
public boolean moveRecommend(String recommend_id, int moveAction) {
	wlmtxt_recommend recommend = worksExamineDao.get_Recommend_byID(recommend_id);
	List<wlmtxt_recommend> wlmtxt_recommendList = new ArrayList<wlmtxt_recommend>();
	if (moveAction == 2) {
		wlmtxt_recommendList = worksExamineDao.get_RecommendChangeValue(recommend.getRecommend_sort());	
	System.out.println("下移");	
	for (wlmtxt_recommend recommend2 : wlmtxt_recommendList) {
			String  a, b, temp;
			a = recommend2.getRecommend_sort();
			b = recommend.getRecommend_sort();
				temp = a;
				a = b;
				b = temp;
				recommend2.setRecommend_sort(a);
				worksExamineDao.updateRecommend(recommend2);
				recommend.setRecommend_sort(b);
				worksExamineDao.updateRecommend(recommend);
            
		}
	} else if (moveAction == 1) {
		wlmtxt_recommendList = worksExamineDao.get_RecommendChangeValueSmall(recommend.getRecommend_sort());	
		for (wlmtxt_recommend recommend1 : wlmtxt_recommendList) {
			
			String a, b, temp;
			a = recommend1.getRecommend_sort();
			b = recommend.getRecommend_sort();
				temp = a;
				a = b;
				b = temp;
				recommend1.setRecommend_sort(a);
				worksExamineDao.updateRecommend(recommend1);
				recommend.setRecommend_sort(b);
				worksExamineDao.updateRecommend(recommend);
				
		}

	}
	return true;
}

@Override
public boolean getworksById(String works_id) {
	return worksExamineDao.getWorksOneById(works_id);
}

}



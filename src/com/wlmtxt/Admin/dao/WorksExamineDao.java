package com.wlmtxt.Admin.dao;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_recommend;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

public interface WorksExamineDao {

public	int getCountworksListThree(WorksVO worksVO);

public void getworksListThreeByPage(WorksVO worksVO);

public wlmtxt_works getWorksById(String works_id);

public boolean delete(wlmtxt_works wlmtxt_work);

public boolean passed(wlmtxt_works wlmtxt_work);
/*
 * 得到所有轮播图
 */
public List<wlmtxt_recommend> listrecommend();

public int getMaxSort();

public boolean addRecommend(wlmtxt_recommend recommend);

public void deleteAdmin(String recommend_id);
/*
 * 根据id得到轮播图
 */
public wlmtxt_recommend get_Recommend_byID(String recommend_id);
/*
 * 得到大一排序
 */
public List<wlmtxt_recommend> get_RecommendChangeValue(String recommend_sort);
/*
 * 更新轮播图
 */
public void updateRecommend(wlmtxt_recommend recommend2);
/*
 * 得到小一排序
 */
public List<wlmtxt_recommend> get_RecommendChangeValueSmall(String recommend_sort);
/*
 * 得到单个作品
 */
public boolean getWorksOneById(String works_id);

}

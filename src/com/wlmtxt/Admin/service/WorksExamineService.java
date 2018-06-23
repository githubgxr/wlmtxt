package com.wlmtxt.Admin.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_recommend;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

public interface WorksExamineService {
/*
 * 获得待审核的作品
 */
public 	void getworksListThreeByPage(WorksVO worksVO);
/*
 * 删除作品
 */
public boolean delete(String works_id);
/*
 * 审核作品
 */
public boolean passed(String works_id, String passed);
/*
 * 得到所有轮播图
 */
public List<wlmtxt_recommend> listrecommend();
/*
 * 添加轮播图
 */
public boolean addRecommend(wlmtxt_recommend recommend);
/*
 * 删除轮播图
 */
public boolean deleteRecommend(String recommendIdAll);
/*
 * 移动轮播图
 */
public boolean moveRecommend(String recommend_id, int moveAction);
/*
 * 得到单个作品 
 */
public boolean getworksById(String works_id);



}

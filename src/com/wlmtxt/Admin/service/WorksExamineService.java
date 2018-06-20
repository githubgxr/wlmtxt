package com.wlmtxt.Admin.service;

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

}

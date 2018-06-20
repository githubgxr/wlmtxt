package com.wlmtxt.Admin.dao;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

public interface WorksExamineDao {

public	int getCountworksListThree(WorksVO worksVO);

public void getworksListThreeByPage(WorksVO worksVO);

public wlmtxt_works getWorksById(String works_id);

public boolean delete(wlmtxt_works wlmtxt_work);

public boolean passed(wlmtxt_works wlmtxt_work);

}

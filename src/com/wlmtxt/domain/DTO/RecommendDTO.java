package com.wlmtxt.domain.DTO;

import com.wlmtxt.domain.DO.wlmtxt_recommend;
import com.wlmtxt.domain.DO.wlmtxt_works;

public class RecommendDTO {
private wlmtxt_recommend recommend;
private wlmtxt_works works;
private WorksDTO worksDTO;

public wlmtxt_recommend getRecommend() {
	return recommend;
}
public void setRecommend(wlmtxt_recommend recommend) {
	this.recommend = recommend;
}
public wlmtxt_works getWorks() {
	return works;
}
public void setWorks(wlmtxt_works works) {
	this.works = works;
}

public WorksDTO getWorksDTO() {
	return worksDTO;
}
public void setWorksDTO(WorksDTO worksDTO) {
	this.worksDTO = worksDTO;
}

@Override
public String toString() {
	return "RecommendDTO [recommend=" + recommend + ", works=" + works + ", worksDTO=" + worksDTO + "]";
}
public RecommendDTO() {
	
	// TODO Auto-generated constructor stub
}

}

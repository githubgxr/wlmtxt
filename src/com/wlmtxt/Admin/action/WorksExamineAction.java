package com.wlmtxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Admin.service.WorksExamineService;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

public class WorksExamineAction extends ActionSupport {
   private WorksExamineService worksExamineService;
   private WorksVO worksVO;
   private wlmtxt_works wlmtxt_work;
   private String passed;
   
public WorksVO getWorksVO() {
	return worksVO;
}

public void setWorksVO(WorksVO worksVO) {
	this.worksVO = worksVO;
}


public String getPassed() {
	return passed;
}

public void setPassed(String passed) {
	this.passed = passed;
}

public wlmtxt_works getWlmtxt_work() {
	return wlmtxt_work;
}

public void setWlmtxt_work(wlmtxt_works wlmtxt_work) {
	this.wlmtxt_work = wlmtxt_work;
}

public WorksExamineService getWorksExamineService() {
	return worksExamineService;
}

public void setWorksExamineService(WorksExamineService worksExamineService) {
	this.worksExamineService = worksExamineService;
}
public String list_works(){
	return "list_works";
}
   /*
    * 得到待审核列表
    */
public void worksListThree(){
	worksExamineService.getworksListThreeByPage(worksVO);
	Gson gson = new Gson();
	String result = gson.toJson(worksVO);
	System.out.println(result);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	try {
		PrintWriter pw = response.getWriter();
		pw.write(result);
		pw.flush();
		pw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
} 
/*
 * 删除作品
 */
public void delete() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(worksExamineService.delete(wlmtxt_work.getWorks_id())){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 通过作品
 */
public void passed() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	System.out.println("acion"+passed);
	System.out.println("acion"+wlmtxt_work);
	if(worksExamineService.passed(wlmtxt_work.getWorks_id(), passed)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
}
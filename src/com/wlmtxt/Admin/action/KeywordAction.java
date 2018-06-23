package com.wlmtxt.Admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Admin.service.KeywordService;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.VO.KeywordVO;

public class KeywordAction extends ActionSupport {
private KeywordService keywordService;
private wlmtxt_keyword keyword;
private String keywordIDAll;
private KeywordVO keywordVO;

public String getKeywordIDAll() {
	return keywordIDAll;
}

public void setKeywordIDAll(String keywordIDAll) {
	this.keywordIDAll = keywordIDAll;
}

public KeywordVO getKeywordVO() {
	return keywordVO;
}

public void setKeywordVO(KeywordVO keywordVO) {
	this.keywordVO = keywordVO;
}

public wlmtxt_keyword getKeyword() {
	return keyword;
}

public void setKeyword(wlmtxt_keyword keyword) {
	this.keyword = keyword;
}

public KeywordService getKeywordService() {
	return keywordService;
}

public void setKeywordService(KeywordService keywordService) {
	this.keywordService = keywordService;
}
/*
 * 	 关键词的添加
 */
public void addKeyword() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(keywordService.addKeyword(keyword)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}

/*
 * 关键词的修改
 */
public void updateKeyword() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(keywordService.updateKeyword(keyword)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 关键词的删除
 */
public void deleteKeyword() throws IOException{
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	if(keywordService.deleteKeyword(keywordIDAll)){
		pw.write("1");
	}else{
		pw.write("2");
	}
}
/*
 * 关键词的查询/分页列表
 */
public void getKeywordListBysearchPage() throws IOException{
	keywordService.getKeywordListBysearchPage(keywordVO);
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	 GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(keywordVO));
}
/*
 * 根据id得到关键词信息
 */
public void getKeywordById() throws IOException{
	keyword = keywordService.getKeywordById(keyword.getKeyword_id());
	HttpServletResponse response = ServletActionContext.getResponse();
	response.setContentType("text/html;charset=utf-8");
	PrintWriter pw = response.getWriter();
	GsonBuilder gsonBuilder = new GsonBuilder();
 	 gsonBuilder.setPrettyPrinting();// 格式化json数据
 	 Gson gson = gsonBuilder.create();
 	 pw.write(gson.toJson(keyword));
}
}

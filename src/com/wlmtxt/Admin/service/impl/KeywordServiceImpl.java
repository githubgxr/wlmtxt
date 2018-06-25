package com.wlmtxt.Admin.service.impl;

import com.wlmtxt.Admin.dao.KeywordDao;
import com.wlmtxt.Admin.service.KeywordService;
import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.VO.KeywordVO;

import util.TeamUtil;

public class KeywordServiceImpl implements KeywordService {
private KeywordDao keywordDao;

public KeywordDao getKeywordDao() {
	return keywordDao;
}

public void setKeywordDao(KeywordDao keywordDao) {
	this.keywordDao = keywordDao;
}

@Override
public boolean addKeyword(wlmtxt_keyword keyword) {
	keyword.setKeyword_id(TeamUtil.getUuid());
	String time = TeamUtil.getStringSecond();
	keyword.setKeyword_gmt_modified(time);
	keyword.setKeyword_gmt_create(time);
	if(keywordDao.addKeyword(keyword)){
		return true;
	}else{
		return false;
	}
}

@Override
public boolean updateKeyword(wlmtxt_keyword keyword) {
	String time = TeamUtil.getStringSecond();
	keyword.setKeyword_gmt_modified(time);
	if(keywordDao.updateKeyword(keyword)){
		return true;
	}else{
		return false;
	}
}

@Override
public boolean deleteKeyword(String keywordIDAll) {
	String[] arr = keywordIDAll.split(",");
	for(String keyword_id : arr){
		keywordDao.deleteAdmin(keyword_id);
	}
	return true;
}


@Override
public void getKeywordListBysearchPage(KeywordVO keywordVO) {
	int count = keywordDao.getCountKeywordList(keywordVO);
	//keywordVO.setTotalCount(count);
	//keywordVO.setPageSize(10);
	//keywordVO.setTotalPage((int) Math.ceil((double) count / keywordVO.getPageSize()));
	keywordDao.getKeywordListByPage(keywordVO);
}

@Override
public wlmtxt_keyword getKeywordById(String keyword_id) {
	return keywordDao.getKeywordById(keyword_id);
}

}

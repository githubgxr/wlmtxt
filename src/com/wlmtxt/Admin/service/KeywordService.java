package com.wlmtxt.Admin.service;

import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.VO.KeywordVO;

public interface KeywordService {

public 	boolean addKeyword(wlmtxt_keyword keyword);

public boolean updateKeyword(wlmtxt_keyword keyword);

public boolean deleteKeyword(String keywordIDAll);

public void getKeywordListBysearchPage(KeywordVO keywordVO);

public wlmtxt_keyword getKeywordById(String keyword_id);

}

package com.wlmtxt.Admin.dao;

import com.wlmtxt.domain.DO.wlmtxt_keyword;
import com.wlmtxt.domain.VO.KeywordVO;

public interface KeywordDao {

public	boolean addKeyword(wlmtxt_keyword keyword);

public boolean updateKeyword(wlmtxt_keyword keyword);

public void deleteAdmin(String keyword_id);

public int getCountKeywordList(KeywordVO keywordVO);

public wlmtxt_keyword getKeywordById(String keyword_id);

public void getKeywordListByPage(KeywordVO keywordVO);

}

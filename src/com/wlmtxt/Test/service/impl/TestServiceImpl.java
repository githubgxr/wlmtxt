package com.wlmtxt.Test.service.impl;

import com.wlmtxt.domain.DO.Test;
import com.wlmtxt.Test.dao.TestDao;

public class TestServiceImpl implements com.wlmtxt.Test.service.TestService {

	private TestDao testDao;
	
	public Test test(Test t) {
		return testDao.test(t);
	}

	public TestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}
	
}

package com.wlmtxt.Test.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wlmtxt.Test.service.TestService;
import com.wlmtxt.domain.DO.Test;

public class TestAction extends ActionSupport {

	private Test t;
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@org.junit.Test
	public String test() {
		t.setId("1");
		Test new_t = testService.test(t);
		if (new_t.equals(null)) {
			return ERROR;
		} else {
			return SUCCESS;
		}
	}

	public Test getT() {
		return t;
	}

	public void setT(Test t) {
		this.t = t;
	}
}

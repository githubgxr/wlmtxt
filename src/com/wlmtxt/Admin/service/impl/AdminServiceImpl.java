package com.wlmtxt.Admin.service.impl;

import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.Admin.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}
}

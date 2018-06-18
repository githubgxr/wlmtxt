package com.wlmtxt.Admin.service.impl;


import java.util.List;
import java.util.UUID;

import org.hibernate.*;


import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.Admin.service.AdminService;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_user;

public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	@Override
	public boolean adminLogin(wlmtxt_admin admin) {
		
		return adminDao.adminLogin(admin);
	}

	@Override
	public wlmtxt_admin getAdmin(wlmtxt_admin admin) {
		return adminDao.getAdmin(admin);
	}

	@Override
	public void saveAdmin(wlmtxt_admin admin) {

		admin.setAdmin_id(UUID.randomUUID().toString());
		admin.setAdmin_admin("2");
		adminDao.saveAdmin(admin);
	}

	@Override
	public void removeAdmin(wlmtxt_admin admin) {
		adminDao.removeAdmin(admin);
	}

	@Override
	public void updateAdmin(wlmtxt_admin admin) {

		adminDao.updateAdmin(admin);
	}

	@Override
	public List<wlmtxt_admin> listAdmin() {

		return adminDao.listAdmin();
	}


}

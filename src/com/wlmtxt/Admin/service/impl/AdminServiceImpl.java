package com.wlmtxt.Admin.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.hibernate.*;


import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.Admin.service.AdminService;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DTO.CategoryListDTO;
import com.wlmtxt.domain.VO.AdminVO;

import util.TeamUtil;

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
	public wlmtxt_admin adminLogin(wlmtxt_admin admin) {
		wlmtxt_admin admin_login = adminDao.adminLogin(admin);
		return admin_login;
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
	public boolean updateAdmin(wlmtxt_admin admin) {
		admin.setAdmin_gmt_modified(TeamUtil.getStringSecond());
		System.out.println(admin+"sssssss");
		return adminDao.updateAdmin(admin);
	}

	@Override
	public List<wlmtxt_admin> listAdmin() {

		return adminDao.listAdmin();
	}
	
	@Override
	public boolean addFirst_menu(wlmtxt_first_menu first_menu) {
		first_menu.setFirst_menu_id(TeamUtil.getUuid());
		String time = TeamUtil.getStringSecond();
		first_menu.setFirst_menu_gmt_create(time);
		first_menu.setFirst_menu_gmt_modified(time);
		if(adminDao.addFirst_menu(first_menu)){
    	   return true;
       }else{
    	   return false;  
       }
	}
	
	@Override
	public List<CategoryListDTO> listCategoryOneAndSon() {
		List<wlmtxt_first_menu> categoryList = adminDao.listCategory();

		List<CategoryListDTO> categoryListDTOList = new ArrayList<CategoryListDTO>();

		List<wlmtxt_second_menu> sonCategoryList = new ArrayList<wlmtxt_second_menu>();

		for (wlmtxt_first_menu tmpCategory : categoryList) {

			sonCategoryList = adminDao.listCategoryByFather(tmpCategory.getFirst_menu_id());

			categoryListDTOList.add(new CategoryListDTO(tmpCategory, sonCategoryList));

		}

		return categoryListDTOList;
	}
	@Override
	public boolean addSecond_menu(wlmtxt_second_menu second_menu) {
		System.out.println(second_menu+"ccc");
		second_menu.setSecond_menu_id(TeamUtil.getUuid());
		String time = TeamUtil.getStringSecond();
		second_menu.setSecond_menu_gmt_create(time);
		second_menu.setSecond_menu_gmt_modified(time);
		if(adminDao.addSecond_menu(second_menu)){
    	   return true;
       }else{
    	   return false;  
       }
	}
	@Override
	public boolean deleteFirst_munu(String first_menu_id) {
	   List<wlmtxt_second_menu> second_menuList = adminDao.getSecond_menuByFirstId(first_menu_id);
	   System.out.println("d"+second_menuList);
		for(wlmtxt_second_menu second_menu : second_menuList){
			System.out.println("111"+second_menu.getSecond_menu_id());
			adminDao.deleteSecond_menu(second_menu.getSecond_menu_id());
		}
		adminDao.deleteFirst_munu(first_menu_id);
	   return true;
	}
	@Override
	public boolean deleteSecond_menu(String second_menu_id) {
		 adminDao.deleteSecond_menu(second_menu_id);
		 return true;
	}
	@Override
	public boolean updateFirst_menu(wlmtxt_first_menu first_menu) {
		String time = TeamUtil.getStringSecond();
		first_menu.setFirst_menu_gmt_modified(time);
		if(adminDao.updateFirst_menu(first_menu)){
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public boolean updateSecond_menu(wlmtxt_second_menu second_menu) {
		String time = TeamUtil.getStringSecond();
		second_menu.setSecond_menu_gmt_modified(time);
		if(adminDao.updateSecond_menu(second_menu)){
			return true;
		}else{
			return false;
		}
		
	}
	@Override
	public wlmtxt_first_menu getFirst_menuById(String first_menu_id) {
		return adminDao.getFirst_menuById(first_menu_id);
	}
	@Override
	public wlmtxt_second_menu getSecondById(String second_menu_id) {
		return adminDao.getSecondById(second_menu_id);
	}
	@Override
	public boolean addAdmin(wlmtxt_admin admin) {
		admin.setAdmin_id(TeamUtil.getUuid());
		String time = TeamUtil.getStringSecond();
		admin.setAdmin_gmt_create(time);
		admin.setAdmin_gmt_modified(time);
		if(adminDao.addAdmin(admin)){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public void getAdminListBysearchPage(AdminVO adminVO) {
		int count = adminDao.getCountAdminList(adminVO);
		//adminVO.setTotalCount(count);
		//adminVO.setPageSize(10);
		//adminVO.setTotalPage((int) Math.ceil((double) count / adminVO.getPageSize()));
		adminDao.getAdminListByPage(adminVO);
	}
	@Override
	public wlmtxt_admin getAdminById(String admin_id) {
	     
		return adminDao.getAdminById(admin_id);
	}
	@Override
	public boolean deleteAdmin(String adminIDAll) {
		String[] arr = adminIDAll.split(",");
		for(String admin_id : arr){
			adminDao.deleteAdmin(admin_id);
		}
		return true;
	}
}

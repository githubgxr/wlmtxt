package com.wlmtxt.Admin.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;

public interface AdminService {
	/**
	 * 管理员登录验证
	 * @param admin
	 * 				使用admin对象的用户名、密码匹配数据库有无此对象
	 * @return	返回一个wlmtxt_admin对象
	 * 
	 * @author 王鹏志
	 */
	public boolean adminLogin(wlmtxt_admin admin);
	
	
	/**
	 * 查询一个管理员
	 * @param admin
	 * 						使用admin对象的用户名、密码匹配数据库有无此对象
	 * @return	返回一个wlmtxt_admin对象
	 * 
	 * @author no one
	 */
	public wlmtxt_admin getAdmin(wlmtxt_admin admin);
	
	/**
	 * 添加管理员
	 * @param admin
	 * 						在数据库保存此对象
	 * @author no one
	 */
	public void saveAdmin(wlmtxt_admin admin);
	
	/**
	 * 删除管理员
	 * @param admin
	 * 						匹配admin对想的id属性删除记录
	 * @author no one
	 */
	public void removeAdmin(wlmtxt_admin admin);
	
	/**
	 * 更新管理员
	 * @param admin
	 * 						匹配admin的id属性更新记录
	 * @author 王鹏志
	 */	
	public void updateAdmin (wlmtxt_admin admin);
	
	/**
	 * 查询所有管理员，前台分页列表显示
	 * @return	管理员记录列表
	 * @author 王鹏志
	 */
	public List<wlmtxt_admin> listAdmin();
}

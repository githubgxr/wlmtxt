package com.wlmtxt.Admin.service;

import java.util.List;

import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DTO.CategoryListDTO;
import com.wlmtxt.domain.VO.AdminVO;

public interface AdminService {
	/**
	 * 管理员登录验证
	 * @param admin
	 * 				使用admin对象的用户名、密码匹配数据库有无此对象
	 * @return	返回一个wlmtxt_admin对象
	 * 
	 * @author 王鹏志
	 */
	public wlmtxt_admin adminLogin(wlmtxt_admin admin);
	
	
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
	 * @return 
	 */	
	public boolean updateAdmin (wlmtxt_admin admin);
	
	/**
	 * 查询所有管理员，前台分页列表显示
	 * @return	管理员记录列表
	 * @author 王鹏志
	 */
	public List<wlmtxt_admin> listAdmin();

     /*
      * 一级分类的添加
      */
	public boolean addFirst_menu(wlmtxt_first_menu first_menu);

    /*
     * 得到菜单
     */
	public List<CategoryListDTO> listCategoryOneAndSon();
   /*
    * 添加二级分类
    */

	public boolean addSecond_menu(wlmtxt_second_menu second_menu);

    /*
     * 删除一级菜单
     */
	public boolean deleteFirst_munu(String first_menu_id);
   /*
    * 删除二级菜单
    */

	public boolean deleteSecond_menu(String second_menu_id);

   /*
    * 一级菜单的修改
    */
	public boolean updateFirst_menu(wlmtxt_first_menu first_menu);

  /*
   * 二级菜单的修改
   */
	public boolean updateSecond_menu(wlmtxt_second_menu second_menu);
   /*
    * 根据一级菜单id得到一级菜单的记录
    */

	public wlmtxt_first_menu getFirst_menuById(String first_menu_id);

   /*
    * 根据二级菜单id得到二级菜单
    */
	public wlmtxt_second_menu getSecondById(String second_menu_id);

   /*
    * 添加管理员
    */
	public boolean addAdmin(wlmtxt_admin admin);

    /*
     * 删除管理员
     */
	
	public boolean deleteAdmin(String adminIDAll);
     /*
      *管理员的分页
      */
	public void getAdminListBysearchPage(AdminVO adminVO);
   /*
    * 根据id得到管理员信息
    */
	public wlmtxt_admin getAdminById(String admin_id);


	

  
}

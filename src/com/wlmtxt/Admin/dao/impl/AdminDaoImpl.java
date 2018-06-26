package com.wlmtxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Admin.dao.AdminDao;
import com.wlmtxt.domain.DO.wlmtxt_admin;
import com.wlmtxt.domain.DO.wlmtxt_first_menu;
import com.wlmtxt.domain.DO.wlmtxt_second_menu;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.AdminVO;
import com.wlmtxt.domain.VO.CountVO;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public wlmtxt_admin adminLogin(wlmtxt_admin admin) {
		Session session = getSession();
		String hql = "from wlmtxt_admin where admin_username='" + admin.getAdmin_username() + "' and admin_password='"
				+ admin.getAdmin_password() + "'";
		Query query = session.createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		return new_admin;
	}

	@Override
	public wlmtxt_admin getAdmin(wlmtxt_admin admin) {
		Session session = getSession();
		String hql = "from wlmtxt_admin where admin_id='" + admin.getAdmin_id() + "'";
		Query query = session.createQuery(hql);
		wlmtxt_admin new_admin = (wlmtxt_admin) query.uniqueResult();
		return new_admin;
	}

	@Override
	public void saveAdmin(wlmtxt_admin admin) {
		try {
			// id和是否为超级管理员的赋值在service层
			Session session = getSession();
			session.saveOrUpdate(admin);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAdmin(wlmtxt_admin admin) {
		try {
			Session session = getSession();
			session.delete(admin);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<wlmtxt_admin> listAdmin() {
		Session session = getSession();
		String hql = "from wlmtxt_admin";
		Query query = session.createQuery(hql);
		List<wlmtxt_admin> admin_list = query.list();
		return admin_list;
	}

	@Override
	public boolean addFirst_menu(wlmtxt_first_menu first_menu) {
		Session session = getSession();
		session.save(first_menu);
		session.flush();
		return true;
	}

	@Override
	public List<wlmtxt_first_menu> listFirst_menuAll() {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu";
		Query query = session.createQuery(hql);
		List<wlmtxt_first_menu> fristMenuList = query.list();
		return fristMenuList;
	}

	@Override
	public List<wlmtxt_second_menu> listCategoryByFather(String first_menu_id) {
		Session session = getSession();

		String hql = "from wlmtxt_second_menu where second_menu_first_menu_id='" + first_menu_id
				+ "' order by second_menu_gmt_modified desc";

		Query query = session.createQuery(hql);
		List<wlmtxt_second_menu> secondMenuList = query.list();
		return secondMenuList;
	}

	@Override
	public List<wlmtxt_first_menu> listCategory() {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu order by first_menu_gmt_modified desc";
		Query query = session.createQuery(hql);
		List<wlmtxt_first_menu> fristMenuList = query.list();
		return fristMenuList;
	}

	@Override
	public boolean addSecond_menu(wlmtxt_second_menu second_menu) {
		Session session = getSession();
		session.save(second_menu);
		session.flush();
		return true;
	}

	@Override
	public List<wlmtxt_second_menu> getSecond_menuByFirstId(String first_menu_id) {
		Session session = getSession();

		String hql = "from wlmtxt_second_menu where second_menu_first_menu_id='" + first_menu_id
				+ "' order by second_menu_gmt_modified desc";
		Query query = session.createQuery(hql);
		List<wlmtxt_second_menu> second_menuList = query.list();
		return second_menuList;

	}

	@Override
	public void deleteSecond_menu(String second_menu_id) {
		Session session = getSession();
		System.out.println("dao" + second_menu_id);
		String hql = "delete  from wlmtxt_second_menu where second_menu_id='" + second_menu_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void deleteFirst_munu(String first_menu_id) {
		Session session = getSession();
		String hql = "delete from wlmtxt_first_menu where first_menu_id='" + first_menu_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
	}

	@Override
	public boolean updateFirst_menu(wlmtxt_first_menu first_menu) {
		Session session = getSession();
		session.update(first_menu);
		session.flush();
		return true;
	}

	@Override
	public boolean updateSecond_menu(wlmtxt_second_menu second_menu) {
		Session session = getSession();
		session.update(second_menu);
		session.flush();
		return true;

	}

	@Override
	public wlmtxt_first_menu getFirst_menuById(String first_menu_id) {
		Session session = getSession();
		String hql = "from wlmtxt_first_menu where first_menu_id='" + first_menu_id + "'";
		Query query = session.createQuery(hql);
		wlmtxt_first_menu first_menu = (wlmtxt_first_menu) query.uniqueResult();
		return first_menu;
	}

	@Override
	public wlmtxt_second_menu getSecondById(String second_menu_id) {
		Session session = getSession();
		String hql = "from wlmtxt_second_menu where second_menu_id='" + second_menu_id + "'";
		Query query = session.createQuery(hql);
		wlmtxt_second_menu second_menu = (wlmtxt_second_menu) query.uniqueResult();
		return second_menu;
	}

	@Override
	public boolean addAdmin(wlmtxt_admin admin) {
		try {
			Session session = getSession();
			session.save(admin);
			session.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAdmin(wlmtxt_admin admin) {
		try {
			Session session = getSession();
			System.out.println("admin" + admin);
			session.update(admin);
			session.flush();
			System.out.println(admin + "update");
			session.clear();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public wlmtxt_admin getAdminById(String admin_id) {
		Session session = getSession();
		String hql = "from wlmtxt_admin where admin_id='" + admin_id + "'";
		Query query = session.createQuery(hql);
		wlmtxt_admin admin = (wlmtxt_admin) query.uniqueResult();
		return admin;
	}

	@Override
	public int getCountAdminList(AdminVO adminVO) {
		Session session = getSession();
		String hql = "select count(*) from wlmtxt_admin where 1=1";
		if (adminVO.getAdmin_username() != null && adminVO.getAdmin_username().trim().length() > 0)
			hql = hql + " and admin_username like '%" + adminVO.getAdmin_username() + "%'";
		long count = (long) session.createQuery(hql).uniqueResult();
		return (int) count;
	}

	@Override
	public void getAdminListByPage(AdminVO adminVO) {
	
		Session session = getSession();
		List<wlmtxt_admin> adminList = new ArrayList<wlmtxt_admin>();
		String hql = "from wlmtxt_admin where 1=1 ";
		if (adminVO.getAdmin_username() != null && adminVO.getAdmin_username().trim().length() > 0)
			hql = hql + " and admin_username like '%" + adminVO.getAdmin_username() + "%'";
		hql = hql + " order by admin_gmt_modified desc";

		Query query = session.createQuery(hql);	
//		query.setFirstResult(
//				(adminVO.getCurrPage() - 1) * adminVO.getPageSize());
//		query.setMaxResults(adminVO.getPageSize());

		adminList = query.list();
		adminVO.setWlmtxt_adminList(adminList);
		session.clear();
	}

	@Override
	public void deleteAdmin(String admin_id) {
		Session session = getSession();
		String hql = "delete from wlmtxt_admin where admin_id='" + admin_id + "'";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.flush();
		session.clear();
	}

	@Override
	public boolean updatePassword(wlmtxt_admin admin) {
		try {
			Session session = getSession();
			session.update(admin);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public int count(CountVO countVO) {
		Session session = getSession();
		String start_time = "";
		String stop_time = "";
		
		String hql = " select count(*) from wlmtxt_user where 1=1 ";
				
		if(countVO.getStart_time()!=null && countVO.getStart_time().length()>0) {
			start_time=countVO.getStart_time();
		}
		if(countVO.getStop_time()!=null && countVO.getStop_time().length()>0) {
			stop_time=countVO.getStop_time();
		}
			hql+=" and user_gmt_modified between str_to_date('"+start_time+"', '%Y-%m-%d %H:%i:%s') and str_to_date('"+stop_time+"', '%Y-%m-%d %H:%i:%s')";
		
		long count = (long) session.createQuery(hql).uniqueResult();
		
		session.clear();
		return (int) count;
	}

	@Override
	public int countWorks(CountVO countVO) {
		Session session = getSession();
		String start_time = "";
		String stop_time = "";
		Long i;
		String hql = "select count(*) from  wlmtxt_works where 1=1 ";
				
		if(countVO.getStart_time()!=null && countVO.getStart_time().length()>0) {
			start_time=countVO.getStart_time();
		}
		if(countVO.getStop_time()!=null && countVO.getStop_time().length()>0) {
			stop_time=countVO.getStop_time();
		}
			hql+=" and works_gmt_modified between str_to_date('"+start_time+"', '%Y-%m-%d %H:%i:%s') and str_to_date('"+stop_time+"', '%Y-%m-%d %H:%i:%s')";
		Query query=session.createQuery(hql);
		
		i=(Long) query.uniqueResult();
		session.clear();
		System.out.println(i);
		return i.intValue();
	}

	@Override
	public int countWorksHistory(CountVO countVO) {
		Session session = getSession();
		String start_time = "";
		String stop_time = "";
		Long i;
		String hql = "select count(*) from wlmtxt_play_history where 1=1 ";
				
		if(countVO.getStart_time()!=null && countVO.getStart_time().length()>0) {
			start_time=countVO.getStart_time();
		}
		if(countVO.getStop_time()!=null && countVO.getStop_time().length()>0) {
			stop_time=countVO.getStop_time();
		}
			hql+=" and play_history_gmt_modified between str_to_date('"+start_time+"', '%Y-%m-%d %H:%i:%s') and str_to_date('"+stop_time+"', '%Y-%m-%d %H:%i:%s')";
		Query query=session.createQuery(hql);
		
		i=(Long) query.uniqueResult();
		session.clear();
		System.out.println(i);
		return i.intValue();
	}

	@Override
	public List<wlmtxt_second_menu> getwlmtxt_second_menuAll() {
		Session session = getSession();
		String hql = "from wlmtxt_second_menu order by second_menu_gmt_modified desc";
		Query query = session.createQuery(hql);
		List<wlmtxt_second_menu> wlmtxt_second_menuList = query.list();
		return wlmtxt_second_menuList;
	}

	@Override
	public List<wlmtxt_works> getworksBysecone_menu_id(CountVO countVO, wlmtxt_second_menu second_menu) {
		Session session = getSession();
		String start_time = "";
		String stop_time = "";
		Long i;
		String hql = "from wlmtxt_works where works_second_menu_id='"+second_menu.getSecond_menu_id()+"' ";
				
		if(countVO.getStart_time()!=null && countVO.getStart_time().length()>0) {
			start_time=countVO.getStart_time();
		}
		if(countVO.getStop_time()!=null && countVO.getStop_time().length()>0) {
			stop_time=countVO.getStop_time();
		}
			hql+=" and works_gmt_modified between str_to_date('"+start_time+"', '%Y-%m-%d %H:%i:%s') and str_to_date('"+stop_time+"', '%Y-%m-%d %H:%i:%s')";
		Query query=session.createQuery(hql);
		List<wlmtxt_works> wlmtxt_worksList = query.list();
		session.clear();
		return wlmtxt_worksList;
	}

	@Override
	public int gethistoryByworkid(CountVO countVO, wlmtxt_works work) {
		Session session = getSession();
		String start_time = "";
		String stop_time = "";
		Long i;
		String hql = "select count(*) from wlmtxt_play_history where play_history_works_id='"+work.getWorks_id()+"' ";
				
		if(countVO.getStart_time()!=null && countVO.getStart_time().length()>0) {
			start_time=countVO.getStart_time();
		}
		if(countVO.getStop_time()!=null && countVO.getStop_time().length()>0) {
			stop_time=countVO.getStop_time();
		}
			hql+=" and play_history_gmt_modified between str_to_date('"+start_time+"', '%Y-%m-%d %H:%i:%s') and str_to_date('"+stop_time+"', '%Y-%m-%d %H:%i:%s')";
		Query query=session.createQuery(hql);
		
		i=(Long) query.uniqueResult();
		session.clear();
		System.out.println(i);
		return i.intValue();
	}

}

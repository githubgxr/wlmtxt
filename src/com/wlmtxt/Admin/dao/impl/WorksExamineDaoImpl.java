package com.wlmtxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Admin.dao.WorksExamineDao;
import com.wlmtxt.domain.DO.wlmtxt_recommend;
import com.wlmtxt.domain.DO.wlmtxt_works;
import com.wlmtxt.domain.VO.WorksVO;

public class WorksExamineDaoImpl implements WorksExamineDao {
private SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}
public Session getSession() {
	return this.sessionFactory.getCurrentSession();
}
@Override
public int getCountworksListThree(WorksVO worksVO) {
	
	Session session = this.getSession();
	String hql = "select count(*) from wlmtxt_works where 1=1";
	if (worksVO.getWorks_deleted() != null
			&& worksVO.getWorks_deleted().trim().length() > 0)
		hql = hql + " and works_deleted like '%" + worksVO.getWorks_deleted() + "%'";
	if (worksVO.getWorks_passed() != null
			&& worksVO.getWorks_passed().trim().length() > 0)
		hql = hql + " and works_passed like'%" + worksVO.getWorks_passed() + "%'";
	if (worksVO.getWorks_title() != null
			&& worksVO.getWorks_title().trim().length() > 0)
		hql = hql + " and works_title like'%" + worksVO.getWorks_title() + "%'";
	
	long count = (long) session.createQuery(hql).uniqueResult();
return (int) count;
}
@Override
public void getworksListThreeByPage(WorksVO worksVO) {

	Session session = getSession();
	List<wlmtxt_works> workList = new ArrayList<wlmtxt_works>();
	String hql = "from wlmtxt_works where 1=1 ";
	if (worksVO.getWorks_deleted() != null
			&& worksVO.getWorks_deleted().trim().length() > 0)
		hql = hql + " and works_deleted like '%" + worksVO.getWorks_deleted() + "%'";
	if (worksVO.getWorks_passed() != null
			&& worksVO.getWorks_passed().trim().length() > 0)
		hql = hql + " and works_passed like'%" + worksVO.getWorks_passed() + "%'";
	if (worksVO.getWorks_title() != null
			&& worksVO.getWorks_title().trim().length() > 0)
		hql = hql + " and works_title like'%" + worksVO.getWorks_title() + "%'";
	hql = hql + " order by works_gmt_modified desc";
	Query query = session.createQuery(hql);	
	query.setFirstResult(
			(worksVO.getCurrPage() - 1) * worksVO.getPageSize());
	query.setMaxResults(worksVO.getPageSize());
	workList = query.list();
	worksVO.setWlmtxt_worksList(workList);
	System.out.println(hql);
	session.clear();

}
@Override
public wlmtxt_works getWorksById(String works_id) {
	Session session = getSession();
	String hql = "from wlmtxt_works where works_id='"+works_id+"'";
	Query query = session.createQuery(hql);
	wlmtxt_works wlmtxt_work  = (wlmtxt_works) query.uniqueResult();
	session.clear();
	return wlmtxt_work;
}
@Override
public boolean delete(wlmtxt_works wlmtxt_work) {
	Session session = getSession();
	session.update(wlmtxt_work);
	session.flush();
	return true;
}
@Override
public boolean passed(wlmtxt_works wlmtxt_work) {
	Session session = getSession();
	session.update(wlmtxt_work);
	session.flush();
	return true;
}
@Override
public List<wlmtxt_recommend> listrecommend() {
		Session session = getSession();
		String hql = "from wlmtxt_recommend";
		Query query = session.createQuery(hql);
		List<wlmtxt_recommend> wlmtxt_recommendList = query.list();
		session.clear();
		return wlmtxt_recommendList;
}
@Override
public int getMaxSort() {
	Session session = getSession();
	String hql ="select count(*) from wlmtxt_recommend";
	long count = (long) session.createQuery(hql).uniqueResult();
	System.out.println(count+"1111111111111111");
	return (int) count;
}
@Override
public boolean addRecommend(wlmtxt_recommend recommend) {
try {
	Session session = getSession();
	session.save(recommend);
	session.flush();
	session.clear();
	return true;
} catch (Exception e) {
	e.printStackTrace();
	return false;
}
}
@Override
public void deleteAdmin(String recommend_id) {
	Session session = getSession();
	String hql = "delete from wlmtxt_recommend where recommend_id='"+recommend_id+"'";
	Query query =session .createQuery(hql);
	query.executeUpdate();
	session.flush();
	session.clear();
	
}
@Override
public wlmtxt_recommend get_Recommend_byID(String recommend_id) {
	Session session = getSession();
	String hql = "from wlmtxt_recommend where recommend_id='"+recommend_id+"'";
	Query query = session.createQuery(hql);
	wlmtxt_recommend recommend = (wlmtxt_recommend) query.uniqueResult();
	return recommend;
}
@Override
public List<wlmtxt_recommend> get_RecommendChangeValue(String recommend_sort) {
	Session session = getSession();
	String hql = "from wlmtxt_recommend where recommend_sort >'" + recommend_sort + "' order by recommend_sort asc";
			 
	Query query = session.createQuery(hql);
	query.setFirstResult(0);
	query.setMaxResults(1);
	List<wlmtxt_recommend> recommendList = query.list();

	return recommendList;
}
@Override
public void updateRecommend(wlmtxt_recommend recommend2) {
	try {
		Session session = getSession();
		session.update(recommend2);
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
@Override
public List<wlmtxt_recommend> get_RecommendChangeValueSmall(String recommend_sort) {
	Session session = getSession();
	String hql = "from wlmtxt_recommend where recommend_sort <'" + recommend_sort + "' order by recommend_sort desc";
	Query query = session.createQuery(hql);
	query.setFirstResult(0);
	query.setMaxResults(1);
	List<wlmtxt_recommend> recommendList = query.list();

	return recommendList;
}
@Override
public boolean getWorksOneById(String works_id) {
	try {
		Session session = getSession();
		String hql = "from wlmtxt_works where works_id='"+works_id+"'";
		Query query = session.createQuery(hql);
		wlmtxt_works works = (wlmtxt_works) query.uniqueResult();
		if(works!=null){
			return true;
		}else{
			return false;
		}
	} catch (Exception e) {
		e.printStackTrace();
		return false;
	}
}

}

package com.wlmtxt.Admin.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.wlmtxt.Admin.dao.WorksExamineDao;
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
	// TODO Auto-generated method stub
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
	// TODO Auto-generated method stub
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
	hql = hql + " order by works_gmt_create desc";
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


}

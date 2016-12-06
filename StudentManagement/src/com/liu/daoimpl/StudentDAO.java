package com.liu.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.liu.dao.IStudentDAO;
import com.liu.model.Kecheng;
import com.liu.model.Plan;
import com.liu.model.Student;
import com.liu.model.Subject;

public class StudentDAO implements IStudentDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List login(int studentid, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Student> list=null;
		try {
			String hql="from Student where studentid="+studentid+" and password='"+password+"'";
			//System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getClazz().setName(list.get(i).getClazz().getName());
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listPlan(int subjectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Plan> list=null;
		try {
			String hql="from Plan as p where p.subject.subjectid="+subjectid+"";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listPlanDetail(int planid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List list=null;
		try {
			String hql="from Detail as d where d.plan.planid="+planid+"";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listAllCompulsory(int subjectid, String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng where subject="+subjectid+" and term='"+term+"' and iselective="+0+" and totaltime !=0";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());;
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return list;
	}

	@Override
	public List listAllElective(int subjectid, String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng where subject="+subjectid+" and term='"+term+"' and iselective="+1+" and totaltime !=0";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());;
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listAllPractice(int subjectid, String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng where subject="+subjectid+" and term='"+term+"' and totaltime="+0+"";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());;
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List getInfo(int studentid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Student> list=null;
		try {
			String hql="from Student where studentid="+studentid+"";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				list.get(i).getClazz().setName(list.get(i).getClazz().getName());
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());
			}
			transaction.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public boolean updateInfo(Student student) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.update(student);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally
		{
			session.close();
		}
		return false;
	}


}

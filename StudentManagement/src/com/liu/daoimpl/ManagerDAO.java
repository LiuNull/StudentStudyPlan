package com.liu.daoimpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.objectweb.asm.xwork.tree.IntInsnNode;

import com.liu.dao.IManagerDAO;
import com.liu.model.Detail;
import com.liu.model.Kecheng;
import com.liu.model.Manager;
import com.liu.model.Plan;
import com.liu.model.Student;

public class ManagerDAO implements IManagerDAO {
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List login(int managerid, String password) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Manager> list=null;
		try {
			String hql="from Manager where managerid="+managerid+" and password='"+password+"'";
			System.out.println(hql);
			Query query=session.createQuery(hql);
			list=query.list();
			for(int i=0;i<list.size();i++)
			{
				//去除懒加载
				list.get(i).getSubject().setName(list.get(i).getSubject().getName());
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
	public List listAllKecheng(int subjectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.subject.id="+subjectid+" and week=0";
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
			transaction.commit();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listKechengByTerm(int subjectid, String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.subject.id="+subjectid+" and term='"+term+"' and week=0";
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
		finally{
			session.close();
		}
		return list;
	}

	@Override
	public Boolean addKecheng(Kecheng kecheng) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			session.save(kecheng);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public List searchKecheng(int kechengid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.kechengid="+kechengid+" and week=0";
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
	public Boolean updateKecheng(Kecheng kecheng) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.update(kecheng);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public List getInfo(int managerid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Manager> list=null;
		try {
			String hql="from Manager where managerid="+managerid+"";
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
	public boolean updateInfo(Manager manager) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.update(manager);
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

	@Override
	public List listAllPractice(int subjectid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.subject.id="+subjectid+" and totaltime=0";
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
			transaction.commit();
		}
		finally
		{
			session.close();
		}
		return list;
	}

	@Override
	public List listPracticeByTerm(int subjectid, String term) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.subject.id="+subjectid+" and term='"+term+"' and totaltime=0";
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
		finally{
			session.close();
		}
		return list;
	}

	@Override
	public Boolean addPractice(Kecheng kecheng) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			session.save(kecheng);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public List searchPractice(int kechengid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Kecheng> list=null;
		try {
			String hql="from Kecheng as k where k.kechengid="+kechengid+" and totaltime=0";
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
	public Boolean updatePractice(Kecheng kecheng) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.update(kecheng);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public Boolean addPlan(Plan plan) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.save(plan);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}

	@Override
	public List listdetail(int planid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		List<Detail> list=null;
		try {
			String hql="from Detail as d where d.plan.id="+planid+"";
			Query query=session.createQuery(hql);
			list=query.list();
			System.out.println(planid+"号培养计划的长度："+list.size());
			for(int i=0;i<list.size();i++)
			{
//				Kecheng kecheng=new Kecheng();
//				kecheng.setCredit(list.get(i).getKecheng().getCredit());
//				kecheng.setIselective(list.get(i).getKecheng().getIselective());
//				kecheng.setKechengid(list.get(i).getKecheng().getKechengid());
//				kecheng.setName(list.get(i).getKecheng().getName());
//				kecheng.setTerm(list.get(i).getKecheng().getTerm());
//				kecheng.setTotaltime(list.get(i).getKecheng().getTotaltime());
//				kecheng.setWeek(list.get(i).getKecheng().getWeek());
//				list.get(i).setKecheng(kecheng);
				list.get(i).getKecheng().setName(list.get(i).getKecheng().getName());
				list.get(i).getKecheng().getSubject().setSubjectid(list.get(i).getKecheng().getSubject().getSubjectid());
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
	public Boolean addDetail(Detail detail) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try {
			session.save(detail);
			transaction.commit();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		return false;
	}
}

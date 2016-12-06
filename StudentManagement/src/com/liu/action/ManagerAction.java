package com.liu.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.liu.model.Detail;
import com.liu.model.Kecheng;
import com.liu.model.Manager;
import com.liu.model.Plan;
import com.liu.model.Student;
import com.liu.model.Subject;
import com.liu.service.IManagerService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport {
	private IManagerService managerService;
	private int managerid;
	private String password;
	private String term;
	private int kechengid;
	private String name;
	private float credit;
	private int totaltime;
	private int week;
	private int iselective;
	private String newpassword;
	private String newpassword2;
	private int age;
	private int sex;
	private int planid;
	private Set<Detail> details;
	private int somekechengid[];
	private int somepracticeid[];
	
	public int[] getSomepracticeid() {
		return somepracticeid;
	}

	public void setSomepracticeid(int[] somepracticeid) {
		this.somepracticeid = somepracticeid;
	}

	public int[] getSomekechengid() {
		return somekechengid;
	}

	public void setSomekechengid(int[] somekechengid) {
		this.somekechengid = somekechengid;
	}

	public Set<Detail> getDetails() {
		return details;
	}

	public void setDetails(Set<Detail> details) {
		this.details = details;
	}

	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public String getNewpassword2() {
		return newpassword2;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}

	public int getKechengid() {
		return kechengid;
	}

	public String getName() {
		return name;
	}

	public float getCredit() {
		return credit;
	}

	public int getTotaltime() {
		return totaltime;
	}

	public int getWeek() {
		return week;
	}

	public int getIselective() {
		return iselective;
	}

	public void setKechengid(int kechengid) {
		this.kechengid = kechengid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public void setTotaltime(int totaltime) {
		this.totaltime = totaltime;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public void setIselective(int iselective) {
		this.iselective = iselective;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getManagerid() {
		return managerid;
	}

	public String getPassword() {
		return password;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IManagerService getManagerService() {
		return managerService;
	}

	public void setManagerService(IManagerService managerService) {
		this.managerService = managerService;
	}
	
	public String login()
	{
		List<Manager> managers=managerService.login(managerid, password);
		if(managers!=null)
		{
			Manager manager=managers.get(0);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("manager", manager);
			session.setAttribute("managername", manager.getName());
			session.setAttribute("managersubject", manager.getSubject().getSubjectid());
			session.setAttribute("managersubjectname", manager.getSubject().getName());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("manager")!=null)
		{
			session.removeAttribute("manager");
		}
		return SUCCESS;
	}
	
	public String listPlan()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		List<Plan> plans=managerService.listPlan(subjectid);
		if(plans!=null)
		{
			session.setAttribute("plans", plans);
			//System.out.println(plans.get(0).getSubject());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listAllKecheng()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		List<Kecheng> kechengs=managerService.listAllKecheng(subjectid);
		if(kechengs!=null)
		{
			session.setAttribute("kechengs", kechengs);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listKechengByTerm()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		List<Kecheng> kechengs=managerService.listKechengByTerm(subjectid, term);
		if(kechengs!=null)
		{
			session.setAttribute("kechengs", kechengs);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String addKecheng()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		Manager manager=(Manager) session.getAttribute("manager");
		Subject subject=manager.getSubject();
		Kecheng kecheng=new Kecheng();
		kecheng.setCredit(credit);
		kecheng.setIselective(iselective);
		kecheng.setKechengid(kechengid);
		kecheng.setName(name);
		kecheng.setSubject(subject);
		kecheng.setTerm(term);
		kecheng.setTotaltime(totaltime);
		kecheng.setWeek(week);
		if(managerService.addKecheng(kecheng))
		{
			List<Kecheng> kechengs=managerService.listAllKecheng(subjectid);
			session.setAttribute("kechengs", kechengs);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String searchKecheng()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Kecheng> list=managerService.searchKecheng(kechengid);
		if(list!=null)
		{
			Kecheng kecheng=list.get(0);
			session.setAttribute("kecheng", kecheng);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String updateKecheng()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Kecheng kecheng1=(Kecheng) session.getAttribute("kecheng");
		int kechengid=kecheng1.getKechengid();
		List<Kecheng> list=managerService.searchKecheng(kechengid);
		Kecheng kecheng=list.get(0);
		kecheng.setCredit(credit);
		kecheng.setIselective(iselective);
		kecheng.setName(name);
		kecheng.setTerm(term);
		kecheng.setTotaltime(totaltime);
		kecheng.setWeek(week);
		if(managerService.updateKecheng(kecheng))
		{
			int subjectid=(Integer) session.getAttribute("managersubject");
			session.setAttribute("kecheng", kecheng);
			List<Kecheng> kechengs=managerService.listAllKecheng(subjectid);
			session.setAttribute("kechengs", kechengs);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String getInfo()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Manager manager=(Manager) session.getAttribute("manager");
		int managerid=manager.getManagerid();
		List<Manager> list=managerService.getInfo(managerid);
		if(list!=null)
		{
			Manager managerinfo=list.get(0);
//			System.out.println(studentinfo.getName());
			session.setAttribute("manager", managerinfo);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String updateInfo() {
		if(!newpassword.equals(newpassword2))
		{
			System.out.println(newpassword+"::"+newpassword2);
			return ERROR;
		}
		System.out.println(newpassword+":"+newpassword2);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Manager manager1=(Manager) session.getAttribute("manager");
		int managerid=manager1.getManagerid();
		List list=managerService.login(managerid, password);
		if(list==null)
		{
			
		}
		if(list!=null)
		{
			Manager manager=(Manager) list.get(0);
			manager.setAge(age);
			manager.setName(name);
			manager.setPassword(newpassword);
			manager.setSex(sex);
			if(managerService.updateInfo(manager))
			{

				session.removeAttribute("student");
				List list1=managerService.login(managerid, newpassword);
				Manager manager2=(Manager) list.get(0);
				session.setAttribute("manager", manager2);
				return SUCCESS;
			}
		}
		return ERROR;
	}
	
	public String listAllPractice()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		List<Kecheng> practices=managerService.listAllPractice(subjectid);
		if(practices!=null)
		{
			session.setAttribute("practices", practices);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listPracticeByTerm()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		List<Kecheng> practices=managerService.listPracticeByTerm(subjectid, term);
		if(practices!=null)
		{
			session.setAttribute("practices", practices);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String addPractice()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		Manager manager=(Manager) session.getAttribute("manager");
		Subject subject=manager.getSubject();
		Kecheng kecheng=new Kecheng();
		kecheng.setCredit(credit);
		kecheng.setIselective(iselective);
		kecheng.setKechengid(kechengid);
		kecheng.setName(name);
		kecheng.setSubject(subject);
		kecheng.setTerm(term);
		kecheng.setTotaltime(totaltime);
		kecheng.setWeek(week);
		if(managerService.addPractice(kecheng))
		{
			List<Kecheng> practices=managerService.listAllPractice(subjectid);
			session.setAttribute("practices", practices);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String searchPractice()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		List<Kecheng> list=managerService.searchPractice(kechengid);
		if(list!=null)
		{
			Kecheng practice=list.get(0);
			session.setAttribute("practice", practice);
			return SUCCESS;
		}
		return ERROR;
	}

	public String updatePractice()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Kecheng practice1=(Kecheng) session.getAttribute("practice");
		int kechengid=practice1.getKechengid();
		List<Kecheng> list=managerService.searchPractice(kechengid);
		Kecheng practice=list.get(0);
		practice.setCredit(credit);
		practice.setIselective(iselective);
		practice.setName(name);
		practice.setTerm(term);
		practice.setTotaltime(totaltime);
		practice.setWeek(week);
		if(managerService.updatePractice(practice))
		{
			int subjectid=(Integer) session.getAttribute("managersubject");
			session.setAttribute("practice", practice);
			List<Kecheng> practices=managerService.listAllPractice(subjectid);
			session.setAttribute("practices", practices);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listDetail()
	{
		List<Detail> details=managerService.listdetail(planid);
		List<Kecheng> detailKechengs = new ArrayList<Kecheng>();
		if(details!=null)
		{
			for(int i=0;i<details.size();i++)
			{
				//System.out.println(details.get(i).getKecheng().getName());
				detailKechengs.add(details.get(i).getKecheng());
			}
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("detailKechengs", detailKechengs);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String addPlan()
	{
		/*for(int i=0;i<somekechengid.length;i++)
		{
			System.out.println(somekechengid[i]);
		}*/
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("managersubject");
		Manager manager=(Manager) session.getAttribute("manager");
		Subject subject=manager.getSubject();
		Plan plan=new Plan();
		plan.setPlanid(planid);
		plan.setTerm(term);
		plan.setSubject(subject);
		if(managerService.addPlan(plan))
		{
			List<Plan> plans=managerService.listPlan(subjectid);
			session.setAttribute("plans", plans);
			if(somekechengid!=null)
			{
				for(int i=0;i<somekechengid.length;i++)
				{
					//System.out.println("添加记录："+somekechengid[i]);
					List<Kecheng> list=managerService.searchKecheng(somekechengid[i]);
					Kecheng kecheng=list.get(0);
					//System.out.println("获取课程成功");
					Detail detail=new Detail();
					detail.setKecheng(kecheng);
					detail.setPlan(plan);
					if(!managerService.addDetail(detail))
					{
						System.out.println("添加课程失败");
						return ERROR;
					}
				}
			}
			
			System.out.println("添加课程成功");
			
			if(somepracticeid!=null)
			{
				for(int i=0;i<somepracticeid.length;i++)
				{
					System.out.println("添加记录："+somepracticeid[i]);
					List<Kecheng> practices=(List<Kecheng>) managerService.searchPractice(somepracticeid[i]);
					Kecheng kecheng=practices.get(0);
					Detail detail=new Detail();
					detail.setKecheng(kecheng);
					detail.setPlan(plan);
					if(!managerService.addDetail(detail))
					{
						return ERROR;
					}
				}
				System.out.println("添加实践环节成功");
			}
			
			return SUCCESS;
		}
		return ERROR;
	}
}

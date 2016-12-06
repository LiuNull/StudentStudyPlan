
package com.liu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.liu.model.Detail;
import com.liu.model.JsonStudent;
import com.liu.model.Kecheng;
import com.liu.model.Plan;
import com.liu.model.Student;
import com.liu.service.IStudentService;
import com.liu.util.PrintFailJson;
import com.liu.util.PrintJson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class StudentAction extends ActionSupport {
	private int studentid;
	private String password;
	private IStudentService studentService;
	private int subjectid;
	private int planid;
	private String term;
	private String name;
	private int age;
	private int sex;
	private String newpassword;
	private String newpassword2;
	
	public String getNewpassword2() {
		return newpassword2;
	}

	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getSex() {
		return sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getPlanid() {
		return planid;
	}

	public void setPlanid(int planid) {
		this.planid = planid;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public int getStudentid() {
		return studentid;
	}
	
	public String getPassword() {
		return password;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IStudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(IStudentService studentService) {
		this.studentService = studentService;
	}
	
	public String login()
	{
		List list=studentService.login(studentid, password);
		if(list!=null)
		{
			Student student=(Student) list.get(0);
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			session.setAttribute("student", student);
			session.setAttribute("studentname", student.getName());
			session.setAttribute("studentsubject", student.getSubject().getSubjectid());
			session.setAttribute("studentclazz", student.getClazz().getName());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String logout()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("student")!=null)
		{
			session.removeAttribute("student");
		}
		return SUCCESS;
	}
	
	public String listPlan()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("studentsubject");
		List<Plan> plans=studentService.listPlan(subjectid);
		if(plans!=null)
		{
			
			session.setAttribute("plans", plans);
			//System.out.println(plans.get(0).getSubject());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listPlanDetail()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		List<Detail> plandetails=studentService.listPlanDetail(planid);
		if(plandetails!=null)
		{
//			System.out.println(plandetails.size());
//			System.out.println(plandetails.get(0).getKecheng().getName());
			session.setAttribute("plandetails", plandetails);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listAllCompulsory()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("studentsubject");
		List<Kecheng> compulsory=studentService.listAllCompulsory(subjectid, term);	
		if(compulsory!=null)
		{
//			System.out.println(compulsory.size());
//			System.out.println(compulsory.get(0).getName());
			//System.out.println(compulsory.get(0).getSubject().getName());
			session.setAttribute("compulsory", compulsory);
//			System.out.println(compulsory.get(0).getSubject().getName());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listAllElective()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("studentsubject");
		List<Kecheng> elective=studentService.listAllElective(subjectid, term);
		if(elective!=null)
		{
//			System.out.println(compulsory.size());
//			System.out.println(compulsory.get(0).getName());
			
			session.setAttribute("elective", elective);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String listAllPractice()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		int subjectid=(Integer) session.getAttribute("studentsubject");
		List<Kecheng> practice=studentService.listAllPractice(subjectid, term);
		if(practice!=null)
		{
//			System.out.println(practice.size());
//			System.out.println(practice.get(0).getName());
			
			session.setAttribute("practice", practice);
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String getInfo()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Student student=(Student) session.getAttribute("student");
		int studentid=student.getStudentid();
		List<Student> list=studentService.getInfo(studentid);
		if(list!=null)
		{
			Student studentinfo=list.get(0);
//			System.out.println(studentinfo.getName());
			session.setAttribute("student", studentinfo);
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
		Student student1=(Student) session.getAttribute("student");
		int studentid=student1.getStudentid();
		List list=studentService.login(studentid, password);
		if(list==null)
		{
			
		}
		if(list!=null)
		{
			Student student=(Student) list.get(0);
			student.setAge(age);
			student.setName(name);
			student.setPassword(newpassword);
			student.setSex(sex);
			if(studentService.updateInfo(student))
			{

				session.removeAttribute("student");
				List list1=studentService.login(studentid, newpassword);
				Student student2=(Student) list.get(0);
				session.setAttribute("student", student2);
				return SUCCESS;
			}
		}
		return ERROR;
	}
}

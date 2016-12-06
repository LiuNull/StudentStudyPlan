package com.liu.dao;

import java.util.List;

import com.liu.model.Student;

public interface IStudentDAO {
	public List login(int studentid,String password);
	public List listPlan(int subjectid);
	public List listPlanDetail(int planid);
	public List listAllCompulsory(int subjectid,String term);
	public List listAllElective(int subjectid,String term);
	public List listAllPractice(int subjectid,String term);
	public List getInfo(int studentid);
	public boolean updateInfo(Student student);
}	

package com.liu.dao;

import java.util.List;

import com.liu.model.Detail;
import com.liu.model.Kecheng;
import com.liu.model.Manager;
import com.liu.model.Plan;
import com.liu.model.Student;

public interface IManagerDAO {
	public List login(int managerid,String password);
	public List listPlan(int subjectid);
	public List listAllKecheng(int subjectid);
	public List listKechengByTerm(int subjectid,String term);
	public Boolean addKecheng(Kecheng kecheng);
	public List searchKecheng(int kechengid);
	public Boolean updateKecheng(Kecheng kecheng);
	public List getInfo(int managerid);
	public boolean updateInfo(Manager manager);
	public List listAllPractice(int subjectid);
	public List listPracticeByTerm(int subjectid,String term);
	public Boolean addPractice(Kecheng kecheng);
	public List searchPractice(int kechengid);
	public Boolean updatePractice(Kecheng kecheng);
	public List listdetail(int planid);
	public Boolean addPlan(Plan plan);
	public Boolean addDetail(Detail detail);
}

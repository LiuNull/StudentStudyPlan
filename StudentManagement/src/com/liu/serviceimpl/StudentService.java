package com.liu.serviceimpl;

import java.util.List;

import com.liu.dao.IStudentDAO;
import com.liu.model.Student;
import com.liu.service.IStudentService;

public class StudentService implements IStudentService {
	private IStudentDAO studentDAO;
	
	public IStudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(IStudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public List login(int studentid, String password) {
		// TODO Auto-generated method stub
		return studentDAO.login(studentid, password);
	}

	@Override
	public List listPlan(int subjectid) {
		// TODO Auto-generated method stub
		return studentDAO.listPlan(subjectid);
	}

	@Override
	public List listPlanDetail(int planid) {
		// TODO Auto-generated method stub
		return studentDAO.listPlanDetail(planid);
	}

	@Override
	public List listAllCompulsory(int subjectid, String term) {
		// TODO Auto-generated method stub
		return studentDAO.listAllCompulsory(subjectid, term);
	}

	@Override
	public List listAllElective(int subjectid, String term) {
		// TODO Auto-generated method stub
		return studentDAO.listAllElective(subjectid, term);
	}

	@Override
	public List listAllPractice(int subjectid, String term) {
		// TODO Auto-generated method stub
		return studentDAO.listAllPractice(subjectid, term);
	}

	@Override
	public List getInfo(int studentid) {
		// TODO Auto-generated method stub
		return studentDAO.getInfo(studentid);
	}

	@Override
	public boolean updateInfo(Student student) {
		// TODO Auto-generated method stub
		return studentDAO.updateInfo(student);
	}

}

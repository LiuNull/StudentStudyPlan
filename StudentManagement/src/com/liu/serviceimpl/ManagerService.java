package com.liu.serviceimpl;

import java.util.List;

import com.liu.dao.IManagerDAO;
import com.liu.model.Detail;
import com.liu.model.Kecheng;
import com.liu.model.Manager;
import com.liu.model.Plan;
import com.liu.service.IManagerService;

public class ManagerService implements IManagerService {
	private IManagerDAO managerDAO;
	
	public IManagerDAO getManagerDAO() {
		return managerDAO;
	}

	public void setManagerDAO(IManagerDAO managerDAO) {
		this.managerDAO = managerDAO;
	}

	@Override
	public List login(int managerid, String password) {
		// TODO Auto-generated method stub
		return managerDAO.login(managerid, password);
	}

	@Override
	public List listPlan(int subjectid) {
		// TODO Auto-generated method stub
		return managerDAO.listPlan(subjectid);
	}

	@Override
	public List listAllKecheng(int subjectid) {
		// TODO Auto-generated method stub
		return managerDAO.listAllKecheng(subjectid);
	}

	@Override
	public List listKechengByTerm(int subjectid, String term) {
		// TODO Auto-generated method stub
		return managerDAO.listKechengByTerm(subjectid, term);
	}

	@Override
	public Boolean addKecheng(Kecheng kecheng) {
		// TODO Auto-generated method stub
		return managerDAO.addKecheng(kecheng);
	}

	@Override
	public List searchKecheng(int kechengid) {
		// TODO Auto-generated method stub
		return managerDAO.searchKecheng(kechengid);
	}

	@Override
	public Boolean updateKecheng(Kecheng kecheng) {
		// TODO Auto-generated method stub
		return managerDAO.updateKecheng(kecheng);
	}

	@Override
	public List getInfo(int managerid) {
		// TODO Auto-generated method stub
		return managerDAO.getInfo(managerid);
	}

	@Override
	public boolean updateInfo(Manager manager) {
		// TODO Auto-generated method stub
		return managerDAO.updateInfo(manager);
	}

	@Override
	public List listAllPractice(int subjectid) {
		// TODO Auto-generated method stub
		return managerDAO.listAllPractice(subjectid);
	}

	@Override
	public List listPracticeByTerm(int subjectid, String term) {
		// TODO Auto-generated method stub
		return managerDAO.listPracticeByTerm(subjectid, term);
	}

	@Override
	public Boolean addPractice(Kecheng kecheng) {
		// TODO Auto-generated method stub
		return managerDAO.addPractice(kecheng);
	}

	@Override
	public List searchPractice(int kechengid) {
		// TODO Auto-generated method stub
		return managerDAO.searchPractice(kechengid);
	}

	@Override
	public Boolean updatePractice(Kecheng kecheng) {
		// TODO Auto-generated method stub
		return managerDAO.updatePractice(kecheng);
	}

	@Override
	public Boolean addPlan(Plan plan) {
		// TODO Auto-generated method stub
		return managerDAO.addPlan(plan);
	}

	@Override
	public List listdetail(int planid) {
		// TODO Auto-generated method stub
		return managerDAO.listdetail(planid);
	}

	@Override
	public Boolean addDetail(Detail detail) {
		// TODO Auto-generated method stub
		return managerDAO.addDetail(detail);
	}

}

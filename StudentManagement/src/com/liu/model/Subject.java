package com.liu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Subject entity. @author MyEclipse Persistence Tools
 */

public class Subject implements java.io.Serializable {

	// Fields

	private Integer subjectid;
	private String name;
	private Set students = new HashSet(0);
	private Set kechengs = new HashSet(0);
	private Set managers = new HashSet(0);
	private Set plans = new HashSet(0);

	// Constructors

	/** default constructor */
	public Subject() {
	}

	/** minimal constructor */
	public Subject(String name) {
		this.name = name;
	}

	/** full constructor */
	public Subject(String name, Set students, Set kechengs, Set managers,
			Set plans) {
		this.name = name;
		this.students = students;
		this.kechengs = kechengs;
		this.managers = managers;
		this.plans = plans;
	}

	// Property accessors

	public Integer getSubjectid() {
		return this.subjectid;
	}

	public void setSubjectid(Integer subjectid) {
		this.subjectid = subjectid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

	public Set getKechengs() {
		return this.kechengs;
	}

	public void setKechengs(Set kechengs) {
		this.kechengs = kechengs;
	}

	public Set getManagers() {
		return this.managers;
	}

	public void setManagers(Set managers) {
		this.managers = managers;
	}

	public Set getPlans() {
		return this.plans;
	}

	public void setPlans(Set plans) {
		this.plans = plans;
	}

}
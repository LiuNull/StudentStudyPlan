package com.liu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Clazz entity. @author MyEclipse Persistence Tools
 */

public class Clazz implements java.io.Serializable {

	// Fields

	private Integer clazzid;
	private String name;
	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public Clazz() {
	}

	/** minimal constructor */
	public Clazz(String name) {
		this.name = name;
	}

	/** full constructor */
	public Clazz(String name, Set students) {
		this.name = name;
		this.students = students;
	}

	// Property accessors

	public Integer getClazzid() {
		return this.clazzid;
	}

	public void setClazzid(Integer clazzid) {
		this.clazzid = clazzid;
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

}
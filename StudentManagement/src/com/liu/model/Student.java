package com.liu.model;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private Integer studentid;
	private Subject subject;
	private Clazz clazz;
	private String name;
	private String password;
	private Integer age;
	private Integer sex;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Clazz clazz, String name) {
		this.clazz = clazz;
		this.name = name;
	}

	/** full constructor */
	public Student(Subject subject, Clazz clazz, String name, String password,
			Integer age, Integer sex) {
		this.subject = subject;
		this.clazz = clazz;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}

	// Property accessors

	public Integer getStudentid() {
		return this.studentid;
	}

	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

}
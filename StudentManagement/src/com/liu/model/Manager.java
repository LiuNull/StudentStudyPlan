package com.liu.model;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */

public class Manager implements java.io.Serializable {

	// Fields

	private Integer managerid;
	private Subject subject;
	private String name;
	private String password;
	private Integer age;
	private Integer sex;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(Subject subject, String name, String password, Integer age,
			Integer sex) {
		this.subject = subject;
		this.name = name;
		this.password = password;
		this.age = age;
		this.sex = sex;
	}

	// Property accessors

	public Integer getManagerid() {
		return this.managerid;
	}

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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
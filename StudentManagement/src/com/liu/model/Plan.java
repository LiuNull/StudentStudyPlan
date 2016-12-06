package com.liu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan implements java.io.Serializable {

	// Fields

	private Integer planid;
	private Subject subject;
	private String term;
	private Set details = new HashSet(0);

	// Constructors

	/** default constructor */
	public Plan() {
	}

	/** minimal constructor */
	public Plan(Integer planid) {
		this.planid = planid;
	}

	/** full constructor */
	public Plan(Integer planid, Subject subject, String term, Set details) {
		this.planid = planid;
		this.subject = subject;
		this.term = term;
		this.details = details;
	}

	// Property accessors

	public Integer getPlanid() {
		return this.planid;
	}

	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Set getDetails() {
		return this.details;
	}

	public void setDetails(Set details) {
		this.details = details;
	}

}
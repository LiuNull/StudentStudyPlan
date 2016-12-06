package com.liu.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Kecheng entity. @author MyEclipse Persistence Tools
 */

public class Kecheng implements java.io.Serializable {

	// Fields

	private Integer kechengid;
	private Subject subject;
	private String name;
	private Float credit;
	private Integer totaltime;
	private Integer week;
	private String term;
	private Integer iselective;
	private Set details = new HashSet(0);

	// Constructors

	/** default constructor */
	public Kecheng() {
	}

	/** minimal constructor */
	public Kecheng(Integer kechengid, String name) {
		this.kechengid = kechengid;
		this.name = name;
	}

	/** full constructor */
	public Kecheng(Integer kechengid, Subject subject, String name,
			Float credit, Integer totaltime, Integer week, String term,
			Integer iselective, Set details) {
		this.kechengid = kechengid;
		this.subject = subject;
		this.name = name;
		this.credit = credit;
		this.totaltime = totaltime;
		this.week = week;
		this.term = term;
		this.iselective = iselective;
		this.details = details;
	}

	// Property accessors

	public Integer getKechengid() {
		return this.kechengid;
	}

	public void setKechengid(Integer kechengid) {
		this.kechengid = kechengid;
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

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Integer getTotaltime() {
		return this.totaltime;
	}

	public void setTotaltime(Integer totaltime) {
		this.totaltime = totaltime;
	}

	public Integer getWeek() {
		return this.week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public String getTerm() {
		return this.term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Integer getIselective() {
		return this.iselective;
	}

	public void setIselective(Integer iselective) {
		this.iselective = iselective;
	}

	public Set getDetails() {
		return this.details;
	}

	public void setDetails(Set details) {
		this.details = details;
	}

}
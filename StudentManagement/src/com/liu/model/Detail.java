package com.liu.model;

/**
 * Detail entity. @author MyEclipse Persistence Tools
 */

public class Detail implements java.io.Serializable {

	// Fields

	private Integer detailid;
	private Kecheng kecheng;
	private Plan plan;

	// Constructors

	/** default constructor */
	public Detail() {
	}

	/** full constructor */
	public Detail(Kecheng kecheng, Plan plan) {
		this.kecheng = kecheng;
		this.plan = plan;
	}

	// Property accessors

	public Integer getDetailid() {
		return this.detailid;
	}

	public void setDetailid(Integer detailid) {
		this.detailid = detailid;
	}

	public Kecheng getKecheng() {
		return this.kecheng;
	}

	public void setKecheng(Kecheng kecheng) {
		this.kecheng = kecheng;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}
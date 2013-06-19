package com.ycx.model;

/**
 * IndiWarn entity. @author MyEclipse Persistence Tools
 */

public class IndiWarn implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer indiId;
	private Integer warnId;
	private Integer workMatch;

	// Constructors

	/** default constructor */
	public IndiWarn() {
	}

	/** full constructor */
	public IndiWarn(Integer indiId, Integer warnId, Integer workMatch) {
		this.indiId = indiId;
		this.warnId = warnId;
		this.workMatch = workMatch;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIndiId() {
		return this.indiId;
	}

	public void setIndiId(Integer indiId) {
		this.indiId = indiId;
	}

	public Integer getWarnId() {
		return this.warnId;
	}

	public void setWarnId(Integer warnId) {
		this.warnId = warnId;
	}

	public Integer getWorkMatch() {
		return this.workMatch;
	}

	public void setWorkMatch(Integer workMatch) {
		this.workMatch = workMatch;
	}

}
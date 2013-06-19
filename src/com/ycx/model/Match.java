package com.ycx.model;

/**
 * Match entity. @author MyEclipse Persistence Tools
 */

public class Match implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer workMatch;

	// Constructors

	/** default constructor */
	public Match() {
	}

	/** full constructor */
	public Match(Integer workMatch) {
		this.workMatch = workMatch;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWorkMatch() {
		return this.workMatch;
	}

	public void setWorkMatch(Integer workMatch) {
		this.workMatch = workMatch;
	}

}
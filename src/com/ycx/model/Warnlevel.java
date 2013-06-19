package com.ycx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Warnlevel entity. @author MyEclipse Persistence Tools
 */

public class Warnlevel implements java.io.Serializable {

	// Fields

	private Integer id;
	private String level;
	private Integer count;
	private Set warncontents = new HashSet(0);

	// Constructors

	/** default constructor */
	public Warnlevel() {
	}

	/** minimal constructor */
	public Warnlevel(String level) {
		this.level = level;
	}

	/** full constructor */
	public Warnlevel(String level, Integer count, Set warncontents) {
		this.level = level;
		this.count = count;
		this.warncontents = warncontents;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set getWarncontents() {
		return this.warncontents;
	}

	public void setWarncontents(Set warncontents) {
		this.warncontents = warncontents;
	}

}
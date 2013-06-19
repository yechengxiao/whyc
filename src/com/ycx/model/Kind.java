package com.ycx.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Kind entity. @author MyEclipse Persistence Tools
 */

public class Kind implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Set indicators = new HashSet(0);

	// Constructors

	/** default constructor */
	public Kind() {
	}

	/** minimal constructor */
	public Kind(String name) {
		this.name = name;
	}

	/** full constructor */
	public Kind(String name, Set indicators) {
		this.name = name;
		this.indicators = indicators;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getIndicators() {
		return this.indicators;
	}

	public void setIndicators(Set indicators) {
		this.indicators = indicators;
	}

}
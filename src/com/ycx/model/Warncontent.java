package com.ycx.model;

/**
 * Warncontent entity. @author MyEclipse Persistence Tools
 */

public class Warncontent implements java.io.Serializable {

	// Fields

	private Integer id;
	private Warnlevel warnlevel;
	private String content;

	// Constructors

	/** default constructor */
	public Warncontent() {
	}

	/** full constructor */
	public Warncontent(Warnlevel warnlevel, String content) {
		this.warnlevel = warnlevel;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Warnlevel getWarnlevel() {
		return this.warnlevel;
	}

	public void setWarnlevel(Warnlevel warnlevel) {
		this.warnlevel = warnlevel;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
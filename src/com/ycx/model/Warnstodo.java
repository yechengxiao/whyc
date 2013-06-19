package com.ycx.model;

/**
 * Warnstodo entity. @author MyEclipse Persistence Tools
 */

public class Warnstodo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Warntodo warntodo;
	private String name;
	private String content;

	// Constructors

	/** default constructor */
	public Warnstodo() {
	}

	/** full constructor */
	public Warnstodo(Warntodo warntodo, String name, String content) {
		this.warntodo = warntodo;
		this.name = name;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Warntodo getWarntodo() {
		return this.warntodo;
	}

	public void setWarntodo(Warntodo warntodo) {
		this.warntodo = warntodo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
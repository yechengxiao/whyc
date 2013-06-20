package com.ycx.work.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Work entity. @author MyEclipse Persistence Tools
 */

public class Work implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String method;
	private String kind;
	private String content;
	private String note;
	private Integer state;
	private Date doDate;
	private Integer frequency;
	private Integer workMatch;
	private Set warntodos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Work() {
	}

	/** minimal constructor */
	public Work(String name, String method, String kind, String content,
			String note, Integer state, Date doDate, Integer frequency,
			Integer workMatch) {
		this.name = name;
		this.method = method;
		this.kind = kind;
		this.content = content;
		this.note = note;
		this.state = state;
		this.doDate = doDate;
		this.frequency = frequency;
		this.workMatch = workMatch;
	}

	/** full constructor */
	public Work(String name, String method, String kind, String content,
			String note, Integer state, Date doDate, Integer frequency,
			Integer workMatch, Set warntodos) {
		this.name = name;
		this.method = method;
		this.kind = kind;
		this.content = content;
		this.note = note;
		this.state = state;
		this.doDate = doDate;
		this.frequency = frequency;
		this.workMatch = workMatch;
		this.warntodos = warntodos;
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

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getDoDate() {
		return this.doDate;
	}

	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}

	public Integer getFrequency() {
		return this.frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getWorkMatch() {
		return this.workMatch;
	}

	public void setWorkMatch(Integer workMatch) {
		this.workMatch = workMatch;
	}

	public Set getWarntodos() {
		return this.warntodos;
	}

	public void setWarntodos(Set warntodos) {
		this.warntodos = warntodos;
	}

}
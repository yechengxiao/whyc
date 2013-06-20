package com.ycx.warntodo.entity;

import java.util.HashSet;
import java.util.Set;

import com.ycx.work.entity.Work;

/**
 * Warntodo entity. @author MyEclipse Persistence Tools
 */

public class Warntodo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Work work;
	private String name;
	private String kind;
	private String content;
	private String warn;
	private Integer state;
	private Set warnstodos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Warntodo() {
	}

	/** minimal constructor */
	public Warntodo(Work work, String name, String kind, String warn,
			Integer state) {
		this.work = work;
		this.name = name;
		this.kind = kind;
		this.warn = warn;
		this.state = state;
	}

	/** full constructor */
	public Warntodo(Work work, String name, String kind, String content,
			String warn, Integer state, Set warnstodos) {
		this.work = work;
		this.name = name;
		this.kind = kind;
		this.content = content;
		this.warn = warn;
		this.state = state;
		this.warnstodos = warnstodos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Work getWork() {
		return this.work;
	}

	public void setWork(Work work) {
		this.work = work;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getWarn() {
		return this.warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Set getWarnstodos() {
		return this.warnstodos;
	}

	public void setWarnstodos(Set warnstodos) {
		this.warnstodos = warnstodos;
	}

}
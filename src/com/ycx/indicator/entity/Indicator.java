package com.ycx.indicator.entity;

import java.util.Date;

import com.ycx.model.Kind;

/**
 * Indicator entity. @author MyEclipse Persistence Tools
 */

public class Indicator implements java.io.Serializable {

	// Fields

	private Integer id;
	private Kind kind;
	private String name;
	private String method;
	private Date addTime;
	private Date endTime;
	private String content;
	private String note;
	private Integer state;

	// Constructors

	/** default constructor */
	public Indicator() {
	}

	/** minimal constructor */
	public Indicator(Kind kind, String name, String method, Date addTime,
			Date endTime, String content, Integer state) {
		this.kind = kind;
		this.name = name;
		this.method = method;
		this.addTime = addTime;
		this.endTime = endTime;
		this.content = content;
		this.state = state;
	}

	/** full constructor */
	public Indicator(Kind kind, String name, String method, Date addTime,
			Date endTime, String content, String note, Integer state) {
		this.kind = kind;
		this.name = name;
		this.method = method;
		this.addTime = addTime;
		this.endTime = endTime;
		this.content = content;
		this.note = note;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Kind getKind() {
		return this.kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
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

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

}
package com.ycx.business;

import java.io.Serializable;

public class WorkBean implements Serializable {
	private int id;
	private String name;
	private String method;
	private String kind;
	private String content;
	private String note;
	private Integer frequency;
	private Integer workMatch;

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public Integer getWorkMatch() {
		return workMatch;
	}

	public void setWorkMatch(Integer workMatch) {
		this.workMatch = workMatch;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


}

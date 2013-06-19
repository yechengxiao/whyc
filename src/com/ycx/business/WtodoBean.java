package com.ycx.business;

import java.io.Serializable;

public class WtodoBean implements Serializable {
	private int id;
	private int workid;
	private String name;
	private String kind;
	private String warn;

	public int getWorkid() {
		return workid;
	}

	public void setWorkid(int workid) {
		this.workid = workid;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getWarn() {
		return warn;
	}

	public void setWarn(String warn) {
		this.warn = warn;
	}

}

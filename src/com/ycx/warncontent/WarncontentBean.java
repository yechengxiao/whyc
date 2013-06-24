package com.ycx.warncontent;

import java.io.Serializable;

public class WarncontentBean implements Serializable {
	private int id;
	private String content;
	private String warnlevel;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setContent(String c) {
		this.content = c;
	}

	public String getContent() {
		return content;
	}

	public String getWarnlevel() {
		return warnlevel;
	}

	public void setWarnlevel(String warnlevel) {
		this.warnlevel = warnlevel;
	}

}

package com.ycx.warncontent;

import java.io.Serializable;

public class WarncontentBean implements Serializable {
	private int id;
	private String content;
	private String level;

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

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}
}

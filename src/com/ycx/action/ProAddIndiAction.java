package com.ycx.action;

import com.ycx.action.base.BaseAction;

//新增监测指标
public class ProAddIndiAction extends BaseAction {
	private String name;
	private String method;
	private String content;
	private String note;
	private int kind;
	private int period;

	public String execute() throws Exception {
		switch (period) {
		case 2:
			period = 7;
			break;
		case 3:
			period = 15;
			break;
		case 4:
			period = 30;
			break;
		}
		oneService.addIndi(name, method, period, content, note, kind);
		addActionMessage("新增成功！！");
		return SUCCESS;
	}

	public void setName(String n) {
		this.name = n;
	}

	public String getName() {
		return name;
	}

	public void setMethod(String m) {
		this.method = m;
	}

	public String getMethod() {
		return method;
	}

	public void setContent(String c) {
		this.content = c;
	}

	public String getContent() {
		return content;
	}

	public void setNote(String n) {
		this.note = n;
	}

	public String getNote() {
		return note;
	}

	public void setKind(int k) {
		this.kind = k;
	}

	public int getKind() {
		return kind;
	}

	public void setAvail(int a) {
		this.period = a;
	}

	public int getAvail() {
		return period;
	}
}

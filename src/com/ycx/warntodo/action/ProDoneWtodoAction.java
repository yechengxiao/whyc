package com.ycx.warntodo.action;

import com.ycx.action.base.BaseAction;

//处理预警
public class ProDoneWtodoAction extends BaseAction {
	private int id;
	private String content;

	public String execute() throws Exception {
		wtdService.doneWtodo(id, content);
		addActionMessage("预警已消除");
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

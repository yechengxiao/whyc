package com.ycx.action;

import com.ycx.action.base.BaseActionInterface;

public class ViewAvailWstodosAction extends BaseActionInterface {
	private String errorMsg;

	public String execute() throws Exception {
		setErrorMsg("建设中...");
		return SUCCESS;
	}

	public void setErrorMsg(String msg) {
		this.errorMsg = msg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}

package com.ycx.warntodo.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class ViewAvailWtodosAction extends BaseActionInterface {
	private List wtodos;

	public String execute() throws Exception {
		setWtodos(wtdService.getAvailWtodos());
		return SUCCESS;
	}

	public void setWtodos(List w) {
		this.wtodos = w;
	}

	public List getWtodos() {
		return wtodos;
	}
}

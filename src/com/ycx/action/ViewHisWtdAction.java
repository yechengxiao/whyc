package com.ycx.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class ViewHisWtdAction extends BaseActionInterface {
	private int id;
	private List wtodos;

	public String execute() throws Exception {
		setWtodos(oneService.getDoneWtodos());
		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getWtodos() {
		return wtodos;
	}

	public void setWtodos(List wtodos) {
		this.wtodos = wtodos;
	}

}

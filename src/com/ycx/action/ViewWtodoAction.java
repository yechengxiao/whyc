package com.ycx.action;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.business.WtodoBean;

public class ViewWtodoAction extends BaseActionInterface {
	private int id;
	private WtodoBean wtdb;

	public String execute() throws Exception {
		setWtdb(oneService.getWtodo(id));

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WtodoBean getWtdb() {
		return wtdb;
	}

	public void setWtdb(WtodoBean wtdb) {
		this.wtdb = wtdb;
	}

}

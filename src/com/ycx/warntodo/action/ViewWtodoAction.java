package com.ycx.warntodo.action;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.warntodo.WtodoBean;

public class ViewWtodoAction extends BaseActionInterface {
	private int id;
	private WtodoBean wtdb;

	public String execute() throws Exception {
		setWtdb(wtdService.getWtodo(id));

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

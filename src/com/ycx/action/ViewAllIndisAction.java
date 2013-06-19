package com.ycx.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class ViewAllIndisAction extends BaseActionInterface {
	private List ibs;

	public String execute() throws Exception {
		setibs(oneService.getAllIndicators());
		return SUCCESS;
	}

	public List getibs() {
		return ibs;
	}

	public void setibs(List ibs) {
		this.ibs = ibs;
	}

}

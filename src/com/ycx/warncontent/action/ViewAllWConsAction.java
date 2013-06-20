package com.ycx.warncontent.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class ViewAllWConsAction extends BaseActionInterface {
	private List wcbs;

	public String execute() throws Exception {
		setWcbs(wcService.getAllWarncontents());
		System.out.println("----------------ViewAllWConsAction " + wcbs.size());
		return SUCCESS;
	}

	public void setWcbs(List w) {
		this.wcbs = w;
	}

	public List getWcbs() {
		return wcbs;
	}
}

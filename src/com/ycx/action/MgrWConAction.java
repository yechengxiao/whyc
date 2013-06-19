package com.ycx.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

//预处理_去预警指标
public class MgrWConAction extends BaseActionInterface {
	private List wls;

	public String execute() throws Exception {
		setWls(oneService.getAllWarnlevels());
		return SUCCESS;
	}

	public void setWls(List wls) {
		this.wls = wls;
	}

	public List getWls() {
		return wls;
	}
}

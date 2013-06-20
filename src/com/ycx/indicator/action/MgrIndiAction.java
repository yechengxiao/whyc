package com.ycx.indicator.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

//预处理_取类别
public class MgrIndiAction extends BaseActionInterface {
	private List kinds;

	public String execute() throws Exception {

		setKinds(indiService.getAllKinds());
		return SUCCESS;
	}

	public List getKinds() {
		return kinds;
	}

	public void setKinds(List k) {
		this.kinds = k;
	}

}

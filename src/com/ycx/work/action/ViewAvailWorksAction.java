package com.ycx.work.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class ViewAvailWorksAction extends BaseActionInterface {
	private List works;
	private String errorMsg;

	public String execute() throws Exception {
		works = wService.getAvailWorks();

		if (works != null) {
			setWorks(works);
			return SUCCESS;
		} else {
			setErrorMsg("ViewAvailWorksAction error");
			return ERROR;
		}
	}

	public void setWorks(List w) {
		this.works = w;
	}

	public List getWorks() {
		return works;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}

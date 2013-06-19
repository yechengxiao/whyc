package com.ycx.action.base;

import com.opensymphony.xwork2.Action;
import com.ycx.service.OneService;

public class BaseActionInterface implements Action {

	protected OneService oneService;

	public void setOneService(OneService one) {
		this.oneService = one;
	}

	public String execute() throws Exception {
		return null;
	}

}

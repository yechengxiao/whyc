package com.ycx.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.ycx.service.OneService;

public class BaseAction extends ActionSupport {
	protected OneService oneService;

	public void setOneService(OneService one) {
		this.oneService = one;
	}
}

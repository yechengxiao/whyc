package com.ycx.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.ycx.service.OneService;

public class RegALogBaseAction extends ActionSupport {
	protected OneService oneService;

	public void setOneService(OneService o) {
		this.oneService = o;
	}

}

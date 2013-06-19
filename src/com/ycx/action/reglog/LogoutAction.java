package com.ycx.action.reglog;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ycx.action.base.BaseActionInterface;

public class LogoutAction extends BaseActionInterface {
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		session.put("userId", null);

		return SUCCESS;
	}
}

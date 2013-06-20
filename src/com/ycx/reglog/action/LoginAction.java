package com.ycx.reglog.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ycx.action.base.RegALogBaseAction;

public class LoginAction extends RegALogBaseAction {
	private String name;
	private String pass;
	private String vercode;

	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String) session.get("rand");
		session.put("rand", null);

		// if (vercode.equalsIgnoreCase(ver2)) {
		int userId = userService.loginValidate(name, pass);
		if (userId >= 1) {
			session.put("userId", userId);
			return SUCCESS;
		}
		addActionError("密码错误。");
		// } else {
		addActionError("验证码错误。");
		// }
		return "login";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

}

package com.ycx.reglog.action;

import com.ycx.action.base.BaseActionInterface;

public class ValidateNameAction extends BaseActionInterface {
	private String name;
	private String tip;

	public String execute() throws Exception {

		if (userService.validateName(name)) {
			setTip("用户名" + name + " 可以使用。");
		} else {
			setTip("用户名" + name + "已被使用。");
		}
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String user) {
		this.name = user;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

}

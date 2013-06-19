package com.ycx.action.reglog;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.ycx.action.base.RegALogBaseAction;

public class RegistAction extends RegALogBaseAction {
	private String name;
	private String pass;
	private String pass2;
	private int level;
	private String email;
	private String vercode;

	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String) session.get("rand");
		session.put("rand", null);

		if (vercode.equalsIgnoreCase(ver2)) {
			if (pass.equals(pass2)) {
				oneService.addUser(name, pass, email, level);
				addActionMessage("注册成功。");
				return SUCCESS;
			} else {
			}
			addActionError("两次密码不一致。");
		} else {
			addActionError("验证码错误。");
		}
		return "failure";
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

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

}

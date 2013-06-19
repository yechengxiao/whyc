package com.ycx.action;

import java.util.Map;

import com.ycx.action.base.BaseActionInterface;

public class HomepageAction extends BaseActionInterface {
	private Map map;

	public String execute() throws Exception {
		setMap(oneService.getWLevCount());
		return SUCCESS;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

}

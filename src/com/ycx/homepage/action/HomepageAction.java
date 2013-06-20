package com.ycx.homepage.action;

import java.util.Map;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.homepage.service.HomepageService;

public class HomepageAction extends BaseActionInterface {
	private Map map;
	private HomepageService hpService;

	public String execute() throws Exception {
		setMap(hpService.getWLevCount());
		return SUCCESS;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public void setHpService(HomepageService hpService) {
		this.hpService = hpService;
	}

}

package com.ycx.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.ycx.indicator.service.IndicatorService;
import com.ycx.reglog.service.UserService;
import com.ycx.warncontent.service.WarncontentService;
import com.ycx.warnlevel.service.WarnlevelService;
import com.ycx.warntodo.service.WarntodoService;
import com.ycx.work.service.WorkService;

public class BaseAction extends ActionSupport {

	protected IndicatorService indiService;
	protected WarncontentService wcService;
	protected WorkService workService;
	protected WarntodoService wtdService;
	protected WarnlevelService wlService;
	protected UserService userService;

	public void setIndiService(IndicatorService indiService) {
		this.indiService = indiService;
	}

	public void setWcService(WarncontentService wcService) {
		this.wcService = wcService;
	}

	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}

	public void setWtdService(WarntodoService wtdService) {
		this.wtdService = wtdService;
	}

	public void setWlService(WarnlevelService wlService) {
		this.wlService = wlService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

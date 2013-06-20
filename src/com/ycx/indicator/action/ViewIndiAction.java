package com.ycx.indicator.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.indicator.IndicatorBean;
import com.ycx.warncontent.WarncontentBean;
import com.ycx.warncontent.service.WarncontentService;

public class ViewIndiAction extends BaseActionInterface {
	private int ibId;
	private IndicatorBean ib;
	private List wcbs;
	private WarncontentService wcService;

	public String execute() throws Exception {
		setIb(indiService.getIndicator(ibId));
		setWcbs(wcService.getAllWarncontents());

		for (int i = 0; i < wcbs.size(); i++) {
			System.out.println("ViewIndiAction-->warncontentBeans:"
					+ ((WarncontentBean) wcbs.get(i)).getId());
		}
		return SUCCESS;
	}

	public int getIbId() {
		return ibId;
	}

	public void setIbId(int ibId) {
		this.ibId = ibId;
	}

	public IndicatorBean getIb() {
		return ib;
	}

	public void setIb(IndicatorBean ib) {
		this.ib = ib;
	}

	public List getWcbs() {
		return wcbs;
	}

	public void setWcbs(List wcbs) {
		this.wcbs = wcbs;
	}

	public void setWcService(WarncontentService wcService) {
		this.wcService = wcService;
	}

}

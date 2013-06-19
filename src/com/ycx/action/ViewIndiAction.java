package com.ycx.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.business.IndicatorBean;
import com.ycx.business.WarncontentBean;

public class ViewIndiAction extends BaseActionInterface {
	private int ibId;
	private IndicatorBean ib;
	private List wcbs;

	public String execute() throws Exception {
		setIb(oneService.getIndicator(ibId));
		setWcbs(oneService.getAllWarncontents());
		
		for (int i = 0; i < wcbs.size(); i++) {
			System.out.println("ViewIndiAction-->warncontentBeans:"
					+ ((WarncontentBean) wcbs.get(i)).getId());
		}
		return SUCCESS;
	}

	public int getIbId() {
		return ibId;
	}

	public void setibId(int ibId) {
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
}

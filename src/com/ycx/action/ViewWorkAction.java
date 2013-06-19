package com.ycx.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;
import com.ycx.business.WorkBean;

public class ViewWorkAction extends BaseActionInterface {
	private int id;
	private WorkBean work;
	private List wcbs;
	// error message
	private String errorMsg;

	public String execute() throws Exception {
		int workMatch = oneService.getWork(id).getWorkMatch();
		List indiWarns = oneService.getIndiWarn(workMatch);

		if (indiWarns.size() == 0) {
			setErrorMsg("ViewWorkAction indiWarns.size=0");
			return ERROR;
		}

		for (int i = 0; i < indiWarns.size(); i++) {
			wcbs = oneService.getWConsByMatch(workMatch);
		}
		System.out.println("--------ViewWorkAction wcbs: " + wcbs.size() + "--------");

		setWcbs(wcbs);
		setWork(oneService.getWork(id));

		return SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WorkBean getWork() {
		return work;
	}

	public void setWork(WorkBean work) {
		this.work = work;
	}

	public List getWcbs() {
		return wcbs;
	}

	public void setWcbs(List wcbs) {
		this.wcbs = wcbs;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}

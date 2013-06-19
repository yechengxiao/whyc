package com.ycx.action;

import com.ycx.action.base.BaseActionInterface;

public class PubWorkAction extends BaseActionInterface {
	private int ibId;
	private Integer[] wcIds;
	private String errorMsg;
	private String succMsg;

	public String execute() throws Exception {

		if (wcIds.length == 0) {
			setErrorMsg("请选择预警内容。");
			return ERROR;
		}

		System.out.println("------->PubWorkAction ibId:" + ibId + "-----");
		for (Integer id : wcIds) {
			System.out.println("------->PubWorkAction id:" + id + "-----");
		}
		oneService.pubWork(ibId, wcIds);
		setSuccMsg("发布成功！！");
		return SUCCESS;
	}

	public int getIbId() {
		return ibId;
	}

	public void setIbId(int ibId) {
		this.ibId = ibId;
	}

	public Integer[] getWcIds() {
		return wcIds;
	}

	public void setWcIds(Integer[] wcIds) {
		this.wcIds = wcIds;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getSuccMsg() {
		return succMsg;
	}

	public void setSuccMsg(String succMsg) {
		this.succMsg = succMsg;
	}

}

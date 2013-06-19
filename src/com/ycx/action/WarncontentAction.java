package com.ycx.action;

import com.ycx.action.base.BaseActionInterface;

public class WarncontentAction extends BaseActionInterface {
	private String rowFlag;// 传入的多选框id，形如 1|2|
	private String succMsg;
	
	public String deleteWCon() throws Exception {
		try {
			System.out.println("!!!!!!deleteWCon!!!!!!");
			oneService.deleteWCon(rowFlag);
			setSuccMsg("删除成功！！");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String getRowFlag() {
		return rowFlag;
	}

	public void setRowFlag(String rowFlag) {
		this.rowFlag = rowFlag;
	}

	public String getSuccMsg() {
		return succMsg;
	}

	public void setSuccMsg(String succMsg) {
		this.succMsg = succMsg;
	}
}

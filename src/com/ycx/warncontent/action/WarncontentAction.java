package com.ycx.warncontent.action;

import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class WarncontentAction extends BaseActionInterface {
	private String succMsg;
	private String rowFlag;// 传入的多选框id，形如 1|2|
	private String searchContent;
	private List wcbs;

	public String deleteWCon() throws Exception {
		try {
			System.out.println("!!!!!!deleteWCon!!!!!!");
			wcService.deleteWCon(rowFlag);
			setSuccMsg("删除成功！！");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String searchWcon() throws Exception {
		try {
			setWcbs(wcService.search(searchContent));

			System.out.println(wcbs.size());

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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

	public String getSearchContent() {
		return searchContent;
	}

	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}

	public List getWcbs() {
		return wcbs;
	}

	public void setWcbs(List wcbs) {
		this.wcbs = wcbs;
	}

}

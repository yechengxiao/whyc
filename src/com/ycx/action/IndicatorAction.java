package com.ycx.action;

//删除、修改、查询
import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class IndicatorAction extends BaseActionInterface {
	private String rowFlag;// 传入的多选框id，形如 1|2|
	private String succMsg;
	// 搜索
	private String searchStr;
	private List ibs;// IndicatorBean;

	public String deleteIndi() throws Exception {
		try {
			oneService.deleteIndi(rowFlag);
			setSuccMsg("删除成功！！");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public String searchIndi() throws Exception {
		try {
			setIbs(oneService.searchIndi(searchStr));
			
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// setter\getter
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

	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public List getIbs() {
		return ibs;
	}

	public void setIbs(List ibs) {
		this.ibs = ibs;
	}

}

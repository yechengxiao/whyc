package com.ycx.indicator.action;

//删除、修改、查询
import java.util.List;

import com.ycx.action.base.BaseActionInterface;

public class IndicatorAction extends BaseActionInterface {
	private String rowFlag;// 传入的多选框id，形如 1|2|
	private String succMsg;
	private String searchName; // 搜索
	private List ibs;// 删除后，显示的IndicatorBean。

	// 删除
	public String deleteIndi() throws Exception {
		try {
			indiService.deleteIndi(rowFlag);
			setSuccMsg("删除成功！！");
			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// 查询
	public String searchIndi() throws Exception {
		try {
			setIbs(indiService.searchIndi(searchName));

			return SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// setter/getter
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

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public List getIbs() {
		return ibs;
	}

	public void setIbs(List ibs) {
		this.ibs = ibs;
	}
}

package com.ycx.warncontent.action;

import com.ycx.action.base.BaseAction;

public class ProAddWConAction extends BaseAction {
	private String content;
	private int levelId;

	public String execute() throws Exception {
		System.out.println("------------ProAddWConAction " + content);
		if (levelId == 0) {
			addActionError("请选择预警等级");
			return ERROR;
		}
		wcService.addWarncontent(content, levelId);
		addActionMessage("新增成功！！");
		return SUCCESS;
	}

	public void setContent(String c) {
		this.content = c;
	}

	public String getContent() {
		return content;
	}

	public void setLevelId(int id) {
		this.levelId = id;
	}

	public int getLevelId() {
		return levelId;
	}
}

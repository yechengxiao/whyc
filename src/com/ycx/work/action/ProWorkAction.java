package com.ycx.work.action;

import com.ycx.action.base.BaseActionInterface;

public class ProWorkAction extends BaseActionInterface {

	private int id;// 监测指标id
	private String wcIds;// 前台传入，形如1|2|

	private String msg;

	public String updateWork() throws Exception {
		if (id == 0) {
			setMsg("ProWorkAction-->监测指标id怎么会是0");
		} else {
			workService.updateWork(id);
			setMsg("任务将在到期时显示。");
			return "update";
		}
		return ERROR;
	}

	public String createWarn() throws Exception {
		String[] wc = wcIds.split("\\|");
		int len = wc.length;
		int[] wcids = new int[len];// 传入后台
		for (int i = 0; i < wc.length; i++) {
			wcids[i] = Integer.parseInt(wc[i]);
		}
		if (wcids != null) {
			workService.createWtodo(id, wcids);
			setMsg("预警已生产。");
			return "create";
		} else {
			setMsg("ProWorkAction-->预警指标id没有传入");
		}
		return ERROR;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getWcIds() {
		return wcIds;
	}

	public void setWcIds(String wcIds) {
		this.wcIds = wcIds;
	}

}

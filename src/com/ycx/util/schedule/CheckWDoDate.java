package com.ycx.util.schedule;

import java.util.TimerTask;

import com.ycx.work.service.WorkService;

public class CheckWDoDate extends TimerTask {
	private WorkService workService;

	@Override
	public void run() {
		try {
			workService.updateWorkState();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setWorkService(WorkService wService) {
		this.workService = wService;
	}
}

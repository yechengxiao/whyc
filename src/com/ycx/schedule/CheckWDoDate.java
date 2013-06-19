package com.ycx.schedule;

import java.util.TimerTask;

import com.ycx.service.OneService;

public class CheckWDoDate extends TimerTask {
	private OneService oneService;

	public void setOneService(OneService one) {
		this.oneService = one;
	}

	@Override
	public void run() {
		try {
			oneService.updateWorkState();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

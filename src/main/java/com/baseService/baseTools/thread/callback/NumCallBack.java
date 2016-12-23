package com.baseService.baseTools.thread.callback;

public class NumCallBack implements CallBack {

	private Num num;
	
	@Override
	public void register(Object num) {
		this.num = (Num)num;
	}

	@Override
	public void call() {
		num.add();
	}

}

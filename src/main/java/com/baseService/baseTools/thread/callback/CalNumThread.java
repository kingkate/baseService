package com.baseService.baseTools.thread.callback;

public class CalNumThread extends Thread {

	private CallBack callBack;
	
	public CalNumThread(CallBack callBack) {
		this.callBack = callBack;
	}
	
	@Override
	public void run() {
		callBack.call();
	}
	
	public CallBack getCallBack() {
		return callBack;
	}
	public void setCallBack(CallBack callBack) {
		this.callBack = callBack;
	}

	
}

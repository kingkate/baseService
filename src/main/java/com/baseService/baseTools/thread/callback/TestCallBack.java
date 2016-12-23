package com.baseService.baseTools.thread.callback;

public class TestCallBack {
	
	public static void main(String[] args) {
		Num num = new Num();
		for(int i=0;i<100;i++){
			CallBack callback = new NumCallBack();
			callback.register(num);
			CalNumThread thread = new CalNumThread(callback);
			thread.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(num.getNum());
	}
}

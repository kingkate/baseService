package com.baseService.baseTools.thread.callback;

public class Num {
	
	private int num = 0;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public synchronized int add(){
		return num++;
	}
}

package com.baseService.designmodel.singlton;

public class Sample2 {
	
	private Sample2(){};
	
	public static Sample2 getInstance(){
		return SingltonHolder.singlton;
	}
	
	static class SingltonHolder{
		private final static Sample2 singlton = new Sample2();
	}
	
}

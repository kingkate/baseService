package com.baseService.designmodel.singlton;

public class Sample1 {
	
	private static volatile Sample1 singlton;
	
	private Sample1(){};
	
	public static Sample1 getInstance(){
		if(null == singlton){
			synchronized (Sample1.class) {
				if(null == singlton){
					singlton = new Sample1();
				}
			}
		}
		return singlton;
	}
}

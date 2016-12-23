package com.baseService.designmodel.singlton;

public enum Sample3 {
	SINGLTON;
	
	private Sample3(){};
	
	public static Sample3 getInstance(){
		return Sample3.SINGLTON;
	}
}

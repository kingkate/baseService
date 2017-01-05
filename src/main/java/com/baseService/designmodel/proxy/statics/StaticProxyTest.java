package com.baseService.designmodel.proxy.statics;

import com.baseService.designmodel.proxy.ApproveServiceImpl;

public class StaticProxyTest {

	public static void main(String[] args) {
		
		StaticApproveServiceProxy proxy = new StaticApproveServiceProxy(new ApproveServiceImpl());
		proxy.approve();
		
	}

}

package com.baseService.designmodel.proxy.dynamic;

import com.baseService.designmodel.proxy.ApproveService;
import com.baseService.designmodel.proxy.ApproveServiceImpl;

public class DynamicProxyTest {

	public static void main(String[] args) {
		ApproveService service = new ApproveServiceImpl();
		DynamicApproveServiceProxy proxy = new DynamicApproveServiceProxy();
		ApproveService proxyService = (ApproveService) proxy.getInstance(service);
		proxyService.approve();
	}

}

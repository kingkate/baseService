package com.baseService.designmodel.proxy.dynamic;

import com.baseService.designmodel.proxy.ApproveService;
import com.baseService.designmodel.proxy.ApproveServiceImpl;

public class CglibDynamicProxyTest {
	
	public static void main(String[] args) {
		CglibDynamicProxy proxy = new CglibDynamicProxy();
		ApproveService service = (ApproveService) proxy.createCGLIBProxyInstance(new ApproveServiceImpl());
		service.approve();
	}
}

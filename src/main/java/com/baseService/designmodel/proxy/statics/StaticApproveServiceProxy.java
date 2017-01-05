package com.baseService.designmodel.proxy.statics;

import com.baseService.designmodel.proxy.ApproveService;

public class StaticApproveServiceProxy implements ApproveService {

	private ApproveService service;
	
	public StaticApproveServiceProxy(ApproveService service) {
		this.service = service;
	}
	
	@Override
	public void approve() {
		System.out.println("执行审核操作！");
		service.approve();
		System.out.println("审核操作执行完毕！");
	}

	public ApproveService getService() {
		return service;
	}

	public void setService(ApproveService service) {
		this.service = service;
	}

}

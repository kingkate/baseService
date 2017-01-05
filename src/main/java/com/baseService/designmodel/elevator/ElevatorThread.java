package com.baseService.designmodel.elevator;

public class ElevatorThread implements Runnable {

	private ElevatorService service;
	
	public ElevatorThread(ElevatorService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
//		service.service();
	}

	public ElevatorService getService() {
		return service;
	}

	public void setService(ElevatorService service) {
		this.service = service;
	}
	
	

}

package com.baseService.designmodel.singlton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingltonTest {
	
	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(50);
		Sample1 samp = Sample1.getInstance();
		for(int i=0;i<100;i++){
			service.execute(new Runnable() {
				@Override
				public void run() {
					Sample1 samp1 = Sample1.getInstance();
					System.out.println(samp == samp1);
				}
			});
		}
		service.shutdown();
	}
}

package com.baseService.baseTools.thread.callback;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Provider<E> {
	
	private BlockingQueue<E> blockQueue = new ArrayBlockingQueue<E>(12); 	
	
	public void service(E e){
		try {
			blockQueue.put(e);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}

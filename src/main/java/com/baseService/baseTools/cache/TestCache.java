package com.baseService.baseTools.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCache {
	
	static int i =0;
	
	public static void main(String[] args) {
//		LRUCache<String, String> cache = new LRUCache<String, String>();
//		cache.put("test1", "111");
//		
//		ExecutorService service = Executors.newFixedThreadPool(50);
//		for(i=0;i<50000;i++){
//			cache.put("test"+i, String.valueOf(i));
//		}
//		cache.removeLRUKey();
		LRUCache2<String, String> cache = new LRUCache2<String, String>(100);
		cache.put("test1", "111");
		
		ExecutorService service = Executors.newFixedThreadPool(50);
		for(i=0;i<50000;i++){
			cache.put("test"+i, String.valueOf(i));
		}
		System.out.println(cache.size());
	}
}

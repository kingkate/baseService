package com.baseService.baseTools.cache;

import java.util.concurrent.ConcurrentHashMap;

import com.baseService.baseTools.util.DateUtil;


public class LRUCache<K,V> {
	
	private ConcurrentHashMap<K, Cache<V>> cacheTable;
	
	
	public V get(K k){
		Cache<V> cache = cacheTable.get(k);
		if(null == cache){
			return null;
		}
		cache = new Cache<V>(DateUtil.getCurrentTime(), cache.getTimes()+1, cache.getT());
		cacheTable.put(k, cache);
		return cache.getT();
	}
	
	public V put(K k,V v){
		Cache<V> cache = new Cache<V>(DateUtil.getCurrentTime(), 0, v);
		cache = cacheTable.put(k, cache);
		return cache.getT();
	}
	
	public Cache<V> remove(K k){
		return cacheTable.remove(k);
	}
	
	public void clear(){
		cacheTable.clear();
	}
	
	
}

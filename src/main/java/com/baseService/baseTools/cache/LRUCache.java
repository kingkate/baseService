package com.baseService.baseTools.cache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.baseService.baseTools.util.DateUtil;


public class LRUCache<K,V> {
	
	private Map<K, Cache<V>> cacheTable = new ConcurrentHashMap<K, Cache<V>>();
	
	private final static int MAX_SIZE = Integer.MAX_VALUE;
	
	public V get(K k){
		Cache<V> cache = cacheTable.get(k);
		if(null == cache){
			return null;
		}
		cache = new Cache<V>(DateUtil.getCurrentTime(), cache.getTimes()+1, cache.getT(),k);
		cacheTable.put(k, cache);
		
		return cache.getT();
	}
	
	public V put(K k,V v){
		Cache<V> cache = new Cache<V>(DateUtil.getCurrentTime(), 0, v,k);
		cache = cacheTable.put(k, cache);
		if(null == cache){
			return null;
		}
		return cache.getT();
	}
	
	public Cache<V> remove(K k){
		return cacheTable.remove(k);
	}
	
	public void clear(){
		cacheTable.clear();
	}
	
	public Set<K> keys(){
		return cacheTable.keySet();
	}
	public Collection<Cache<V>> values(){
		return cacheTable.values();
	}
	
	public void removeLRUKey(){
		int size = cacheTable.size();
//		if(size>=MAX_SIZE){
			List<Cache<V>> list = new ArrayList<Cache<V>>(cacheTable.values());
			Collections.sort(list,new CacheCompator());
			Cache<V> cache = list.get(size-1);
			cacheTable.remove(cache.getKey());
//		}
		
	}
}

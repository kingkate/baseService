package com.baseService.baseTools.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用LinkedHashMap 来实现 最近最少使用缓存
 * @author lx
 *
 */
public class LRUCache2<K,V> extends LinkedHashMap<K, V> {
	
	private int MAX_SIZE ;
	private final static float DEFAULT_LOAD_FACTOR = 0.75F;

	public LRUCache2(int capacity) {
		super((int)Math.ceil(capacity/DEFAULT_LOAD_FACTOR)+1, 0.75f, true);
		MAX_SIZE = capacity;
	}
	
	public LRUCache2() {
		MAX_SIZE = Integer.MAX_VALUE;
	}
	
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
		return size() > MAX_SIZE;
	}
	
	
}

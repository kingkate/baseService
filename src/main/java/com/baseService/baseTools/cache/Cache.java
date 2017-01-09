package com.baseService.baseTools.cache;

public class Cache<T> {
	private final long lastUsedTime;//���ʹ��ʱ��
	private final long times;//���ʴ���
	private final T t;
	private final Object key;
	
	public Cache(long lastUsedTime,long times,T t,Object v){
		this.lastUsedTime = lastUsedTime;
		this.times = times;
		this.t = t;
		this.key = v;
	}

	public long getLastUsedTime() {
		return lastUsedTime;
	}

	public long getTimes() {
		return times;
	}

	public T getT() {
		return t;
	}

	public Object getKey() {
		return key;
	}
}

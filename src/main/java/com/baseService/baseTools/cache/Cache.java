package com.baseService.baseTools.cache;

public class Cache<T> {
	private final long lastUsedTime;//���ʹ��ʱ��
	private final long times;//���ʴ���
	private final T t;
	
	public Cache(long lastUsedTime,long times,T t){
		this.lastUsedTime = lastUsedTime;
		this.times = times;
		this.t = t;
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
}

package com.baseService.baseTools.cache;

public class Cache<T> {
	private final long lastUsedTime;//最近使用时间
	private final long times;//访问次数
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

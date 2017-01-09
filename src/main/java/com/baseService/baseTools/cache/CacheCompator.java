package com.baseService.baseTools.cache;

import java.util.Comparator;

public class CacheCompator<V> implements Comparator<Cache<V>> {

	@Override
	public int compare(Cache<V> o1, Cache<V> o2) {
		if(o1.getLastUsedTime()-o2.getLastUsedTime()>0){
			return 1;
		}else if(o1.getLastUsedTime()-o2.getLastUsedTime() == 0){
			if(o1.getTimes() - o2.getTimes() >=0){
				return 1;
			}else {
				return -1;
			}
		}
		return -1;
	}

}

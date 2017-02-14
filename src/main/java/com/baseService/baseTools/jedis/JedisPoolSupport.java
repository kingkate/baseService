package com.baseService.baseTools.jedis;

import redis.clients.jedis.JedisPool;

public class JedisPoolSupport {
	
	private JedisConfig jedisConfig;
	
	private JedisPool jedisPool;
	
	public JedisPoolSupport(JedisConfig jedisConfig){
		this.jedisConfig = jedisConfig;
	}
	
	public  JedisPool getJedisPool(){
		if(null ==jedisConfig){			
			jedisConfig = new JedisConfig();
		}
		jedisPool = new JedisPool(jedisConfig.getJedisPoolConfig(),"192.168.21.128",7000);
		return jedisPool;
	}
	
	public void closePool(){
		if(null!=jedisPool){
			jedisPool.close();
		}
	}
	
	
	public void monitor(){
		//TODO
	}
}

package com.baseService.baseTools.jedis;

import redis.clients.jedis.JedisPoolConfig;

public class JedisConfig implements RedisConfig {

	private JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
	
	@Override
	public void config() {
		doConfig();
	}
	
	private void doConfig(){
		jedisPoolConfig.setMaxIdle(5);
		jedisPoolConfig.setMaxWaitMillis(10001);
		jedisPoolConfig.setTestOnBorrow(false);
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setTestWhileIdle(true);
	}

	/**
	 * 
	 * @return
	 */
	public JedisPoolConfig getJedisPoolConfig() {
		doConfig();
		return jedisPoolConfig;
	}

}

package com.baseService.baseTools;

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

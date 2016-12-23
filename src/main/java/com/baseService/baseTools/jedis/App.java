package com.baseService.baseTools.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.RedisInputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	JedisTools.getInstance();
    	JedisTools.set("test", "data");
    	String dataString = JedisTools.get("test");
    	System.out.println(dataString);
    }
}

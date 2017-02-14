package com.baseService.baseTools.jedis;

import java.awt.List;
import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.util.RedisInputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/******************* Jedis ***************************/
//    	JedisTools.getInstance();
////    	JedisTools.set("test", "data");
//    	String dataString = JedisTools.get("name");
//    	System.out.println(dataString);
    	/*************** Jedis Cluster ***********************/
//    	Set<HostAndPort> nodes = new HashSet<>();
//    	nodes.add(new HostAndPort("192.168.21.128", 7000));
//    	nodes.add(new HostAndPort("192.168.21.128", 7001));
//    	nodes.add(new HostAndPort("192.168.21.128", 7002));
//    	nodes.add(new HostAndPort("192.168.21.129", 7003));
//    	nodes.add(new HostAndPort("192.168.21.129", 7004));
//    	nodes.add(new HostAndPort("192.168.21.129", 7005));
//    	
//    	JedisCluster cluster = new JedisCluster(nodes);
//    	cluster.set("name", "kingkate");
//    	System.out.println(cluster.get("name"));
    	
    	/********************* Jedis Sentinel ****************/
    	Set<String> sentinels = new HashSet<>();
    	sentinels.add("192.168.21.128:16379");
    	sentinels.add("192.168.21.128:16380");
    	sentinels.add("192.168.21.128:16381");
    	sentinels.add("192.168.21.129:16379");
    	JedisSentinelPool pool = new JedisSentinelPool("master1", sentinels,"123");
    	Jedis jedis = pool.getResource();
    	jedis.set("name","234567890");
    	System.out.println(jedis.get("name"));
    }
}

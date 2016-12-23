package com.baseService.baseTools.jedis;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import junit.framework.Assert;
import redis.clients.jedis.Jedis;

public class JedisTools {
	
	private static Jedis jedis = null;
	
	private JedisTools(){};
	
	
	
	public static Jedis getInstance(){
		JedisConfig jedisConfig = new JedisConfig();
    	JedisPoolSupport support = new JedisPoolSupport(jedisConfig);
		jedis = getJedis(support);
		return jedis;
	}
	
	private static Jedis getJedis(JedisPoolSupport support){
		if(null == jedis){
			synchronized (support) {
				if(null == jedis){
					jedis = support.getJedisPool().getResource();
				}
			}
		}
		return jedis;
	}
	
//=================以下为字符串操作方法=======================/
	/**
	 * 设置
	 * @param key
	 * @param value
	 * @return
	 */
	public static String set(String key,String value){
		return jedis.set(key, value);
	}
	
	public static String get(String key){
		return jedis.get(key);
	}
	
	public static String getSet(String key,String value){
		return jedis.getSet(key, value);
	}
	
	public static String getRange(String key,long startOffset,long endOffset){
		return jedis.getrange(key, startOffset, endOffset);
	}
	
	public static List<String> mget(String...keys){
		return jedis.mget(keys);
	}
	
	public static List<String> get(String[] keys){
		return jedis.mget(keys);
	}
	
	public static List<String> get(List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keys){
			keyArray[i] = key;
			i++;
		}
		return jedis.mget(keyArray);
	}
	
	
	public static Long setnx(String key,String value){
		return jedis.setnx(key, value);
	}
	
	public static String mset(String keysvalues){
		return jedis.mset(keysvalues);
	}
	
	public static String mset(Map<String, String> keyValueMap){
		StringBuilder builder = new StringBuilder("");
		for(Entry<String, String> entry : keyValueMap.entrySet()){
			builder.append(entry.getKey());
			builder.append(entry.getValue());
			builder.append(" ");
		}
		return jedis.mset(builder.toString());
	}
	
	public static Long msetnx(String keysvalues){
		return jedis.msetnx(keysvalues);
	}
	
	public static Long msetnx(Map<String, String> keyValueMap){
		StringBuilder builder = new StringBuilder("");
		for(Entry<String, String> entry : keyValueMap.entrySet()){
			builder.append(entry.getKey());
			builder.append(entry.getValue());
			builder.append(" ");
		}
		return jedis.msetnx(builder.toString());
	}
	
	public Long incr(String key){
		return jedis.incr(key);
	}
	
	public Long incrby(String key,long incre){
		return jedis.incrBy(key, incre);
	}
	
	public Long decr(String key){
		return jedis.decr(key);
	}
	
	public Long decrby(String key,long decre){
		return jedis.decrBy(key, decre);
	}
	
	
	
	public String set(byte[] key,byte[] value){
		return jedis.set(key, value);
	}
	
	public String set(byte[] key,byte[] value,byte[] nxxx){
		return jedis.set(key, value, nxxx);
	}
	
	public String set(String key,String value,String nxxx){
		return jedis.set(key, value, nxxx);
	}
	
	public String set(byte[] key,byte[] value,byte[] nxxx,byte[] expx,long time){
		return jedis.set(key, value, nxxx, expx, time);
	}
	
	public String set(byte[] key,byte[] value,byte[] nxxx,byte[] expx,int time){
		return jedis.set(key, value, nxxx, expx, time);
	}
	
	public String set(String key,String value,String nxxx,String expx,int time){
		return jedis.set(key, value, nxxx, expx, time);
	}
	
	public String set(String key,String value,String nxxx,String expx,long time){
		return jedis.set(key, value, nxxx, expx, time);
	}
	
	public String setex(byte[] key,byte[] value,int seconds){
		return jedis.setex(key, seconds, value);
	}
	
	public String setex(String key,String value,int seconds){
		return jedis.setex(key, seconds, value);
	}
	
	
	//=================以下为列表操作方法=======================/
	
	public static Long lpush(String key,String value){
		return jedis.lpush(key, value);
	}
	
	public static Long rpush(String key,String value){
		return jedis.rpush(key, value);
	}
	
	public static Long llen(String key){
		return jedis.llen(key);
	}
	
	public static List<String> lrange(String key,long start,long end){
		return jedis.lrange(key, start, end);
	}
	
	public static String ltrim(String key,long start,long end){
		return jedis.ltrim(key, start, end);
	}
	
	public static String lindex(String key,long index){
		return jedis.lindex(key, index);
	}
	
	public static String lset(String key,Long index,String value){
		return jedis.lset(key, index, value);
	}
	
	/**
	 * 从 List 的头部（count正数）或尾部（count负数）
	 * 删除一定数量（count）匹配value的元素，
	 * 返回删除的元素数量
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 */
	public static long lrem(String key,long count,String value){
		return jedis.lrem(key, count, value);
	}
	
	public static String lpop(String key){
		return jedis.lpop(key);
	}
	
	public static String rpop(String key){
		return jedis.rpop(key);
	}
	
	/**
	 * 弹出 _srckey_ 中最后一个元素并将其压入 _dstkey_头部，
	 * key不存在或序列为空则返回“nil”
	 * @param srckey
	 * @param dstkey
	 * @return
	 */
	public static String rpoplpush(String srckey,String dstkey){
		return jedis.rpoplpush(srckey, dstkey);
	}
	
	//=================以下为集合（无序）操作方法=======================/
	
	public static Long sadd(String key,String... members){
		return jedis.sadd(key, members);
	}
	
	public static Long sadd(String key,List<String> meList){
		Assert.assertNotNull(meList);
		String[] members = new String[meList.size()];
		int i=0;
		for(String member : meList){
			members[i] = member;
			i++;
		}
		return jedis.sadd(key, members);
	}
	
	public static Long srem(String key,String... members){
		return jedis.srem(key, members);
	}
	
	public static Long srem(String key,List<String> meList){
		Assert.assertNotNull(meList);
		String[] members = new String[meList.size()];
		int i=0;
		for(String member : meList){
			members[i] = member;
			i++;
		}
		return jedis.srem(key, members);
	}
	
	public static String spop(String key){
		return jedis.spop(key);
	}
	
	public static Long smove(String srckey,String dstkey,String member){
		return jedis.smove(srckey, dstkey, member);
	}
	
	public static Long scard(String key){
		return jedis.scard(key);
	}
	
	public static Boolean sismember(String key,String member){
		return jedis.sismember(key, member);
	}
	
	public static Set<String> sinter(String... keys){
		return jedis.sinter(keys);
	}
	
	public static Set<String> sinter(List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sinter(keyArray);
	}
	
	public static Long sinterstore(String dstkey,String... keys){
		return jedis.sinterstore(dstkey, keys);
	}
	
	public static Long sinterstore(String dstkey,List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sinterstore(dstkey,keyArray);
	}
	
	public static Set<String> sunion(String... keys){
		return jedis.sunion(keys);
	}
	
	public static Set<String> sunion(List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sunion(keyArray);
	}
	
	public static Long sunionstore(String dstkey,String... keys){
		return jedis.sunionstore(dstkey, keys);
	}
	
	public static Long sunionstore(String dstkey,List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sunionstore(dstkey,keyArray);
	}
	
	public static Set<String> sdiff(String... keys){
		return jedis.sdiff(keys);
	}
	
	public static Set<String> sdiff(List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sdiff(keyArray);
	}
	
	public static Long sdiffstore(String dstkey,List<String> keys){
		Assert.assertNotNull(keys);
		String[] keyArray = new String[keys.size()];
		int i=0;
		for(String key : keyArray){
			keyArray[i] = key;
			i++;
		}
		return jedis.sdiffstore(dstkey,keyArray);
	}
	
	public static Long sdiff(String dstkey,String... keys){
		return jedis.sdiffstore(dstkey, keys);
	}
	
	public static Set<String> smembers(String key){
		return jedis.smembers(key);
	}
	
	public static String srandmember(String key){
		return jedis.srandmember(key);
	}
	
	public static List<String> srandmember(String key,int count){
		return jedis.srandmember(key, count);
	}
	
	
}

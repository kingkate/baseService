package com.baseService.baseTools.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	
	public static String toString(JSONObject jsonObject){
		if(null == jsonObject){
			return null;
		}
		return jsonObject.toString();
	}
	public static String toString(JSONArray jsonArray){
		if(null == jsonArray){
			return null;
		}
		return jsonArray.toString();
	}
	
	@SuppressWarnings("unchecked")
	public static <T>  T toBean(JSONObject object,Class<T> class1){
		if(null == object){
			return null;
		}
		if(null == class1 || class1.isInterface()){
			return (T)JSONObject.toBean(object);
		}
		return (T)JSONObject.toBean(object, class1);
	}
	
	public static <T> List<T> toBeanList(JSONArray array,Class<T> class1){
		if(null == array){
			return null;
		}
		List<T> list = new ArrayList<T>();
		for(int i=0;i<array.size();i++){
			T t = null;
			JSONObject object = array.getJSONObject(i);
			t = toBean(object, class1);
			list.add(t);
		}
		return list;
	}
	
	
	public static <T> Map<String,T> toBeanMap(JSONObject object,Class<T> classv){
		Map<String, T> map = new HashMap<String, T>();
		if(null == object){
			return null;
		}
		for(Object key : object.keySet()){
			if(key instanceof String){
				String keyString = (String) key;
				JSONObject jsonObject = object.getJSONObject(keyString);
				map.put(keyString, toBean(jsonObject, classv));
			}
		}
		return map;
	}
	
	
	
	public static void main(String[] args) {
		
		User user = new User();
		System.out.println(toBean(JSONObject.fromObject(user), User.class).toString());
		List<User> users = new ArrayList<User>();
		for(int i=0;i<=10;i++){
			users.add(new User());
		}
		List<User> users2 = toBeanList(JSONArray.fromObject(users), User.class);
		for(User user1 : users2){
			System.out.println(user1.toString());
		}
		
		Map<String, User> maps = new HashMap<String, User>();
		maps.put("1", new User());
		maps.put("2", new User());
		maps.put("3", new User());
		maps.put("4", new User());
		System.out.println(toBeanMap(JSONObject.fromObject(maps), User.class));
	}
}

package com.baseService.baseTools.json;

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
	
	public static Object toBean(JSONObject object,Class class1){
		if(null == object){
			return null;
		}
		if(null == class1 || class1.isInterface()){
			return JSONObject.toBean(object);
		}
		return JSONObject.toBean(object, class1);
	}
	
	
	
}

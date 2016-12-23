package com.baseService.baseTools.autotest.params;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;


public class XmlParser {
	
	private final static String DEFAULT_CONFIG="classpath:config.xml";
	
	public Object parse(){
		return parse(DEFAULT_CONFIG);
	}
	
	protected List<Object> parse(String... locations){
		if(null == locations || locations.length == 0){
			Object obj = parse();
			List<Object> objList = new ArrayList<Object>();
			objList.add(obj);
			return objList;
		}
		return parse(true,locations);
	}

	private List<Object> parse(boolean b, String... locations) {
		List<Object> objList = new ArrayList<Object>();
		for(String location:locations){
			Object obj = parse(location);
			objList.add(obj);
		}
		return objList;
	}
	public Object parse(String location){
		
		String content = FileUtil.readFile(location);
		JSON json = JSONSerializer.toJSON(content);
		XMLSerializer ser = new XMLSerializer();
		String xml = ser.write(json);
		return xml;
		
	}
	
	
}

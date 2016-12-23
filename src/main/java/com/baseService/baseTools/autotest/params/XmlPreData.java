package com.baseService.baseTools.autotest.params;

public class XmlPreData implements PreData {

	private XmlParser xmlParser;
	@Override
	public Object getData() {
		//parse xml
		return xmlParser.parse();
	}

}

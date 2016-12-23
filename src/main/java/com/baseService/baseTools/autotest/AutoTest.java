package com.baseService.baseTools.autotest;

import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class AutoTest {
	
	public static void main(String[] args) {
		
		HttpClient client = new HttpClient();
		RequestConfigBean bean = new RequestConfigBean();
		bean.setUri("http://10.2.2.42:8007/jubaopen");
		bean.setHttpMethod("POST");
		bean.setCharset(Charset.forName("utf8"));
		bean.setConnectTimeout(60000);
		Header[] headerArr = new Header[2];
		headerArr[0] = new BasicHeader("Content-Type", "application/json;charset=utf8");
		bean.setHeaders(headerArr);
		
		HttpResult result = client.sendSingleRequest(bean);
		System.out.println(result.getData());
	}
}

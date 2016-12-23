package com.baseService.baseTools.autotest;

import java.io.IOException;
import java.net.URL;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	
	public static HttpResult send(CloseableHttpClient httpClient, RequestConfigBean bean) {
		HttpResult result = new HttpResult();
		if("POST".equalsIgnoreCase(bean.getHttpMethod())){
			result = doPost(httpClient,bean);
		}else if("GET".equalsIgnoreCase(bean.getHttpMethod())){
//			doGet(bean);
		}
		return result;
	}

	private static HttpResult doPost(CloseableHttpClient httpClient, RequestConfigBean bean) {
		HttpPost post = new HttpPost(bean.getUri());
		HttpResult result = new HttpResult();
		System.out.println(bean.getUri());
//		post.setHeaders(bean.getHeaders());
		if(bean.getRequestParam() instanceof String){			
			post.setEntity(new StringEntity((String)bean.getRequestParam(), bean.getCharset()));
		}else {
			//TODO
		}
		HttpResponse response = null;
		try {
			response = httpClient.execute(post);
			int code = response.getStatusLine().getStatusCode();
			if(code==200){
				result.setIsSuccess(1);
				result.setStatusCode(code);
				result.setData(EntityUtils.toString(response.getEntity()));
			}else if(code>300&&code<310){
				//重定向
				Header[] headers = response.getAllHeaders();
				for(int i =0 ;i<headers.length;i++){
					if(headers[i].getName().equals("Location")){
						URL url = new URL(bean.getUri());
						if(headers[i].getValue().toLowerCase().startsWith("http")){
							bean.setUri(headers[i].getValue());
							break;
						}
						bean.setUri(url.getProtocol()+"://"+url.getHost()+url.getPort()+headers[i].getValue());
						break;
					}
				}
				post.setHeaders(headers);
				doPost(httpClient,bean);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			post.releaseConnection();
		}
		return result;
	}
	
}

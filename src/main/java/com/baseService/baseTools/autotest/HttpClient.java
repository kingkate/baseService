package com.baseService.baseTools.autotest;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class HttpClient implements HttpService {
	
	private static CloseableHttpClient httpClient = null;
	
	public HttpClient(){
//		init();
	}

	
	
	/**
	 * 创建默认的HttpClient;
	 */
	private void init() {
		if(null == httpClient){
			synchronized (HttpClient.class) {
				if(null == httpClient){
					httpClient = HttpClients.createDefault();
				}
			}
		}
	}
	
	/**
	 * 创建支持多线程的http请求
	 */
	public void initClientWithPool(){
		if(null == httpClient){
			synchronized (HttpClient.class) {
				if(null == httpClient){
					PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
			        cm.setMaxTotal(100);
			        httpClient = HttpClients.custom()
			        		                .setConnectionManager(cm)
			        		                .build();	
				}
			}
		}
	}



	@Override
	public HttpResult sendRequest(RequestConfigBean bean) {
		return sendRequest(bean,false);
	}



	public HttpResult sendRequest(RequestConfigBean bean, boolean isMultiThread) {
		if(!isMultiThread){
			return sendSingleRequest(bean);
		}
		return sendMultiThreadRequest(bean);
	}



	public HttpResult sendMultiThreadRequest(RequestConfigBean bean) {
		initClientWithPool();
		return HttpClientUtil.send(httpClient,bean);
	}


	public HttpResult sendSingleRequest(RequestConfigBean bean) {
		init();
		return HttpClientUtil.send(httpClient,bean);
	}
}

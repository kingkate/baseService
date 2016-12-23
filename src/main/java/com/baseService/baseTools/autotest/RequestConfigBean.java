package com.baseService.baseTools.autotest;

import java.nio.charset.Charset;

import org.apache.http.Header;

public class RequestConfigBean {
	
	public Schema getSchema() {
		return schema;
	}
	public void setSchema(Schema schema) {
		this.schema = schema;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public long getConnectTimeout() {
		return connectTimeout;
	}
	public void setConnectTimeout(long connectTimeout) {
		this.connectTimeout = connectTimeout;
	}
	public long getReadTimeout() {
		return readTimeout;
	}
	public void setReadTimeout(long readTimeout) {
		this.readTimeout = readTimeout;
	}
	public Charset getCharset() {
		return charset;
	}
	public void setCharset(Charset charset) {
		this.charset = charset;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public boolean isAutoRedirect() {
		return autoRedirect;
	}
	public void setAutoRedirect(boolean autoRedirect) {
		this.autoRedirect = autoRedirect;
	}
	public boolean isFollowRedirect() {
		return followRedirect;
	}
	public void setFollowRedirect(boolean followRedirect) {
		this.followRedirect = followRedirect;
	}
	public boolean isKeepalive() {
		return keepalive;
	}
	public void setKeepalive(boolean keepalive) {
		this.keepalive = keepalive;
	}
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	


	public Object getRequestParam() {
		return requestParam;
	}
	public void setRequestParam(Object requestParam) {
		this.requestParam = requestParam;
	}



	public Header[] getHeaders() {
		return headers;
	}
	public void setHeaders(Header[] headers) {
		this.headers = headers;
	}



	private Schema schema = Schema.http;
	private String host;
	private int port;
	private long connectTimeout;
	private long readTimeout;	
	private String httpMethod;
	private Charset charset = Charset.defaultCharset();
	private String uri;
	private boolean autoRedirect;
	private boolean followRedirect=true;
	private boolean keepalive = true;
	private Object requestParam;
	private Header[] headers;
	
}

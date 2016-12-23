package com.baseService.baseTools.autotest;

public class HttpResult {
	
	private Object data;
	private int isSuccess;
	private int statusCode;
	private Error error;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getIsSuccess() {
		return isSuccess;
	}
	public void setIsSuccess(int isSuccess) {
		this.isSuccess = isSuccess;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}


	class Error {
		private int errorCode;
		private String errorMsg;
		@Override
		public String toString() {
			return "Error [errorCode=" + errorCode + ", errorMsg=" + errorMsg
					+ "]";
		}
		public Error(int errorCode, String errorMsg) {
			super();
			this.errorCode = errorCode;
			this.errorMsg = errorMsg;
		}
		
	}
	
	
}

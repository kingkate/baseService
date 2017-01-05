package com.baseService.designmodel.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicApproveServiceProxy implements InvocationHandler {

	
	private Object obj;

	/*public DynamicApproveServiceProxy(Object obj) {
		this.obj = obj;
	}*/
	
	public Object getInstance(Object obj){
		this.obj = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object obj, Method method, Object[] params)
			throws Throwable {
		System.out.println("调用了方法："+method.getName());
		Object resultObject = method.invoke(this.obj, params);
		System.out.println(method.getName()+"方法执行完毕！");
		return resultObject;
	}


	public Object getObj() {
		return obj;
	}


	public void setObj(Object obj) {
		this.obj = obj;
	}

}

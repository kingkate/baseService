package com.baseService.designmodel.proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;

public class CglibDynamicProxy {

	public Object createCGLIBProxyInstance(Object obj){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(obj.getClass());
		enhancer.setCallback(new CglibProxy());
		Object proxyInstance = enhancer.create();
		return proxyInstance;
	}
}

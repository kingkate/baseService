package com.baseService.designmodel.proxy.dynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	@Override
	public Object intercept(Object obj, Method method, Object[] params,
			MethodProxy methodProxy) throws Throwable {
		System.out.println("调用了方法："+method.getName());
		Object result = methodProxy.invokeSuper(obj, params);
		System.out.println(method.getName()+"方法执行完毕！");
		return result;
	}

}

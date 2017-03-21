package com.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor2 extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("==============我进来了222222222");
		String flag = invocation.invoke();
		System.out.println("==============我出去了22222222");
		return flag;
	}

}

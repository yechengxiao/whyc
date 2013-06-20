package com.ycx.util.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
//用户没登录，就拦截下来
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		if (userId == null) {
			return "login";
		}
		return arg0.invoke();
	}
}

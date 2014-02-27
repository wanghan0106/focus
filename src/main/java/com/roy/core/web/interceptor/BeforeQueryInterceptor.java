package com.roy.core.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.roy.core.web.Params;
import com.roy.core.web.annotation.BeforeQuery;

public class BeforeQueryInterceptor implements HandlerInterceptor  {
	
	private static final Logger log = LoggerFactory.getLogger(BeforeQueryInterceptor.class);

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView view) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		HttpSession session = request.getSession();
		if(handler instanceof HandlerMethod) {
			Method method = ((HandlerMethod) handler).getMethod();
			if(method.isAnnotationPresent(BeforeQuery.class)) {
				String clearSession = request.getParameter("clearSession");
				if(clearSession!=null && "true".equals(clearSession)) {
					session.removeAttribute("params");
				}
				Params params = (Params) session.getAttribute("params");
				if(params==null) {
					params = new Params();
				}
				request.setAttribute("params", params);
			}
		}
		return true;
	}
	
}

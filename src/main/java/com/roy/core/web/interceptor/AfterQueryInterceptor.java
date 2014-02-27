package com.roy.core.web.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.roy.core.web.Params;
import com.roy.core.web.QueryParam;
import com.roy.core.web.annotation.AfterQuery;

public class AfterQueryInterceptor implements HandlerInterceptor  {
	
	private static final Logger log = LoggerFactory.getLogger(AfterQueryInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if(handler instanceof HandlerMethod) {
			Method method = ((HandlerMethod) handler).getMethod();
			if(method.isAnnotationPresent(AfterQuery.class)) {
				Params params = getParams(request.getParameterMap());
				request.getSession().setAttribute("params", params);
			}
		}
	}

	private Params getParams(Map<String, Object> paramsMap)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Params params = new Params();
		String[] value = (String[]) paramsMap.get("page");
		if(value!=null && value.length > 0) {
			params.setPage(Integer.parseInt(value[0]));
		}
		value = (String[]) paramsMap.get("rows");
		if(value!=null && value.length > 0) {
			params.setRows(Integer.parseInt(value[0]));
		}
		value = (String[]) paramsMap.get("sort");
		if(value!=null && value.length > 0) {
			params.setSort(value[0]);
		}
		value = (String[]) paramsMap.get("order");
		if(value!=null && value.length > 0) {
			params.setOrder(value[0]);
		}
		Map<Integer,QueryParam> queryParamMap = new HashMap<Integer,QueryParam>();
		for(String key : paramsMap.keySet()) {
			if(key.startsWith("queryParams")) {
				Object[] paramValue = (Object[]) paramsMap.get(key);
				if(paramValue!=null && paramValue.length > 0) {
					int index = Integer.parseInt(key.substring(12, 13));
					String property = key.substring(key.indexOf("].")+2);
					QueryParam param = queryParamMap.get(index);
					if(param == null) {
						param = new QueryParam();
						queryParamMap.put(index, param);
					}
					PropertyUtils.setProperty(param, property, paramValue[0]);
				}
			}
		}
		for(Integer index : queryParamMap.keySet()) {
			params.getQueryParams().add(index, queryParamMap.get(index));
		}
		return params;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}

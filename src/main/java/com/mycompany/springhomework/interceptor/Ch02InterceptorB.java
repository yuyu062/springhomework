package com.mycompany.springhomework.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycompany.springhomework.interceptor.Auth.Role;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Ch02InterceptorB implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		log.info("실행");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
        if(auth == null) {
        	return true;
        }else {
        	if(auth.value()== Role.ADMIN) {
        		boolean isAdmin = true;
        		if(isAdmin) {
        			return true;
        		}else {
        			log.info("관리자 권한없음");
        			response.sendRedirect(request.getContextPath());
        		}
        	}else {
        		return true;
        	}
        }
        return true;
	}
}


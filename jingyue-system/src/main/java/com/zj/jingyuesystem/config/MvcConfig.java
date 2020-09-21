package com.zj.jingyuesystem.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MvcConfig implements HandlerInterceptor, InitializingBean {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL + ":" + request.getRequestURL()        );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println(modelAndView.getViewName()+":viewName");
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}

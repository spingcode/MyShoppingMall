package com.kaola.filter;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 16:41 2018/2/23
 *@Modified By:
 */


import com.mysql.jdbc.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest proxy = (HttpServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                Object resultValue=null;
                if("getParameter".equals(methodName))
                {
                    String value = request.getParameter(args[0].toString());
                    if(StringUtils.isNullOrEmpty(value)&&"GET".equalsIgnoreCase(request.getMethod()))
                    {
                        value = new String(value.getBytes("ISO-8859-1"),"UTF-8");
                    }
                    return value;
                }
                else
                {
                    resultValue= method.invoke(request, args);
                }
                return resultValue;
            }
        });
        chain.doFilter(proxy, response);
    }

    @Override
    public void destroy() {

    }
}

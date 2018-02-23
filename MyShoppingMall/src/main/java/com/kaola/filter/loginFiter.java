package com.kaola.filter;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 15:19 2018/2/23
 *@Modified By:
 */

import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginFiter  implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String sellerUser = (String) request.getSession().getAttribute("sellerUser");
        String buyerUser = (String) request.getSession().getAttribute("buyerUser");
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        System.out.println(requestURI);
        System.out.println( requestURI.substring("/MyShoppingMall/".length()-1));
        if (StringUtils.isEmpty( requestURI.substring("/MyShoppingMall/".length())))
        {
            System.out.println("coming");
            request.getRequestDispatcher("public/commodit/getAllCommodit").forward(request,response);
        }
        else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}

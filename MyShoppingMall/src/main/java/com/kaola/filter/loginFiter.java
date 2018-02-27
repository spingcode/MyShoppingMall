package com.kaola.filter;/*
 *@Author:zouw
 *@Description:
 *@Date:Created in 15:19 2018/2/23
 *@Modified By:
 */

import com.kaola.util.PropertiesFileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class loginFiter  implements Filter{

    private static final Log logger = LogFactory.getLog(loginFiter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        String contextPath = request.getContextPath();
        String loginStatus = (String) session.getAttribute("loginStatus");
        if (StringUtils.isEmpty(loginStatus))
        {
            String sellerUser = (String)session.getAttribute("sellerUser");
            String buyerUser = (String) session.getAttribute("buyerUser");
            if(!StringUtils.isEmpty(sellerUser))
                //卖家
                session.setAttribute("loginStatus","sellerUser");
            else if (!StringUtils.isEmpty(buyerUser))
                //买家
                session.setAttribute("loginStatus","buyerUser");
            else
                //游客
                session.setAttribute("loginStatus","visitor");
        }
        if (PropertiesFileUtil.getProperty("item.contextPath").equals(requestURI))
        {
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

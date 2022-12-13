package com.library.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-11-05-9:03
 */
public class ClientFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;

        Object Id = httpServletRequest.getSession().getAttribute("Id");

        if (Id == null) {
            httpServletRequest.getRequestDispatcher("/index.jsp").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}

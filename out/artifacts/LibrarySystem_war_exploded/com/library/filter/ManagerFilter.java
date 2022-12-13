package com.library.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-11-04-20:58
 */
public class ManagerFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;

        Object admin = httpServletRequest.getSession().getAttribute("admin");

        if (admin == null) {
            httpServletRequest.getRequestDispatcher("/pages/manager_error.jsp").forward(request,response);
        }else{
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}

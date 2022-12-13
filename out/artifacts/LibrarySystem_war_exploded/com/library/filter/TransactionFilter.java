package com.library.filter;

import com.library.util.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-11-04-20:58
 */
public class TransactionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request,response);
            JDBCUtils.commitAndClose();
        } catch (Exception e) {
            JDBCUtils.rollbackAndClose();
            e.printStackTrace();
            //把异常抛给Tomcat管理展示友好的错误界面
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}

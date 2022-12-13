package com.library.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-16:18
 */
public abstract class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决post请求中文乱码问题
        //一定要在获取请求参数之前调用才有效
        req.setCharacterEncoding("UTF-8");
        //解决响应中的乱码问题
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        Method method = null;
        try {
            //获取action业务鉴别字符串，获取相应的业务方法反射对象
            method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            //把异常抛给Filter过滤器
            throw new RuntimeException(e);
        }
    }
}

package com.library.web;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.service.AdminService;
import com.library.service.Impl.AdminServiceImpl;
import com.library.service.Impl.ReaderCardServiceImpl;
import com.library.service.ReaderCardService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-17:11
 */
public class LoginServlet extends BaseServlet{
    AdminService adminService = new AdminServiceImpl();
    ReaderCardService readerCardService = new ReaderCardServiceImpl();
    /**
     * 处理管理员登录业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数
        String Id = req.getParameter("Id");
        String password = req.getParameter("password");
        //判断是管理员还是读者（读者8位，管理员6位）
        if (Id.length() == 6) {//管理员
            //2.调用adminService.login()处理业务
            Admin admin=adminService.login(new Admin(Integer.parseInt(Id), null,password));
            //如果loginUser==null,则登录失败
            if(admin==null){
                //登录失败  -- 把错误信息，和回显表单项信息，保存到Request域中
                req.setAttribute("msg","账号或密码错误！");
                req.setAttribute("Id", Id);
                //跳回登录页面
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }else{
                //登录成功  ---保存用户登录信息到Session域中
                req.getSession().setAttribute("Id", admin.getAdmin_id());
                req.getSession().setAttribute("admin",admin.getUsername());
                // 跳转到登录成功页面
                req.getRequestDispatcher("/pages/admin/admin_main.jsp").forward(req, resp);
            }
        } else if (Id.length()== 8) {
            //2.readerCardService.login()处理业务
            ReaderCard reader=readerCardService.login(new ReaderCard(Integer.parseInt(Id), null,password));
            //如果loginUser==null,则登录失败
            if(reader==null){
                //登录失败  -- 把错误信息，和回显表单项信息，保存到Request域中
                req.setAttribute("msg","账号或密码错误！");
                req.setAttribute("Id", Id);
                //跳回登录页面
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }else{
                //登录成功  ---保存用户登录信息到Session域中
                req.getSession().setAttribute("Id", reader.getReader_id());
                req.getSession().setAttribute("reader",reader.getUsername());
                // 跳转到登录成功页面
                req.getRequestDispatcher("/pages/reader/reader_main.jsp").forward(req, resp);
            }
        }else{
            //登录失败  -- 把错误信息，和回显表单项信息，保存到Request域中
            req.setAttribute("msg","账号或密码错误！");
            req.setAttribute("Id", Id);
            //跳回登录页面
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //退出登录
        req.getSession().removeAttribute("Id");
        req.getSession().removeAttribute("admin");
        req.getSession().removeAttribute("reader");
        //跳回登录页面
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }

    }

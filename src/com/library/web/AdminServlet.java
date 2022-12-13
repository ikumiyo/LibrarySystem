package com.library.web;

import com.library.bean.Admin;
import com.library.bean.ReaderInfo;
import com.library.service.AdminService;
import com.library.service.Impl.AdminServiceImpl;
import com.library.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-16:26
 */
public class AdminServlet extends BaseServlet{
    AdminService adminService = new AdminServiceImpl();

    /**
     * 修改管理员密码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void resetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        String reNewPassword = req.getParameter("reNewPassword");
        String Id = req.getParameter("Id");
        //验证旧密码是否正确：调用adminService.login()处理业务
        Admin admin=adminService.login(new Admin(Integer.parseInt(Id), null,oldPassword));
        //如果loginUser==null,则登录失败
        if(admin==null){
            //旧密码错误  -- 把错误信息，和回显表单项信息，保存到Request域中
            req.setAttribute("msg","旧密码错误！请重新输入！");
            //跳回密码修改页面
            req.getRequestDispatcher("/pages/admin/admin_repasswd.jsp").forward(req, resp);
        }else{
            //旧密码正确  ---保存用户登录信息到Session域中
            Admin newAdmin = new Admin(Integer.parseInt(Id), null, reNewPassword);
            //2.调用BookService.updateBook(book)方法，修改图书
            adminService.resetPassword(newAdmin);
            //3.重定向回登录页面
            //退出登录-清空session域数据
            req.getSession().removeAttribute("Id");
            req.getSession().removeAttribute("admin");
            req.getSession().removeAttribute("reader");
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }

    }

}

package com.library.web;

import com.library.bean.*;
import com.library.service.Impl.ReaderCardServiceImpl;
import com.library.service.Impl.ReaderInfoServiceImpl;
import com.library.service.ReaderCardService;
import com.library.service.ReaderInfoService;
import com.library.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-16:56
 */
public class ReaderServlet extends BaseServlet{
    ReaderInfoService readerInfoService = new ReaderInfoServiceImpl();
    ReaderCardService readerCardService = new ReaderCardServiceImpl();

    /**
     * 获取所有读者信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void readerList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过readerInfoService查询全部读者信息
        List<ReaderInfo> readers = readerInfoService.getAllReaderInfo();
        //2.把全部读者信息保存到request域中
        req.setAttribute("readers", readers);
        //3.请求转发到/pages/admin/admin_readers.jsp页面
        req.getRequestDispatcher("/pages/admin/admin_readers.jsp").forward(req,resp);
    }

    /**
     * 获取所有借还日志
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void lendList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过readerInfoService查询全部借还信息
        List<LendInfo> lendList = readerInfoService.getAllLendInfo();
        //2.把全部读者信息保存到request域中
        req.setAttribute("lendList", lendList);
        //3.请求转发到/pages/admin/admin_lend_list.jsp页面
        req.getRequestDispatcher("/pages/admin/admin_lend_list.jsp").forward(req,resp);
    }

    /**
     * 删除借还记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteLendRecord(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数 -流水号
        int ser_num = WebUtils.parseInt(req.getParameter("ser_num"), 0);
        //2.调用bookService.deleteLendRecordBySerNum()
        readerInfoService.deleteLendRecordBySerNum(ser_num);
        //3.重定向到借还列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/readerServlet?action=lendList");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数  封装成为一个ReaderInfo对象
        ReaderInfo readerInfo = WebUtils.copyParamToBean(req.getParameterMap(), new ReaderInfo());
        String password = req.getParameter("password");

        //2.调用readerInfoService.addReaderInfo方法保存读者信息
        readerInfoService.addReaderInfo(readerInfo);
        //获取刚刚插入的读者信息
        ReaderInfo lastReaderInfo = readerInfoService.getLastReaderInfo();
        //封装一个ReaderCard对象
        ReaderCard readerCard = new ReaderCard(lastReaderInfo.getReader_id(), lastReaderInfo.getName(), password);
        //添加读书卡信息
        readerCardService.addReaderCard(readerCard);
        //3.重定向到读者列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/readerServlet?action=readerList");
    }

    /**
     * 删除读者操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数读者id
        int reader_id = WebUtils.parseInt(req.getParameter("reader_id"), 0);
        //2.调用bookService.deleteBookById()
        readerInfoService.deleteReaderInfoById(reader_id);
        readerCardService.deleteReaderCardById(reader_id);
        //3.重定向到读者列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/readerServlet?action=readerList");
    }

    /**
     * 获取要修改的读者信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void editReader(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：读者Id
        int reader_id = WebUtils.parseInt(req.getParameter("reader_id"), 0);
        //2.调用readerInfoService.findReaderInfoById()方法查询读者信息
        ReaderInfo readerInfo = readerInfoService.findReaderInfoById(reader_id);
        //3.保存读者信息到Request域中
        req.setAttribute("readerInfo", readerInfo);
        //4.请求转发到/pages/admin/admin_reader_edit.jsp页面中
        req.getRequestDispatcher("/pages/admin/admin_reader_edit.jsp").forward(req, resp);
    }
    /**
     * 修改读者信息的操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成为ReaderInfo对象
        ReaderInfo readerInfo= WebUtils.copyParamToBean(req.getParameterMap(), new ReaderInfo());
        //2.调用readerInfoService.updateReaderInfo()方法，修改读者信息
        readerInfoService.updateReaderInfo(readerInfo);
        //3.重定向到读者列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/readerServlet?action=readerList");
    }



}

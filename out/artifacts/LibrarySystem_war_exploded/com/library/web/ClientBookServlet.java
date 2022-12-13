package com.library.web;

import com.library.bean.*;
import com.library.service.BookService;
import com.library.service.Impl.BookServiceImpl;
import com.library.service.Impl.LendInfoServiceImpl;
import com.library.service.Impl.ReaderCardServiceImpl;
import com.library.service.Impl.ReaderInfoServiceImpl;
import com.library.service.LendInfoService;
import com.library.service.ReaderCardService;
import com.library.service.ReaderInfoService;
import com.library.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-31-18:46
 */
public class ClientBookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    LendInfoService lendInfoService = new LendInfoServiceImpl();
    ReaderInfoService readerInfoService = new ReaderInfoServiceImpl();
    ReaderCardService readerCardService = new ReaderCardServiceImpl();
    /**
     * 用户图书查询业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void bookAndLendList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数 读者Id
        String readerId = req.getParameter("readerId");
        //2.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //3.通过lendInfoService.myLendList()查询个人借还日志
        List<LendInfo> myLendList = lendInfoService.myLendList(Integer.parseInt(readerId));
        //4.把全部图书保存到request域中
        req.setAttribute("books", books);
        //5.把当前读者的借阅信息保存到request域中
        req.setAttribute("myLendList", myLendList);
        //3.请求转发到/pages/reader/reader_books.jsp页面
        req.getRequestDispatcher("/pages/reader/reader_books.jsp").forward(req,resp);
    }

    /**
     * 获取我的借阅记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getMyLendList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数 读者Id
        String readerId = req.getParameter("readerId");
        //2.通过lendInfoService.myLendList查询个人借还日志
        List<LendInfo> myLendList = lendInfoService.myLendList(Integer.parseInt(readerId));
        //3.把当前读者的借阅信息保存到request域中
        req.setAttribute("myLendList", myLendList);
        //3.请求转发到/pages/reader/reader_lend_list.jsp页面
        req.getRequestDispatcher("/pages/reader/reader_lend_list.jsp").forward(req,resp);
    }

    /**
     * 通过关键词搜索图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryBookByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的搜索关键字
        String searchWord = req.getParameter("searchWord");
        //2.调用bookService.queryBookByName()方法查询图书
        List<Book> books = bookService.queryBookByKeyWord(searchWord);
        //3.保存图书到Request域中
        req.setAttribute("books", books);
        //4.请求转发到/pages/reader/reader_books.jsp页面
        req.getRequestDispatcher("/pages/reader/reader_books.jsp").forward(req,resp);
    }
    /**
     * 通过id获取图书信息(图书详情)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getBookDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：图书编号
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        //2.调用bookService.queryBookById()方法查询图书
        Book bookDetails = bookService.queryBookById(bookId);
        //3.保存图书详情信息到Request域中
        req.setAttribute("bookDetails", bookDetails);
        //4.请求转发到/pages/reader/reader_book_detail.jsp页面中
        req.getRequestDispatcher("/pages/reader/reader_book_detail.jsp").forward(req, resp);
    }

    /**
     * 通过readerId获取读者信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getReaderInfoById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：读者Id
        int readerId = WebUtils.parseInt(req.getParameter("readerId"), 0);
        //2.调用readerInfoService.findReaderInfoById()方法查询读者信息
        ReaderInfo readerInfo = readerInfoService.findReaderInfoById(readerId);
        //3.保存读者信息详情到Request域中
        req.setAttribute("readerInfo", readerInfo);
        //4.请求转发到/pages/reader/reader_info.jsp页面中
        req.getRequestDispatcher("/pages/reader/reader_info.jsp").forward(req, resp);
    }

    /**
     * 获取要修改的读者信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getEditReaderInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：读者Id
        int readerId = WebUtils.parseInt(req.getParameter("readerId"), 0);
        //2.调用readerInfoService.findReaderInfoById()方法查询读者信息
        ReaderInfo readerInfo = readerInfoService.findReaderInfoById(readerId);
        //3.保存读者信息到Request域中
        req.setAttribute("readerInfo", readerInfo);
        //4.请求转发到/pages/reader/reader_info_edit.jsp页面中
        req.getRequestDispatcher("/pages/reader/reader_info_edit.jsp").forward(req, resp);
    }

    /**
     * 修改读者信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成为ReaderInfo对象
        ReaderInfo readerInfo = WebUtils.copyParamToBean(req.getParameterMap(), new ReaderInfo());
        //2.调用readerInfoService.updateReaderInfo()方法，修改读者信息
        readerInfoService.updateReaderInfo(readerInfo);
        //3.重定向回个人信息页面
        resp.sendRedirect(req.getContextPath() + "/clientBookServlet?action=getReaderInfoById&readerId=" + readerInfo.getReader_id());
    }



    /**
     * 归还图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void returnBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：图书id,读者id
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        int readerId = WebUtils.parseInt(req.getParameter("readerId"), 0);
        //获取当前日期
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataStr = date.format(fmt);
        //2.归还图书
        //第一步：调用lendInfoService.bookReturnStepOne()方法-更新借还记录
        lendInfoService.bookReturnStepOne(bookId, readerId, dataStr);
        //第二步：调用lendInfoService.bookReturnStepTwo()方法-更新图书数量
        lendInfoService.bookReturnStepTwo(bookId);
        //3.重定向回图书列表页面
        resp.sendRedirect(req.getContextPath()+"/clientBookServlet?action=bookAndLendList&readerId="+readerId);
    }

    /**
     * 借阅图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void lendBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：图书id,读者id
        int bookId = WebUtils.parseInt(req.getParameter("bookId"), 0);
        int readerId = WebUtils.parseInt(req.getParameter("readerId"), 0);
        //获取当前日期
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataStr = date.format(fmt);
        //2.归还图书
        //第一步：调用lendInfoService.bookLendStepOne()方法-更新借还记录
        lendInfoService.bookLendStepOne(bookId, readerId, dataStr);
        //第二步：调用lendInfoService.bookLendStepTwo()方法-更新图书数量
        lendInfoService.bookLendStepTwo(bookId);
        //3.重定向回图书列表页面
        resp.sendRedirect(req.getContextPath()+"/clientBookServlet?action=bookAndLendList&readerId="+readerId);
    }

    protected void resetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String oldPassword = req.getParameter("oldPassword");
        String reNewPassword = req.getParameter("reNewPassword");
        String Id = req.getParameter("Id");
        //验证旧密码是否正确：调用readerCardService.login()处理业务
        ReaderCard readerCard=readerCardService.login(new ReaderCard(Integer.parseInt(Id), null,oldPassword));
        //如果loginUser==null,则登录失败
        if(readerCard==null){
            //旧密码错误  -- 把错误信息，和回显表单项信息，保存到Request域中
            req.setAttribute("msg","旧密码错误！请重新输入！");
            //跳回密码修改页面
            req.getRequestDispatcher("/pages/reader/reader_repasswd.jsp").forward(req, resp);
        }else{
            //旧密码正确  ---保存用户登录信息到Session域中
            ReaderCard newReaderCard = new ReaderCard(Integer.parseInt(Id), null, reNewPassword);
            //2.调用readerCardService.resetPassword(newReaderCard)方法，修改密码
            readerCardService.resetPassword(newReaderCard);
            //3.重定向回登录页面
            //退出登录
            req.getSession().removeAttribute("Id");
            req.getSession().removeAttribute("admin");
            req.getSession().removeAttribute("reader");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}

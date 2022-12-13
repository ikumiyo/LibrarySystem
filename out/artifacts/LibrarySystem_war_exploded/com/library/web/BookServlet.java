package com.library.web;

import com.library.bean.Book;
import com.library.service.BookService;
import com.library.service.Impl.BookServiceImpl;
import com.library.util.WebUtils;
import sun.misc.Request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.getDate;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-19:49
 */
public class BookServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();

    /**
     * 添加图书操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数  封装成为一个Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());

        //2.调用BookService.addBook()方法保存图书
        bookService.addBook(book);

        //3.跳到图书列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=booklist");
    }

    /**
     * 删除图书操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数id图书编号
        int book_id = WebUtils.parseInt(req.getParameter("book_id"), 0);

        //2.调用bookService.deleteBookById()
        bookService.deleteBookById(book_id);
        //3.重定向回图书列表管理页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=booklist");
    }

    /**
     * 修改图书的操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.updateBook(book)方法，修改图书
        bookService.updateBook(book);
        //3.重定向回图书列表页面
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=booklist");
    }

    /**
     * 获取要编辑的图书信息，跳转到图书编辑页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void editBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数：图书编号
        int book_id = WebUtils.parseInt(req.getParameter("book_id"), 0);
        //2.调用bookService.queryBookById()方法查询图书
        Book bookDetails = bookService.queryBookById(book_id);
        //3.保存图书到Request域中
        req.setAttribute("bookDetails", bookDetails);
        //4.请求转发到/pages/manager/book_edit.jsp页面中
        req.getRequestDispatcher("/pages/admin/admin_book_edit.jsp").forward(req, resp);
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
        int book_id = WebUtils.parseInt(req.getParameter("book_id"), 0);
        //2.调用bookService.queryBookById()方法查询图书
        Book bookDetails = bookService.queryBookById(book_id);
        //3.保存图书到Request域中
        req.setAttribute("bookDetails", bookDetails);
        //4.请求转发到/pages/manager/admin/admin_book_detail.jsp页面中
        req.getRequestDispatcher("/pages/admin/admin_book_detail.jsp").forward(req, resp);
    }

    /**
     * 获取所有图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void booklist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到request域中
        req.setAttribute("books", books);
        //3.请求转发到/pages/admin/admin_books.jsp页面
        req.getRequestDispatcher("/pages/admin/admin_books.jsp").forward(req,resp);
    }

    protected void queryBookByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的搜索关键字
        String searchWord = req.getParameter("searchWord");
        //2.调用bookService.queryBookByName()方法查询图书
        List<Book> books = bookService.queryBookByKeyWord(searchWord);
        //3.保存图书到Request域中
        req.setAttribute("books", books);
        //4.请求转发到/pages/admin/admin_books.jsp页面
        req.getRequestDispatcher("/pages/admin/admin_books.jsp").forward(req,resp);
    }
}

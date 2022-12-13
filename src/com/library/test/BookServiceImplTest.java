package com.library.test;

import com.library.bean.Book;
import com.library.service.BookService;
import com.library.service.Impl.BookServiceImpl;
import org.junit.Test;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-19:42
 */
public class BookServiceImplTest {
    BookService bookService=new BookServiceImpl();

    @Test
    public void queryBookByKeyWord() {
        for (Book book :bookService.queryBookByKeyWord("人")) {
            System.out.println(book);
        }
    }


    @Test
    public void addBook() {
        Book book = new Book("秘密花园3", "佚名", "无", "7495845", "暂无",
                "中文", new BigDecimal("45.9"), "2017-09-11", 1, 20);
        bookService.addBook(book);

    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(13);
    }

    @Test
    public void updateBook() {
        Book book = new Book("秘密花园", "佚名", "无", "7495845", "暂无",
                "中文", new BigDecimal("45.9"), "2017-09-11", 1, 20);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(13);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()) {
            System.out.println(book);
        }

    }
}
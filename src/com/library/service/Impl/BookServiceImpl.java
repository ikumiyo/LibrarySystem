package com.library.service.Impl;

import com.library.bean.Book;
import com.library.dao.BookDao;
import com.library.dao.impl.BookDaoImpl;
import com.library.service.BookService;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-19:40
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBook();
    }

    @Override
    public List<Book> queryBookByKeyWord(String searchWord) {
        return bookDao.queryBookByKeyWord(searchWord);
    }
}

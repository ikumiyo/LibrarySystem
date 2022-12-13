package com.library.service;

import com.library.bean.Book;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-19:35
 */
public interface BookService {

    //添加图书
    public void addBook(Book book);

    //通过id删除图书
    public void deleteBookById(Integer id);

    //更新图书
    public void updateBook(Book book);

    //通过id查询图书
    public Book queryBookById(Integer id);

    //查询所有图书
    public List<Book> queryBooks();

    //按关键字查询图书
    List<Book> queryBookByKeyWord(String searchWord);
}

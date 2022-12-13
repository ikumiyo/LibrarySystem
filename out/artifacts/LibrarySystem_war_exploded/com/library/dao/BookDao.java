package com.library.dao;

import com.library.bean.Book;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:59
 */
public interface BookDao {

    //通过关键字模糊查询图书
    List<Book> queryBookByKeyWord(String bookName);

    //添加图书
    int addBook(Book book);
    //通过id删除图书
    int deleteBookById(Integer id);
    //更新图书
    int updateBook(Book book);
    //通过id查询图书
    Book queryBookById(Integer id);
    //查询所有图书
    List<Book> queryBook();
}

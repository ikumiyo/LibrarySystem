package com.library.dao.impl;

import com.library.bean.Book;
import com.library.dao.BookDao;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-19:22
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public List<Book> queryBookByKeyWord(String keyWord) {
        String sql = "SELECT * FROM book_info WHERE NAME LIKE ? or AUTHOR LIKE ?";
        String param = "%" + keyWord + "%";
        return queryForList(Book.class,sql,param,param);
    }

    @Override
    public int addBook(Book book) {
        String sql = "INSERT book_info(name,author,publish,ISBN,introduction,LANGUAGE,price,pub_date,class_id,number) VALUES(?,?,?,?,?,?,?,?,?,?)";
        return update(sql,book.getName(), book.getAuthor(), book.getPublish(), book.getISBN(),
                book.getIntroduction(), book.getLanguage(), book.getPrice(),
                book.getPub_date(), book.getClass_id(), book.getNumber());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from book_info where book_id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book_info set name=?,author=?,publish=?,ISBN=?,introduction=?," +
                "LANGUAGE=?,price=?,pub_date=?,class_id=?,number=? where book_id=?";
        return update(sql, book.getName(),book.getAuthor(), book.getPublish(), book.getISBN(),
                book.getIntroduction(), book.getLanguage(), book.getPrice(),
                book.getPub_date(), book.getClass_id(), book.getNumber(),book.getBook_id());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql="select * from book_info where book_id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBook() {
        String sql="select * from book_info";
        return queryForList(Book.class,sql);
    }
}

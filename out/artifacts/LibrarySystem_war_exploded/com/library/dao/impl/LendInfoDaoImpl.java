package com.library.dao.impl;

import com.library.bean.Book;
import com.library.bean.LendInfo;
import com.library.dao.LendInfoDao;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-31-19:02
 */
public class LendInfoDaoImpl extends BaseDao implements LendInfoDao  {
    @Override
    public List<LendInfo> queryLendList() {
        String sql="select * from lend_list";
        return queryForList(LendInfo.class,sql);
    }

    @Override
    public List<LendInfo> myLendList(Integer readerId) {
        String sql="select * from lend_list where reader_id=? ";
        return queryForList(LendInfo.class,sql,readerId);
    }

    @Override
    public int bookReturnStepOne(Integer bookId,Integer readerId, String backDate) {
        String sql = "update lend_list set back_date=? where book_id=? and reader_id=?";
        return update(sql, backDate, bookId, readerId);
    }

    @Override
    public int bookReturnStepTwo(Integer bookId) {
        String sql = "update book_info set number=number+1 where book_id=?";
        return update(sql, bookId);
    }

    @Override
    public int bookLendStepOne(Integer bookId, Integer readerId, String lendDate) {
        String sql = "insert into lend_list(book_id,reader_id,lend_date) values(?,?,?) ";
        return update(sql, bookId, readerId, lendDate);
    }

    @Override
    public int bookLendStepTwo(Integer bookId) {
        String sql = "update book_info set number=number-1 where book_id=?";
        return update(sql, bookId);
    }
}

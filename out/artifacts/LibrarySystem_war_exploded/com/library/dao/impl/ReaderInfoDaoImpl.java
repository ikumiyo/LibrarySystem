package com.library.dao.impl;

import com.library.bean.Book;
import com.library.bean.LendInfo;
import com.library.bean.ReaderInfo;
import com.library.dao.ReaderInfoDao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-28-21:02
 */
public class ReaderInfoDaoImpl extends BaseDao implements ReaderInfoDao {

    @Override
    public List<ReaderInfo> getAllReaderInfo() {
        String sql="select * from reader_info";
        return queryForList(ReaderInfo.class,sql);
    }

    @Override
    public List<LendInfo> getAllLendInfo() {
        String sql="select * from lend_list";
        return queryForList(LendInfo.class,sql);
    }

    @Override
    public ReaderInfo getLastReaderInfo() {
        String sql="SELECT * FROM reader_info WHERE reader_id=(SELECT MAX(reader_id) FROM reader_info)";
        return queryForOne(ReaderInfo.class, sql);
    }

    @Override
    public int deleteLendRecordBySerNum(Integer id) {
        String sql = "delete from lend_list where ser_num=?";
        return update(sql, id);
    }


    @Override
    public ReaderInfo findReaderInfoById(Integer id) {
        String sql="select * from reader_info where reader_id=?";
        return queryForOne(ReaderInfo.class, sql, id);
    }

    @Override
    public int addReaderInfo(ReaderInfo readerInfo) {
        String sql = "insert reader_info(name,sex,birth,address,phone) values(?,?,?,?,?)";
        return update(sql, readerInfo.getName(), readerInfo.getSex(), readerInfo.getBirth(), readerInfo.getAddress(), readerInfo.getPhone());
    }

    @Override
    public int deleteReaderInfoById(Integer id) {
        String sql = "delete from reader_info where reader_id=?";
        return update(sql, id);
    }

    @Override
    public int updateReaderInfo(ReaderInfo readerInfo) {
        String sql = "update reader_info set name=?,sex=?,birth=?,address=?,phone=? where reader_id=?";
        return update(sql, readerInfo.getName(), readerInfo.getSex(), readerInfo.getBirth(), readerInfo.getAddress(), readerInfo.getPhone(), readerInfo.getReader_id());
    }
}

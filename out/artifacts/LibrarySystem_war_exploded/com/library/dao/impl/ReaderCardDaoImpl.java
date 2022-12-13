package com.library.dao.impl;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.bean.ReaderInfo;
import com.library.dao.ReaderCardDao;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:36
 */
public class ReaderCardDaoImpl extends BaseDao implements ReaderCardDao {
    //验证读书证信息
    @Override
    public ReaderCard getMatchCount(ReaderCard readerCard) {
        String sql="select * from reader_card where reader_id=? and password=? ";
        return queryForOne(ReaderCard.class, sql, readerCard.getReader_id(), readerCard.getPassword());
    }

    //重置密码
    @Override
    public int resetPassword(ReaderCard readerCard) {
        String sql = "UPDATE reader_card SET PASSWORD=? WHERE reader_id=?";
        return update(sql, readerCard.getPassword(), readerCard.getReader_id());
    }

    @Override
    public ReaderCard findReaderByReaderId(long reader_id) {
        return null;
    }

    @Override
    public int addReaderCard(ReaderCard readerCard) {
        String sql = "INSERT reader_card(reader_id,username,password) VALUES(?,?,?)";
        return update(sql, readerCard.getReader_id(), readerCard.getUsername(), readerCard.getPassword());
    }

    @Override
    public int deleteReaderCardById(Integer id) {
        String sql = "delete from reader_card where reader_id=?";
        return update(sql, id);
    }


}

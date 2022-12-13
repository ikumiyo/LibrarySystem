package com.library.dao;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;
import com.library.bean.ReaderInfo;

import java.io.Reader;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:30
 */
public interface ReaderCardDao {
    //验证读书证信息
    public ReaderCard getMatchCount(ReaderCard readerCard);

    //修改密码
    public int resetPassword(ReaderCard readerCard);

    //通过读者号查找读书证
    public ReaderCard findReaderByReaderId(long reader_id);

    //办理新的读书证
    public int addReaderCard(ReaderCard readerCard);

    //通过id删除读者证信息
    int deleteReaderCardById(Integer id);
}

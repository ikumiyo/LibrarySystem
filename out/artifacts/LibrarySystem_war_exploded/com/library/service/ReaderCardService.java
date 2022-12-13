package com.library.service;

import com.library.bean.Admin;
import com.library.bean.ReaderCard;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:40
 */
public interface ReaderCardService {

    // 登录
    public ReaderCard login(ReaderCard readerCard);

    //添加读书证
    public int addReaderCard(ReaderCard readerCard);

    //修改读书证密码
    public void resetPassword(ReaderCard readerCard);

    //通过id删除读者证信息
    int deleteReaderCardById(Integer id);

}

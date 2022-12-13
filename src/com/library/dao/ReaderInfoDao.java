package com.library.dao;

import com.library.bean.LendInfo;
import com.library.bean.ReaderInfo;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-28-20:56
 */
public interface ReaderInfoDao {

    //获取所有读者信息
    List<ReaderInfo> getAllReaderInfo();

    //获取所有读者借还信息
    List<LendInfo> getAllLendInfo();

    //获取刚刚自增添加的读者信息
    ReaderInfo getLastReaderInfo();

    //通过流水号删除借还记录
    int deleteLendRecordBySerNum(Integer id);

    //通过ReaderId获取读者信息
    ReaderInfo findReaderInfoById(Integer id);


    //添加读者信息
    int addReaderInfo(ReaderInfo readerInfo);

    //通过id删除读者信息
    int deleteReaderInfoById(Integer id);

    //修改读者信息
    int updateReaderInfo(ReaderInfo readerInfo);

}

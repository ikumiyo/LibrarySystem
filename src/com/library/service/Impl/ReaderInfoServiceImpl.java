package com.library.service.Impl;

import com.library.bean.LendInfo;
import com.library.bean.ReaderInfo;
import com.library.dao.ReaderInfoDao;
import com.library.dao.impl.ReaderInfoDaoImpl;
import com.library.service.ReaderInfoService;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-28-21:12
 */
public class ReaderInfoServiceImpl implements ReaderInfoService {
    ReaderInfoDao readerInfoDao = new ReaderInfoDaoImpl();

    @Override
    public List<ReaderInfo> getAllReaderInfo() {
        return readerInfoDao.getAllReaderInfo();
    }

    @Override
    public List<LendInfo> getAllLendInfo() {
        return readerInfoDao.getAllLendInfo();
    }

    @Override
    public ReaderInfo getLastReaderInfo() {
        return readerInfoDao.getLastReaderInfo();
    }

    @Override
    public int deleteLendRecordBySerNum(Integer id) {
        return readerInfoDao.deleteLendRecordBySerNum(id);
    }

    @Override
    public ReaderInfo findReaderInfoById(Integer id) {
        return readerInfoDao.findReaderInfoById(id);
    }

    @Override
    public int addReaderInfo(ReaderInfo readerInfo) {
        return readerInfoDao.addReaderInfo(readerInfo);
    }

    @Override
    public int deleteReaderInfoById(Integer id) {
        return readerInfoDao.deleteReaderInfoById(id);
    }

    @Override
    public int updateReaderInfo(ReaderInfo readerInfo) {
        return readerInfoDao.updateReaderInfo(readerInfo);
    }

}

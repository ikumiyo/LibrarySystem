package com.library.service.Impl;

import com.library.bean.LendInfo;
import com.library.dao.LendInfoDao;
import com.library.dao.impl.LendInfoDaoImpl;
import com.library.service.LendInfoService;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-31-19:57
 */
public class LendInfoServiceImpl implements LendInfoService {
    LendInfoDao lendInfoDao = new LendInfoDaoImpl();
    @Override
    public List<LendInfo> queryLendList() {
        return lendInfoDao.queryLendList();
    }

    @Override
    public List<LendInfo> myLendList(Integer readerId) {
        return lendInfoDao.myLendList(readerId);
    }

    @Override
    public int bookReturnStepOne(Integer bookId, Integer readerId, String backDate) {
        return lendInfoDao.bookReturnStepOne(bookId, readerId, backDate);
    }

    @Override
    public int bookReturnStepTwo(Integer bookId) {
        return lendInfoDao.bookReturnStepTwo(bookId);
    }

    @Override
    public int bookLendStepOne(Integer bookId, Integer readerId, String lendDate) {
        return lendInfoDao.bookLendStepOne(bookId, readerId, lendDate);
    }

    @Override
    public int bookLendStepTwo(Integer bookId) {
        return lendInfoDao.bookLendStepTwo(bookId);
    }

}

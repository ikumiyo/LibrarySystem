package com.library.service;

import com.library.bean.LendInfo;

import java.util.List;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-31-19:57
 */
public interface LendInfoService {
    //查询所有借还记录
    List<LendInfo> queryLendList();

    //查询reader_id对应的借还记录
    List<LendInfo> myLendList(Integer readerId);

    //归还图书第一步：更新借还记录
    int bookReturnStepOne(Integer bookId,Integer readerId,String backDate);
    //归还图书第二步：更新图书数量
    int bookReturnStepTwo(Integer bookId);

    //借阅图书第一步：更新借还记录
    int bookLendStepOne(Integer bookId, Integer readerId,String lendDate);
    //借阅图书第二步：更新图书数量
    int bookLendStepTwo(Integer bookId);
}

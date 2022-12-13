package com.library.test;

import com.library.bean.LendInfo;
import com.library.dao.LendInfoDao;
import com.library.dao.impl.LendInfoDaoImpl;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-31-19:46
 */
public class LendInfoDaoImplTest {
    LendInfoDao lendInfoDao = new LendInfoDaoImpl();

    @Test
    public void queryLendList() {
        for (LendInfo lendInfo : lendInfoDao.queryLendList()) {
            System.out.println(lendInfo);
        }
    }

    @Test
    public void myLendList() {
        for (LendInfo lendInfo : lendInfoDao.myLendList(100000)) {
            System.out.println(lendInfo);
        }
    }

    @Test
    public void bookReturnStepOne() {
        lendInfoDao.bookReturnStepOne(1, 100000, "2022-10-31");
    }

    @Test
    public void bookReturnStepTwo() {
        lendInfoDao.bookReturnStepTwo(1);
    }

    @Test
    public void bookLendStepOne() {
        lendInfoDao.bookLendStepOne(2, 100000, "2022-10-31");

    }

    @Test
    public void bookLendStepTwo() {
        lendInfoDao.bookLendStepTwo(1);
    }

    @Test
    public void testGetDate() {
        LocalDate date = LocalDate.now(); // get the current date
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dataStr = date.format(fmt);
        System.out.println(dataStr);

    }
}
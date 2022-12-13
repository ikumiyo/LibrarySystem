package com.library.test;

import com.library.bean.LendInfo;
import com.library.bean.ReaderInfo;
import com.library.service.Impl.ReaderInfoServiceImpl;
import com.library.service.ReaderInfoService;
import com.library.util.JDBCUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-28-21:15
 */
public class ReaderInfoServiceImplTest {
    ReaderInfoService readerInfoService = new ReaderInfoServiceImpl();

    @Test
    public void getAllReaderInfo() {
        List<ReaderInfo> allReaderInfo = readerInfoService.getAllReaderInfo();
        for (ReaderInfo readerInfo : allReaderInfo) {
            System.out.println(readerInfo);
        }

    }

    @Test
    public void findReaderInfoById() {
        ReaderInfo readerInfoById = readerInfoService.findReaderInfoById(10000);
        System.out.println(readerInfoById);

    }

    @Test
    public void addReaderInfo() {
        ReaderInfo newReaderInfo = new ReaderInfo("张八", "女", "2002-01-01", "江苏省无锡市", "13955003232");
        readerInfoService.addReaderInfo(newReaderInfo);
        JDBCUtils.commitAndClose();
    }

    @Test
    public void deleteReaderInfoById() {
        readerInfoService.deleteReaderInfoById(10006);
    }

    @Test
    public void updateReaderInfo() {
        ReaderInfo updateReaderInfo = new ReaderInfo(1000007,"李四", "女", "2001-01-01", "江苏省无锡市", "13955003232");
        readerInfoService.updateReaderInfo(updateReaderInfo);
        JDBCUtils.commitAndClose();
    }

    @Test
    public void getAllLendInfo() {
        List<LendInfo>  lendInfos= readerInfoService.getAllLendInfo();
        for (LendInfo lendInfo : lendInfos) {
            System.out.println(lendInfo);
        }
    }

}
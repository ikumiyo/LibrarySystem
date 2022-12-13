package com.library.test;

import com.library.bean.ReaderCard;
import com.library.dao.ReaderCardDao;
import com.library.dao.impl.ReaderCardDaoImpl;
import com.library.util.JDBCUtils;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:39
 */
public class ReaderCardDaoImplTest {
    ReaderCardDao readerCardDao = new ReaderCardDaoImpl();
    @Test
    public void getMatchCount() {

    }

    @Test
    public void resetPassword() {
        ReaderCard newReaderCard = new ReaderCard(11111111, null, "333");
        readerCardDao.resetPassword(newReaderCard);
        JDBCUtils.commitAndClose();
    }

    @Test
    public void findReaderByReaderId() {
    }

    @Test
    public void addReaderCard() {
    }
}
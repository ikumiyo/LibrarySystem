package com.library.service.Impl;

import com.library.bean.ReaderCard;
import com.library.dao.ReaderCardDao;
import com.library.dao.impl.ReaderCardDaoImpl;
import com.library.service.ReaderCardService;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-18:44
 */
public class ReaderCardServiceImpl implements ReaderCardService {
    ReaderCardDao readerCardDao = new ReaderCardDaoImpl();
    @Override
    public ReaderCard login(ReaderCard readerCard) {
        return readerCardDao.getMatchCount(readerCard);
    }

    @Override
    public int addReaderCard(ReaderCard readerCard) {
       return readerCardDao.addReaderCard(readerCard);
    }

    @Override
    public void resetPassword(ReaderCard readerCard) {
        readerCardDao.resetPassword(readerCard);
    }

    @Override
    public int deleteReaderCardById(Integer id) {
        return readerCardDao.deleteReaderCardById(id);
    }

}

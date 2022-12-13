package com.library.service.Impl;

import com.library.bean.Admin;
import com.library.dao.AdminDao;
import com.library.dao.impl.AdminDaoImpl;
import com.library.service.AdminService;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:42
 */
public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(Admin admin) {
        return adminDao.getMatchCount(admin);
    }

    @Override
    public void addAdmin(Admin admin) {

    }

    @Override
    public int resetPassword(Admin admin) {
        return adminDao.resetPassword(admin);
    }


}

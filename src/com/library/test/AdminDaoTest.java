package com.library.test;

import com.library.bean.Admin;
import com.library.dao.AdminDao;
import com.library.dao.impl.AdminDaoImpl;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:20
 */
public class AdminDaoTest {
    AdminDao adminDao = new AdminDaoImpl();

    @Test
    public void getMatchCount() {
        Admin isMatch = adminDao.getMatchCount(new Admin(123456,"123456",null));
        if (isMatch!=null) {
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }
    }
}

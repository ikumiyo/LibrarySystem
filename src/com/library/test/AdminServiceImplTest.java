package com.library.test;

import com.library.bean.Admin;
import com.library.service.AdminService;
import com.library.service.Impl.AdminServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:50
 */
public class AdminServiceImplTest {
    AdminService adminService = new AdminServiceImpl();

    @Test
    public void login() {
            System.out.println(adminService.login(new Admin(123456, "123456",null)));
    }

    @Test
    public void addAdmin() {
    }

    @Test
    public void updateAdmin() {
    }
}
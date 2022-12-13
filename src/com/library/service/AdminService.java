package com.library.service;

import com.library.bean.Admin;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:33
 */
public interface AdminService {

    /**
     * 登录
     * @param admin
     * @return
     */
    public Admin login(Admin admin);

    /**
     * 添加管理员
     * @param admin
     */
    public void addAdmin(Admin admin);

    /**
     * 修改管理员密码
     * @param admin
     */
    public int resetPassword(Admin admin);
}

package com.library.dao.impl;

import com.library.bean.Admin;
import com.library.dao.AdminDao;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:08
 */
public class AdminDaoImpl extends BaseDao implements AdminDao{
    //验证管理员身份
    @Override
    public Admin getMatchCount(Admin admin) {
        String sql="select * from admin where admin_id=? and password=? ";
        return queryForOne(Admin.class, sql, admin.getAdmin_id(), admin.getPassword());
    }

    //重置密码
    @Override
    public int resetPassword(Admin admin) {
        String sql = "UPDATE admin SET PASSWORD=? WHERE admin_id=?";
        return update(sql, admin.getPassword(), admin.getAdmin_id());
    }

}

package com.library.dao;

import com.library.bean.Admin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-15:01
 */
public interface AdminDao {

    /**
     * 验证管理员身份
     * @param admin
     * @return
     */
    public Admin getMatchCount(Admin admin);

    /**
     *
     * @param admin
     * @return
     */
    public int resetPassword(Admin admin);

}

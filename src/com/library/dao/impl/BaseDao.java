package com.library.dao.impl;

import com.alibaba.druid.util.JdbcUtils;
import com.library.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author ikumiyo
 * @create 2022-10-24-14:57
 */
public abstract class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法用来执行Insert/Update/Delete语句
     * @return
     */
    public int update(String sql,Object ...args) {
        Connection connection = JDBCUtils.getConnecton();

        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获异常后一定要往外抛
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回一个JavaBean对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type,String sql,Object ...args) {
        Connection connection = JDBCUtils.getConnecton();

        try {
           return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获异常后一定要往外抛
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询返回多个JavaBean对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JDBCUtils.getConnecton();

        try {
            return queryRunner.query(connection,sql,new BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获异常后一定要往外抛
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JDBCUtils.getConnecton();

        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            //捕获异常后一定要往外抛
            throw new RuntimeException(e);
        }
    }

}

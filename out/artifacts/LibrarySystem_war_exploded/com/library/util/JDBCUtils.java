package com.library.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private  static DruidDataSource dataSource;
//    使用 ThreadLocal 来确保所有 dao 操作都使用同一个 Connection 连接对象
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

    static {
        try {
            Properties properties=new Properties();
            //读取jdbc.properties属性配置文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取数据库连接池中的连接
     * @return
     */
    public static Connection getConnecton() {
        Connection conn=conns.get();
        if(conn==null){
            try {
                //取数据库连接池中的操作
                conn=dataSource.getConnection();
                //保存到ThreadLocal对象中，供后面的jdbc操作使用
                conns.set(conn);
                //设置为手动管理事务
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     *提交事务，并关闭释放连接
     */
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {//如果connection!=null,说明之前使用过连接，操作过数据库
            try {
                connection.commit();//提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //用完之后一定要执行remove操作，否则会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            }finally{
                try {
                    connection.close();//关闭连接
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //用完之后一定要执行remove操作，否则会出错，因为Tomcat服务器底层使用了线程池技术
        conns.remove();
    }
}

package com.library.bean;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-14:43
 */
public class Admin {
    private Integer admin_id;//管理员id
    private String username;//管理员名
    private String password;//管理员密码

    public Admin() {
    }

    public Admin(Integer admin_id, String username, String password) {
        this.admin_id = admin_id;
        this.username = username;
        this.password = password;
    }


    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

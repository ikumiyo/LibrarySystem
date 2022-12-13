package com.library.bean;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-14:56
 */
public class ReaderCard {
    private Integer reader_id;//读者证号
    private String username;//读者名
    private String password;//读者密码

    public ReaderCard() {
    }

    public ReaderCard(Integer reader_id, String username, String password) {
        this.reader_id = reader_id;
        this.username = username;
        this.password = password;
    }

    public Integer getReader_id() {
        return reader_id;
    }

    public void setReader_id(Integer reader_id) {
        this.reader_id = reader_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ReaderCard{" +
                "reader_id=" + reader_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

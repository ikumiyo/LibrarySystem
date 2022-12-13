package com.library.bean;

import java.util.Date;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-14:53
 */
public class LendInfo {
    private Integer ser_num;//流水号
    private Integer book_id;//图书id
    private Integer reader_id;//读者id
    private String lend_date;//借出日期
    private String back_date;//归还日期

    public LendInfo() {
    }

    public LendInfo(Integer ser_num, Integer book_id, Integer reader_id, String lend_date, String back_date) {
        this.ser_num = ser_num;
        this.book_id = book_id;
        this.reader_id = reader_id;
        this.lend_date = lend_date;
        this.back_date = back_date;
    }

    public Integer getSer_num() {
        return ser_num;
    }

    public void setSer_num(Integer ser_num) {
        this.ser_num = ser_num;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public Integer getReader_id() {
        return reader_id;
    }

    public void setReader_id(Integer reader_id) {
        this.reader_id = reader_id;
    }

    public String getLend_date() {
        return lend_date;
    }

    public void setLend_date(String lend_date) {
        this.lend_date = lend_date;
    }

    public String getBack_date() {
        return back_date;
    }

    public void setBack_date(String back_date) {
        this.back_date = back_date;
    }

    @Override
    public String toString() {
        return "Lend{" +
                "ser_num=" + ser_num +
                ", book_id=" + book_id +
                ", reader_id=" + reader_id +
                ", lend_date=" + lend_date +
                ", back_date=" + back_date +
                '}';
    }
}

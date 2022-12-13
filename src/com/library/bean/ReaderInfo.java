package com.library.bean;

import java.util.Date;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-14:57
 */
public class ReaderInfo {
    private Integer reader_id;//读者证号
    private String name;//读者姓名
    private String sex;//读者性别
    private String birth;//读者生日
    private String address;//读者地址
    private String phone;//读者手机号

    public ReaderInfo() {
    }


    public ReaderInfo(String name, String sex, String birth, String address, String phone) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
    }

    public ReaderInfo(Integer reader_id, String name, String sex, String birth, String address, String phone) {
        this.reader_id = reader_id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
    }

    public Integer getReader_id() {
        return reader_id;
    }

    public void setReader_id(Integer reader_id) {
        this.reader_id = reader_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "reader_id=" + reader_id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

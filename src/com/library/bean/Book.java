package com.library.bean;

import org.omg.CORBA.INTERNAL;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ikumiyo
 * @Description
 * @create 2022-10-24-14:49
 */
public class Book {
    private Integer book_id;//图书id
    private String name;//书名
    private String author;//作者
    private String publish;//出版社
    private String ISBN;//标准书号
    private String introduction;//简介
    private String language;//语言
    private BigDecimal price;//价格
    private String pub_date;//出版时间
    private int class_id;//分类号
    private int number;//剩余数量

    public Book() {
    }

    public Book(String name, String author, String publish, String ISBN, String introduction, String language, BigDecimal price, String pub_date, int class_id, int number) {
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.ISBN = ISBN;
        this.introduction = introduction;
        this.language = language;
        this.price = price;
        this.pub_date = pub_date;
        this.class_id = class_id;
        this.number = number;
    }

    public Book(Integer book_id, String name, String author, String publish, String ISBN, String introduction, String language, BigDecimal price, String pub_date, int class_id, int number) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.ISBN = ISBN;
        this.introduction = introduction;
        this.language = language;
        this.price = price;
        this.pub_date = pub_date;
        this.class_id = class_id;
        this.number = number;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPub_date() {
        return pub_date;
    }

    public void setPub_date(String pub_date) {
        this.pub_date = pub_date;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", introduction='" + introduction + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                ", pub_date=" + pub_date +
                ", class_id=" + class_id +
                ", number=" + number +
                '}';
    }

}
